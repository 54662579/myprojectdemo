<%-- 
    Document   : editteacher
    Created on : 21-Jun-2018, 9:44:49 AM
    Author     : Dev
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Edit Course</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp"/>
            </div>
            <div class="main">
                <h3 class="header">Edit Course</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <c:set var="c" value="${requestScope.editCourse}"/>
                <form action="<%=request.getContextPath()%>/edit_course" method="Post">
                    <h4>ID: <c:out value="${c.id}"/></h4>
                    <input type="hidden" name="id" value="${c.id}">
                    Course Name<input type="text" name="cname" value="${c.courseName}" required>
                    Course Description<textarea name="cdescription" style="height:200px" 
                                                value="${c.courseDes}" required></textarea>
                    Course Code<input type="text" name="ccode" value="${c.courseCode}" required>
                    Credit Number<input type="number" min="1" max="8" name="cnumber" value="${c.creditNumber}" required>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>
