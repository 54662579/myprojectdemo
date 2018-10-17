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
import model.result.DAOResult;
import model.result.DAOResultImp;

/**
 *
 * @author Dev
 */
@WebServlet("/delete_result/*")
public class DeleteResult extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOResult daoResult = new DAOResultImp();
        daoResult.deleteResult(passId);
        RequestDispatcher rs = request.getRequestDispatcher("/view/confirmdelete.jsp");
        rs.forward(request, response); 
    }
}
