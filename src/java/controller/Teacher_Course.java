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
import model.teacher.DAOTeacher;
import model.teacher.DAOTeacherImp;
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
@WebServlet("/course_add_teacher")
public class Teacher_Course extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DAOTeacher daoTeacher = new DAOTeacherImp();
        List<Teacher> ts = daoTeacher.showAllTeacher();
        request.setAttribute("teachers", ts);
        DAOCourse daoCourse = new DAOCourseImp();
        List<Course> cs = daoCourse.showAllCourse();
        request.setAttribute("courses", cs);
        if (!ts.isEmpty() && !cs.isEmpty()) {
            RequestDispatcher dp = request.getRequestDispatcher("/view/addto/teacher_course.jsp");
            dp.forward(request, response);
        } else if (ts.isEmpty() || cs.isEmpty()) {
            if (ts.isEmpty()) {
                RequestDispatcher dp = request.getRequestDispatcher("/teacher_add");
                dp.forward(request, response);
            } else if (cs.isEmpty()) {
                RequestDispatcher dp = request.getRequestDispatcher("/course_add");
                dp.forward(request, response);
            }
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int tId = Integer.parseInt(request.getParameter("teacher"));
        int cId = Integer.parseInt(request.getParameter("course"));
        DAOEntities daoEn = new DAOEntitiesImp();
        if (daoEn.addTeacherToCourse(tId, cId)){
            RequestDispatcher dp = request.getRequestDispatcher("/view/confirmPage.jsp");
            dp.forward(request, response);
        } else {
            request.setAttribute("error", "Could not save data.");
            this.doGet(request, response);
        }
        
        
    }
}
