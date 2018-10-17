/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
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
@WebServlet("/course_add")
public class AddCourse extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("/view/course/addcourse.jsp");
        rs.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course c = new Course();
        c.setCourseName(request.getParameter("cname"));
        c.setCourseDes(request.getParameter("cdescription"));
        c.setCourseCode(request.getParameter("ccode"));
        c.setCreditNumber(Integer.parseInt(request.getParameter("cnumber")));
        DAOCourse daoCourse = new DAOCourseImp();
        if (daoCourse.addCourse(c)) {
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
    }

}
