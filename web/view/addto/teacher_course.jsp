<%-- 
    Document   : teacher_course
    Created on : 22-Jun-2018, 12:11:41 PM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.teacher.Teacher"%>
<%@page import="model.course.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Add Teacher to Course</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Add Teacher to Course </h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <form action="<%=request.getContextPath()%>/course_add_teacher" method="Post">
                    <select name="teacher" required>
                        <c:forEach items="${requestScope.teachers}" var="t">
                            <option value="${t.id}">${t.id} ${t.firstName} ${t.lastName}</option>
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
