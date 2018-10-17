/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.add;

import java.util.List;
import model.course.Course;
import model.result.Result;
import model.student.Student;
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
public interface DAOEntities {
    boolean addStudentToCourse(int sId, int cId);
    boolean addTeacherToCourse(int tId, int cId);
    boolean removeStudentFromCourse(int sId, int cId);
    boolean removeTeacherFromCourse(int tId, int cId);
    List<Result> findResults(int id);

    
    
   
    
}
