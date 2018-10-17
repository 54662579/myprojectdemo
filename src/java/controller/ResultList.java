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
import model.result.DAOResult;
import model.result.DAOResultImp;
import model.result.Result;

/**
 *
 * @author Dev
 */
@WebServlet("/result_list")
public class ResultList extends HttpServlet{
        
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOResult daoResult = new DAOResultImp();
        List<Result> results = daoResult.showAllResult();
        request.setAttribute("results", results);
        RequestDispatcher rs = request.getRequestDispatcher("/view/result/resultlist.jsp");
        rs.forward(request, response);
    }
}
