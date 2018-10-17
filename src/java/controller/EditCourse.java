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
@WebServlet("/edit_course/*")
public class EditCourse extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOCourse daoCourse = new DAOCourseImp();
        Course c = daoCourse.findCourse(passId);
        request.setAttribute("editCourse", c);
        RequestDispatcher rs = request.getRequestDispatcher("/view/course/editcourse.jsp");
        rs.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int passId = Integer.parseInt(request.getParameter("id"));
        DAOCourse daoCourse = new DAOCourseImp();
        Course c = daoCourse.findCourse(passId);
        c.setCourseName(request.getParameter("cname"));
        c.setCourseDes(request.getParameter("cdescription"));
        c.setCourseCode(request.getParameter("ccode"));
        c.setCreditNumber(Integer.parseInt(request.getParameter("cnumber")));
        if (daoCourse.updateCourse(c, passId)) {
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
    }

}
