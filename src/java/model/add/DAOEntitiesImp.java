/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.course.Course;
import model.course.DAOCourse;
import model.course.DAOCourseImp;
import model.result.DAOResultImp;
import model.result.Result;
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;
import model.teacher.DAOTeacher;
import model.teacher.DAOTeacherImp;
import model.teacher.Teacher;
import oracle.net.aso.s;
import util.DBConnection;

/**
 *
 * @author Dev
 */
public class DAOEntitiesImp implements DAOEntities {

    @Override
    public boolean addStudentToCourse(int sId, int cId) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "insert into student_course values ( ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sId);
            pst.setInt(2, cId);
            pst.executeQuery();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean addTeacherToCourse(int tId, int cId) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "insert into teacher_course values ( ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, tId);
            pst.setInt(2, cId);
            pst.executeQuery();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeStudentFromCourse(int sId, int cId) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE from STUDENT_COURSE where student_id = ? AND course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sId);
            pst.setInt(2, cId);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeTeacherFromCourse(int tId, int cId) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE from TEACHER_COURSE where teacher_id = ? AND course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, tId);
            pst.setInt(2, cId);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<Result> findResults(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT result_id, student_id, course_id, session_number, "
                    + "mark from results where student_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            DAOStudent daoStudent = new DAOStudentImp();
            Map<Integer, Student> students = new HashMap<Integer, Student>();
            for (Student s : daoStudent.showAllStudent()) {
                students.put(s.getId(), s);
            }

            DAOCourse daoCourse = new DAOCourseImp();
            Map<Integer, Course> courses = new HashMap<Integer, Course>();
            for (Course c : daoCourse.showAllCourse()) {
                courses.put(c.getId(), c);
            }

            List<Result> results = new ArrayList();
            while (rs.next()) {
                Result r = new Result();
                r.setId(rs.getInt(1));
                r.setStudent(students.get(rs.getInt(2)));
                r.setCourse(courses.get(rs.getInt(3)));
                r.setSessionNumber(rs.getInt(4));
                r.setMark(rs.getInt(5));
                results.add(r);
            }
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

    
}
