/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.course.Course;
import model.course.DAOCourse;
import model.course.DAOCourseImp;
import model.result.Result;
import model.student.Student;
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
@WebServlet("/course_detail/*")
public class CourseDetail extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOCourse daoCourse = new DAOCourseImp();
        Course c = daoCourse.findCourse(passId);
        request.setAttribute("courseInfo", c);
        List<Student> students = daoCourse.findStudents(passId);
        request.setAttribute("students", students);
        List<Teacher> teachers = daoCourse.findTeachers(passId);
        request.setAttribute("teachers", teachers);
        List<Result> results = daoCourse.findResult(passId);
        request.setAttribute("results", results);
        RequestDispatcher rs = request.getRequestDispatcher("/view/course/coursedetail.jsp");
        rs.forward(request, response);
    
    }
}
