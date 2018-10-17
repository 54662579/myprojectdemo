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
@WebServlet("/result_add")
public class AddResult extends HttpServlet {
    
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOStudent daoStudent = new DAOStudentImp();
        List<Student> sts = daoStudent.showAllStudent();
        request.setAttribute("students", sts);
        DAOCourse daoCourse = new DAOCourseImp();
        List<Course> cs = daoCourse.showAllCourse();
        request.setAttribute("courses", cs);
        if (!sts.isEmpty() && !cs.isEmpty()) {
            RequestDispatcher rs = request.getRequestDispatcher("/view/result/addresult.jsp");
            rs.forward(request, response);
        } else if (sts.isEmpty() || cs.isEmpty()) {
            if (sts.isEmpty()) {
                RequestDispatcher dp = request.getRequestDispatcher("/student_add");
                dp.forward(request, response);
            } else if (cs.isEmpty()) {
                RequestDispatcher dp = request.getRequestDispatcher("/course_add");
                dp.forward(request, response);
            }
        }
    }
    
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int sId = Integer.parseInt(request.getParameter("student"));
        int cId = Integer.parseInt(request.getParameter("course"));
        DAOStudent daoStudent = new DAOStudentImp();
        Student s = daoStudent.findStudent(sId);
        DAOCourse daoCourse = new DAOCourseImp();
        Course c = daoCourse.findCourse(cId);
        Result r = new Result();
        r.setStudent(s);
        r.setCourse(c);
        r.setSessionNumber(Integer.parseInt(request.getParameter("session")));
        r.setMark(Integer.parseInt(request.getParameter("mark")));
        DAOResult daoResult = new DAOResultImp();
        if (daoResult.addResult(r)){
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
    }
}
