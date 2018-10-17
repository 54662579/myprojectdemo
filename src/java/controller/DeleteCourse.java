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
import model.course.DAOCourse;
import model.course.DAOCourseImp;

/**
 *
 * @author Dev
 */
@WebServlet("/delete_course/*")
public class DeleteCourse extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOCourse daoCourse = new DAOCourseImp();
        daoCourse.deleteCourse(passId);
        RequestDispatcher rs = request.getRequestDispatcher("/view/confirmdelete.jsp");
        rs.forward(request, response); 
    }
    
}
