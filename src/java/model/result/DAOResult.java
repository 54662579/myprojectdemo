/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.result;

import java.util.List;
import model.course.Course;
import model.student.Student;

/**
 *
 * @author Dev
 */
public interface DAOResult {
    boolean addResult(Result r);
    void deleteResult(int id);
    boolean updateResult(Result r, int id);
    List<Result> showAllResult();
    Result findResult(int id);
}
