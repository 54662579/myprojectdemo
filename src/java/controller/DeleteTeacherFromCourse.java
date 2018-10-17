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
import model.add.DAOEntities;
import model.add.DAOEntitiesImp;

/**
 *
 * @author Dev
 */
@WebServlet("/teacher_course/*")
public class DeleteTeacherFromCourse extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int tId = Integer.parseInt(request.getParameter("tid"));
        int cId = Integer.parseInt(request.getParameter("cid"));
        DAOEntities daoEntity = new DAOEntitiesImp();
        daoEntity.removeTeacherFromCourse(tId, cId);
        RequestDispatcher dp = request.getRequestDispatcher("/view/confirmdelete.jsp");
        dp.forward(request, response);
    }
    
}
