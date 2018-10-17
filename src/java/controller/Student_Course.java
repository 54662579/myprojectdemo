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
import model.course.DAOCourse;
import model.course.DAOCourseImp;
import model.student.DAOStudent;
import model.student.DAOStudentImp;
import model.student.Student;

/**
 *
 * @author Dev
 */
@WebServlet("/course_add_student")
public class Student_Course extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DAOStudent daoStudent = new DAOStudentImp();
        List<Student> sts = daoStudent.showAllStudent();
        request.setAttribute("students", sts);
        DAOCourse daoCourse = new DAOCourseImp();
        List<Course> cs = daoCourse.showAllCourse();
        request.setAttribute("courses", cs);
        if (!sts.isEmpty() && !cs.isEmpty()) {
            RequestDispatcher dp = request.getRequestDispatcher("/view/addto/student_course.jsp");
            dp.forward(request, response);
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
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int sId = Integer.parseInt(request.getParameter("student"));
        int cId = Integer.parseInt(request.getParameter("course"));
        DAOEntities daoEn = new DAOEntitiesImp();
        if (daoEn.addStudentToCourse(sId, cId)){
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
        
        
    }
    
}
