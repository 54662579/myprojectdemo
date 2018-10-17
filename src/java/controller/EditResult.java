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
import model.course.Course;
import model.course.DAOCourse;
import model.course.DAOCourseImp;
import model.result.DAOResult;
import model.result.DAOResultImp;
import model.result.Result;
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;

/**
 *
 * @author Dev
 */
@WebServlet("/edit_result/*")
public class EditResult extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOResult daoResult = new DAOResultImp();
        Result r = daoResult.findResult(passId);
        request.setAttribute("result", r);
        DAOStudent daoStudent = new DAOStudentImp();
        List<Student> sts = daoStudent.showAllStudent();
        request.setAttribute("students", sts);
        DAOCourse daoCourse = new DAOCourseImp();
        List<Course> cs = daoCourse.showAllCourse();
        request.setAttribute("courses", cs);
        RequestDispatcher rs = request.getRequestDispatcher("/view/result/editresult.jsp");
        rs.forward(request, response);    
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int passId = Integer.parseInt(request.getParameter("rid"));
        DAOResult daoResult = new DAOResultImp();
        Result r = daoResult.findResult(passId);
        DAOStudent daoStudent = new DAOStudentImp();
        Student s = daoStudent.findStudent(Integer.parseInt(request.getParameter("student")));
        DAOCourse daoCourse = new DAOCourseImp();
        Course c = daoCourse.findCourse(Integer.parseInt(request.getParameter("course")));
        r.setStudent(s);
        r.setCourse(c);
        r.setSessionNumber(Integer.parseInt(request.getParameter("session")));
        r.setMark(Integer.parseInt(request.getParameter("mark")));
        if (daoResult.updateResult(r, passId)){
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
    }
}
