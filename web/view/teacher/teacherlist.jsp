<%-- 
    Document   : teacherlist
    Created on : 21-Jun-2018, 9:12:39 AM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.teacher.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Teacher List</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">   
                <h3 class="header">Teacher List</h3>
                <table border="2">
                    <tr>
                        <th>Teacher ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Phone Number</th>
                        <th>Salary</th>
                        <th colspan="3"></th>
                    </tr>
                    <c:forEach var="tList" items="${requestScope.teacherList}">
                        <tr>
                            <td><c:out value="${tList.id}">null</c:out></td>
                            <td><c:out value="${tList.firstName}">null</c:out></td>
                            <td><c:out value="${tList.lastName}">null</c:out></td>
                            <td><c:out value="${tList.address}">null</c:out></td>
                            <td><c:out value="${tList.city}">null</c:out></td>
                            <td><c:out value="${tList.phoneNumber}">null</c:out></td>
                            <td>
                            <fmt:formatNumber type="currency" value="${tList.salary}"/>
                            </td>
                            <td><a href="<%=request.getContextPath()%>/teacher_detail/${tList.id}">Show Detail</a></td>
                            <td><a href="<%=request.getContextPath()%>/edit_teacher/${tList.id}">Edit</a></td>
                            <td><a href="<%=request.getContextPath()%>/delete_teacher/${tList.id}" 
                                   onclick="confirm('Are you sure you want to delete a teacher?')">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
