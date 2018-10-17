/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.course;

import java.util.List;
import model.result.Result;
import model.student.Student;
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
public interface DAOCourse {
    boolean addCourse(Course c);
    List<Course> showAllCourse();
    Course findCourse(int id);
    List<Student> findStudents(int id);
    List<Teacher> findTeachers(int id);
    List<Result> findResult(int id);
    boolean updateCourse(Course c, int id);
    void deleteCourse(int id);
}
