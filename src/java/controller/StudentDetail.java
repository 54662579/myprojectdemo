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
import model.add.DAOEntities;
import model.add.DAOEntitiesImp;
import model.course.Course;
import model.result.Result;
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;

/**
 *
 * @author Dev
 */
@WebServlet("/student_detail/*")
public class StudentDetail extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOStudent daoStudent = new DAOStudentImp();
        Student s = daoStudent.findStudent(passId);
        request.setAttribute("studentInfo", s);
        DAOEntities daoEntity = new DAOEntitiesImp();
        List<Result> results = daoEntity.findResults(passId);
        request.setAttribute("result", results);
        List<Course> courses = daoStudent.findCourses(passId);
        request.setAttribute("course", courses);
        RequestDispatcher rs = request.getRequestDispatcher("/view/student/studentdetail.jsp");
        rs.forward(request, response);
    }
    
}
