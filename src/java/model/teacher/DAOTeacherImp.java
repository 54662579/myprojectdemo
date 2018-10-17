/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.teacher;

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
import model.course.Course;
import model.course.DAOCourse;
import model.course.DAOCourseImp;
import util.DBConnection;

/**
 *
 * @author Dev
 */
public class DAOTeacherImp implements DAOTeacher {

    @Override
    public boolean addTeacher(Teacher t) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO TEACHERS values (TEACHERS_SEQ.NEXTVAL, "
                    + "?, ?, ?, ?, ?, ?, sysdate)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getFirstName());
            pst.setString(2, t.getLastName());
            pst.setString(3, t.getAddress());
            pst.setString(4, t.getCity());
            pst.setString(5, t.getPhoneNumber());
            pst.setInt(6, t.getSalary());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Teacher> showAllTeacher() {
        List<Teacher> ts = new ArrayList();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT TEACHER_ID, FIRST_NAME, LAST_NAME, ADDRESS, "
                    + "CITY, PHONE_NUMBER, SALARY from TEACHERS";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Teacher t = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                ts.add(t);
            }
            return ts;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Teacher findTeacher(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT TEACHER_ID, FIRST_NAME, LAST_NAME, ADDRESS, "
                    + "CITY, PHONE_NUMBER, SALARY from TEACHERS where "
                    + "TEACHER_ID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Teacher t = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher t, int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE TEACHERS set FIRST_NAME = ?, LAST_NAME = ?, "
                    + "ADDRESS = ?, CITY = ?, PHONE_NUMBER = ?, SALARY = ? "
                    + "where TEACHER_ID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getFirstName());
            pst.setString(2, t.getLastName());
            pst.setString(3, t.getAddress());
            pst.setString(4, t.getCity());
            pst.setString(5, t.getPhoneNumber());
            pst.setInt(6, t.getSalary());
            pst.setInt(7, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public void deleteTeacher(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM TEACHERS where teacher_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Course> findCourses(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT course_id from teacher_course where teacher_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);        
            List<Course> courses = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                DAOCourse daoCourse = new DAOCourseImp();
                Course c = daoCourse.findCourse(rs.getInt(1));
                courses.add(c);                
            } return courses;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
