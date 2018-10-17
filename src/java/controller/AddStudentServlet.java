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

/**
 *
 * @author Dev
 */
@WebServlet("/student_add")
public class AddStudentServlet extends HttpServlet {
    
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rs = request.getRequestDispatcher("/view/student/addstudent.jsp");
        rs.forward(request, response);
    }
    
    
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Student s = new Student();
        s.setFirstName(request.getParameter("firstname"));
        s.setLastName(request.getParameter("lastname"));
        s.setGender(request.getParameter("gender"));
        s.setOrganisation(request.getParameter("org"));
        s.setAddress(request.getParameter("address"));
        s.setCity(request.getParameter("city"));
        s.setProvince(request.getParameter("province"));
        s.setCountry(request.getParameter("country"));
        s.setZipcode(request.getParameter("zipcode"));
        s.setPhoneNumber(request.getParameter("pnumber"));
        s.setEmail(request.getParameter("email"));
        s.setMajor(request.getParameter("major"));
        s.setDateOfBirth(request.getParameter("dob"));
        DAOStudent daoStudent = new DAOStudentImp();
        if (daoStudent.addStudent(s)){
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
        
    }
}
