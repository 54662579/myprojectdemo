/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.student;

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
public class DAOStudentImp implements DAOStudent {

    @Override
    public boolean addStudent(Student s) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO STUDENTS values (STUDENTS_SEQ.nextval, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, s.getFirstName());
            pst.setString(2, s.getLastName());
            pst.setString(3, s.getGender());
            pst.setString(4, s.getOrganisation());
            pst.setString(5, s.getAddress());
            pst.setString(6, s.getCity());
            pst.setString(7, s.getProvince());
            pst.setString(8, s.getCountry());
            pst.setString(9, s.getZipcode());
            pst.setString(10, s.getPhoneNumber());
            pst.setString(11, s.getEmail());
            pst.setString(12, s.getMajor());
            pst.setString(13, s.getDateOfBirth());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (NullPointerException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Student> showAllStudent() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT STUDENT_ID, FIRST_NAME, LAST_NAME, GENDER, "
                    + "ORAGNISATION, ADDRESS, CITY, PROVINCE, COUNTRY, ZIPCODE, "
                    + "PHONE_NUMBER, EMAIL, MAJOR, DATE_OF_BIRTH from students";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Student> stds = new ArrayList();
            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14));
                stds.add(s);
            }
            return stds;
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student findStudent(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT STUDENT_ID, FIRST_NAME, LAST_NAME, GENDER, "
                    + "ORAGNISATION, ADDRESS, CITY, PROVINCE, COUNTRY, ZIPCODE, "
                    + "PHONE_NUMBER, EMAIL, MAJOR, DATE_OF_BIRTH from students "
                    + "where student_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student s, int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE STUDENTS set FIRST_NAME = ?, LAST_NAME = ?, "
                    + "GENDER = ?, ORAGNISATION = ?, ADDRESS = ?, CITY = ?, "
                    + "PROVINCE = ?, COUNTRY = ?, ZIPCODE = ?, "
                    + "PHONE_NUMBER = ?, EMAIL = ?, MAJOR = ?, DATE_OF_BIRTH = ? "
                    + "where student_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, s.getFirstName());
            pst.setString(2, s.getLastName());
            pst.setString(3, s.getGender());
            pst.setString(4, s.getOrganisation());
            pst.setString(5, s.getAddress());
            pst.setString(6, s.getCity());
            pst.setString(7, s.getProvince());
            pst.setString(8, s.getCountry());
            pst.setString(9, s.getZipcode());
            pst.setString(10, s.getPhoneNumber());
            pst.setString(11, s.getEmail());
            pst.setString(12, s.getMajor());
            pst.setString(13, s.getDateOfBirth());
            pst.setInt(14, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM students where student_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();;
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOStudentImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Course> findCourses(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT course_id from student_course where student_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            List<Course> courses = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DAOCourse daoCourse = new DAOCourseImp();
                Course c = daoCourse.findCourse(rs.getInt(1));
                courses.add(c);
            }
            return courses;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEntitiesImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
