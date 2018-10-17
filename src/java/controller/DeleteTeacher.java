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
import model.teacher.DAOTeacher;
import model.teacher.DAOTeacherImp;

/**
 *
 * @author Dev
 */
@WebServlet("/delete_teacher/*")
public class DeleteTeacher extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOTeacher daoTeacher = new DAOTeacherImp();
        daoTeacher.deleteTeacher(passId);
        RequestDispatcher rs = request.getRequestDispatcher("/view/confirmdelete.jsp");
        rs.forward(request, response);
    }
}
