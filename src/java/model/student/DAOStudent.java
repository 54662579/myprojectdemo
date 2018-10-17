/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.student;

import java.util.List;
import model.course.Course;

/**
 *
 * @author Dev
 */
public interface DAOStudent {
    boolean addStudent(Student s);
    List<Student> showAllStudent();
    Student findStudent(int id);
    List<Course> findCourses(int id);
    boolean updateStudent(Student s, int id);
    void deleteStudent(int id);
}
