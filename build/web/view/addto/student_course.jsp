<%-- 
    Document   : student_course
    Created on : 22-Jun-2018, 10:43:33 AM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.student.Student"%>
<%@page import="model.course.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Add Student to Course</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Add Student to Course </h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <form action="<%=request.getContextPath()%>/course_add_student" method="Post">
                    <select name="student" required>
                        <c:forEach items="${requestScope.students}" var="s">
                            <option value="${s.id}">${s.id} ${s.firstName} ${s.lastName}</option>
                        </c:forEach>
                    </select>
                    to 
                    <select name="course" required>
                        <c:forEach items="${requestScope.courses}" var="c">
                            <option value="${c.id}">${c.courseName}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Add">
                </form>
            </div>
        </div>
    </body>
</html>
