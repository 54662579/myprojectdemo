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
        <title>Edit Teacher</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp"/>
            </div>
            <div class="main">
                <h3 class="header">Edit Teacher</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <c:set var="t" value="${requestScope.editTeacher}"/>
                <form action="<%=request.getContextPath()%>/edit_teacher" method="Post">
                    <h4>ID: <c:out value="${t.id}"/></h4>
                    <input type="hidden" name="id" value="${t.id}">
                    First Name<input type="text" name="firstname" value="${t.firstName}" required>
                    Last Name<input type="text" name="lastname" value="${t.lastName}" required>
                    Address <input type="text" name="address" value="${t.address}" required>
                    City<input type="text" name="city" value="${t.city}" required>
                    Phone Number <input type="tel" name="pnumber" value="${t.phoneNumber}" required>
                    Salary<input type="number" name="salary" value="${t.salary}" required>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>
