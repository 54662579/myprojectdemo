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
import model.teacher.DAOTeacher;
import model.teacher.DAOTeacherImp;
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
@WebServlet("/teacher_list")
public class TeacherList extends HttpServlet{
        
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOTeacher daoTeacher = new DAOTeacherImp();
        List<Teacher> ts = daoTeacher.showAllTeacher();
        request.setAttribute("teacherList", ts);
        RequestDispatcher dp = request.getRequestDispatcher("/view/teacher/teacherlist.jsp");
        dp.forward(request, response);
    }
    
}
