<%-- 
    Document   : addteacher
    Created on : 21-Jun-2018, 8:56:58 AM
    Author     : Dev
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Add Teacher</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp"/>
            </div>
            <div class="main">
                <h3 class="header">Add Teacher</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <form action="<%=request.getContextPath()%>/teacher_add" method="Post">
                    First Name<input type="text" name="firstname" required>
                    Last Name<input type="text" name="lastname" required>
                    Address <input type="text" name="address" required>
                    City<input type="text" name="city" required>
                    Phone Number <input type="tel" name="pnumber" required>
                    Salary<input type="number" name="salary" required>
                    <input type="submit" value="Add" required>
            </div>
        </div>
    </body>
</html>
