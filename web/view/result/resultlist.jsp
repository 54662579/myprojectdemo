<%-- 
    Document   : student_course
    Created on : 22-Jun-2018, 10:43:33 AM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.student.Student"%>
<%@page import="model.course.Course"%>
<%@page import="model.result.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Result List</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Result List</h3>
                <table border="2">
                    <tr>
                        <th>Result ID</th>
                        <th>Student ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Course ID</th>
                        <th>Course Name</th>
                        <th>Session Number</th>
                        <th>Mark</th>
                        <th colspan="2"></th>
                    </tr>
                    <c:forEach items="${requestScope.results}" var="r">
                        <tr>
                            <td><c:out value="${r.id}">null</c:out></td>
                            <td><c:out value="${r.student.id}">null</c:out></td>
                            <td><c:out value="${r.student.firstName}">null</c:out></td>
                            <td><c:out value="${r.student.lastName}">null</c:out></td>
                            <td><c:out value="${r.course.id}">null</c:out></td>
                            <td><c:out value="${r.course.courseName}">null</c:out></td>
                            <td><c:out value="${r.sessionNumber}">null</c:out></td>
                            <td><c:out value="${r.mark}">null</c:out></td>
                            <td><a href="<%=request.getContextPath()%>/edit_result/${r.id}">Edit</a></td>
                            <td><a href="<%=request.getContextPath()%>/delete_result/${r.id}" 
                                   onclick="confirm('Are you sure you want to delete this result?')">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </body>
</html>
