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
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;
import java.util.List;

/**
 *
 * @author Dev
 */
@WebServlet("/student_list")
public class StudentList extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOStudent daoStudent = new DAOStudentImp();
        List<Student> stds = daoStudent.showAllStudent();
        request.setAttribute("studentList", stds);
        RequestDispatcher dp = request.getRequestDispatcher("view/student/studentlist.jsp");
        dp.forward(request, response);
    }
}
