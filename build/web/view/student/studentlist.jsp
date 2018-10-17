<%-- 
    Document   : showstudent
    Created on : 15-Jun-2018, 2:37:50 PM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.student.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Student List</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <c:set var="pageName" value="studentList" scope="request"/>
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Student List</h3>
                <table border="2">
                    <tr>
                        <th>Student ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Phone Number</th>
                        <th>Major</th>
                        <th colspan="3"></th>
                    </tr>
                    <c:forEach var="sList" items="${requestScope.studentList}" >
                        <tr>
                            <td><c:out value="${sList.id}">null</c:out></td>
                            <td><c:out value="${sList.firstName}">null</c:out></td>
                            <td><c:out value="${sList.lastName}">null</c:out></td>
                            <td><c:out value="${sList.address}">null</c:out></td>
                            <td><c:out value="${sList.city}">null</c:out></td>
                            <td><c:out value="${sList.country}">null</c:out></td>
                            <td><c:out value="${sList.phoneNumber}">null</c:out></td>
                            <td><c:out value="${sList.major}">null</c:out></td>
                            <td><a href="<%=request.getContextPath()%>/student_detail/${sList.id}">Show Detail</a></td>
                            <td><a href="<%=request.getContextPath()%>/edit_student/${sList.id}">Edit</a></td>
                            <td><a href="<%=request.getContextPath()%>/delete_student/${sList.id}"
                                   onclick="confirm('Are you sure you want to delete a student?')">Delete</a></td>
                        </tr>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
