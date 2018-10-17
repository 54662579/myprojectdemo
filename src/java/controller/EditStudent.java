/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Enumeration;
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
@WebServlet("/edit_student/*")
public class EditStudent extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOStudent daoStudent = new DAOStudentImp();
        Student s = daoStudent.findStudent(passId);
        request.setAttribute("editStudent", s);
        RequestDispatcher rs = request.getRequestDispatcher("/view/student/editstudent.jsp");
        rs.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int passId = Integer.parseInt(request.getParameter("id"));
        DAOStudent daoStudent = new DAOStudentImp();
        Student s = daoStudent.findStudent(passId);
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
        if (daoStudent.updateStudent(s, passId)){
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
    }
}
