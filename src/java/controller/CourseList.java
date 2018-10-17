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

/**
 *
 * @author Dev
 */
@WebServlet("/course_list")
public class CourseList extends HttpServlet{
        
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOCourse daoCourse = new DAOCourseImp();
        List<Course> cs = daoCourse.showAllCourse();
        request.setAttribute("courseList", cs);
        RequestDispatcher dp = request.getRequestDispatcher("/view/course/courselist.jsp");
        dp.forward(request, response);
    
    }
    
}
