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
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
@WebServlet("/teacher_add")
public class AddTeacherServlet extends HttpServlet {
    
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rs = request.getRequestDispatcher("/view/teacher/addteacher.jsp");
        rs.forward(request, response);
    }
    
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Teacher t = new Teacher();
        t.setFirstName(request.getParameter("firstname"));
        t.setLastName(request.getParameter("lastname"));
        t.setAddress(request.getParameter("address"));
        t.setCity(request.getParameter("city"));
        t.setPhoneNumber(request.getParameter("pnumber"));
        t.setSalary(Integer.parseInt(request.getParameter("salary")));
        DAOTeacher daoTeacher = new DAOTeacherImp();
        if (daoTeacher.addTeacher(t)){
        RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
        dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
    }
}
