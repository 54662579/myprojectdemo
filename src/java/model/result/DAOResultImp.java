/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.course.Course;
import model.course.DAOCourse;
import model.course.DAOCourseImp;
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;
import util.DBConnection;

/**
 *
 * @author Dev
 */
public class DAOResultImp implements DAOResult {

    @Override
    public boolean addResult(Result r) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO RESULTS VALUES (RESULTS_SEQ.nextval, ?, ?, "
                    + "?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, r.getStudent().getId());
            pst.setInt(2, r.getCourse().getId());
            pst.setInt(3, r.getSessionNumber());
            pst.setInt(4, r.getMark());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
             return true;
    }

    @Override
    public List<Result> showAllResult() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT RESULT_ID, STUDENT_ID, COURSE_ID, "
                    + "SESSION_NUMBER, MARK from results";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            DAOStudent daoStudent = new DAOStudentImp();         
            Map<Integer,Student> students = new HashMap<Integer,Student>();
            for (Student s : daoStudent.showAllStudent()) {
                students.put(s.getId(),s);
            }
            
            DAOCourse daoCourse = new DAOCourseImp();
            Map<Integer, Course> courses = new HashMap<Integer,Course>();
            for (Course c : daoCourse.showAllCourse()){
                courses.put(c.getId(),c);
            }
                
            List<Result> results = new ArrayList();
            while (rs.next()){
                Result r  = new Result();
                r.setId(rs.getInt(1));
                r.setStudent(students.get(rs.getInt(2)));
                r.setCourse(courses.get(rs.getInt(3)));
                r.setSessionNumber(rs.getInt(4));
                r.setMark(rs.getInt(5));
                results.add(r);               
            } return results;
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteResult(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE RESULTS where result_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean updateResult(Result r, int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE results set student_id = ?, course_id = ?, "
                    + "session_number = ?, mark = ? where result_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, r.getStudent().getId());
            pst.setInt(2, r.getCourse().getId());
            pst.setInt(3, r.getSessionNumber());
            pst.setInt(4, r.getMark());
            pst.setInt(5, r.getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
             return true;
    }

    @Override
    public Result findResult(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT result_id, student_id, course_id, session_number, "
                    + "mark from results where result_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Result r = new Result();
                r.setId(rs.getInt(1));
                DAOStudent daoStudent = new DAOStudentImp();
                Student s = daoStudent.findStudent(rs.getInt(2));
                r.setStudent(s);
                DAOCourse daoCourse = new DAOCourseImp();
                Course c = daoCourse.findCourse(rs.getInt(3));
                r.setCourse(c);
                r.setSessionNumber(rs.getInt(4));
                r.setMark(rs.getInt(5));
                return r;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOResultImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
}
