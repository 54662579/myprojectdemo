<%-- 
    Document   : teacherlist
    Created on : 21-Jun-2018, 9:12:39 AM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.course.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Course List</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">   
                <h3 class="header">Course List</h3>
                <table border="2">
                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                        <th>Course Description</th>
                        <th>Course Code</th>
                        <th>Credit Number</th>
                        <th colspan="3"></th>
                    </tr>
                    <c:forEach var="cList" items="${requestScope.courseList}">
                        <tr>
                            <td><c:out value="${cList.id}">null</c:out></td>
                            <td><c:out value="${cList.courseName}">null</c:out></td>
                            <td><c:out value="${cList.courseDes}">null</c:out></td>
                            <td><c:out value="${cList.courseCode}">null</c:out></td>
                            <td><c:out value="${cList.creditNumber}">null</c:out></td>
                            <td><a href="<%=request.getContextPath()%>/course_detail/${cList.id}">Show Detail</a></td>
                            <td><a href="<%=request.getContextPath()%>/edit_course/${cList.id}">Edit</a></td>
                            <td><a href="<%=request.getContextPath()%>/delete_course/${cList.id}" 
                                   onclick="confirm('Are you sure you want to delete a course?')">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
