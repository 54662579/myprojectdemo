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
import model.teacher.DAOTeacher;
import model.teacher.DAOTeacherImp;
import model.teacher.Teacher;

/**
 *
 * @author Dev
 */
@WebServlet("/teacher_detail/*")
public class TeacherDetail extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getPathInfo();
        int passId = Integer.parseInt(uri.substring(1));
        DAOTeacher daoTeacher = new DAOTeacherImp();
        Teacher t = daoTeacher.findTeacher(passId);
        request.setAttribute("teacherInfo", t);
        List<Course> courses = daoTeacher.findCourses(passId);
        request.setAttribute("course", courses);
        RequestDispatcher rs = request.getRequestDispatcher("/view/teacher/teacherdetail.jsp");
        rs.forward(request, response);
    }
}
