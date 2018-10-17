/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

/**
 *
 * @author Dev
 */
public class Course {
    private int id;
    private String courseName;
    private String courseDes;
    private String courseCode;
    private int creditNumber;

    public Course() {
    }

    public Course(int id, String courseName, String courseDes, String courseCode, int creditNumber) {
        this.id = id;
        this.courseName = courseName;
        this.courseDes = courseDes;
        this.courseCode = courseCode;
        this.creditNumber = creditNumber;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes;
    }
    
    
}
