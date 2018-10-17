/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.add.DAOEntitiesImp;
import model.result.DAOResult;
import model.result.DAOResultImp;
import model.result.Result;
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;
import model.teacher.DAOTeacher;
import model.teacher.DAOTeacherImp;
import model.teacher.Teacher;
import util.DBConnection;

/**
 *
 * @author Dev
 */
public class DAOCourseImp implements DAOCourse {

    @Override
    public boolean addCourse(Course c) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO COURSES values (COURSES_SEQ.NEXTVAL, "
                    + "?, ?, ?, ?, sysdate)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, c.getCourseName());
            pst.setString(2, c.getCourseDes());
            pst.setString(3, c.getCourseCode());
            pst.setInt(4, c.getCreditNumber());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Course> showAllCourse() {
        List<Course> cs = new ArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT course_id, course_name, course_des, course_code, "
                    + "credit_number FROM courses";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Course c = new Course(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5));
                cs.add(c);
            }
            return cs;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Course findCourse(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT course_id, course_name, course_des, course_code, "
                    + "credit_number FROM courses where course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Course c = new Course(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateCourse(Course c, int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE courses set course_name = ?, course_des = ?, "
                    + "course_code = ?, credit_number = ? where course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, c.getCourseName());
            pst.setString(2, c.getCourseDes());
            pst.setString(3, c.getCourseCode());
            pst.setInt(4, c.getCreditNumber());
            pst.setInt(5, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public void deleteCourse(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM courses where course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> findStudents(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT student_id from student_course where course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            List<Student> students = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DAOStudent daoStudent = new DAOStudentImp();
                Student s = daoStudent.findStudent(rs.getInt(1));
                students.add(s);
            } return students;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Teacher> findTeachers(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT teacher_id from teacher_course where course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            List<Teacher> teachers = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DAOTeacher daoTeacher = new DAOTeacherImp();
                Teacher t = daoTeacher.findTeacher(rs.getInt(1));
                teachers.add(t);
            } return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Result> findResult(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "select RESULT_ID, STUDENT_ID, COURSE_ID, "
                    + "SESSION_NUMBER, MARK from results where course_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            List<Result> results = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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
                results.add(r);
            } return results;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCourseImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
