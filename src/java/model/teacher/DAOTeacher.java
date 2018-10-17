/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.teacher;

import model.teacher.Teacher;
import java.util.List;
import model.course.Course;

/**
 *
 * @author Dev
 */
public interface DAOTeacher {
    boolean addTeacher(Teacher t);
    List<Teacher> showAllTeacher();
    Teacher findTeacher(int id);
    List<Course> findCourses(int id);
    boolean updateTeacher(Teacher t, int id);
    void deleteTeacher(int id);
}
