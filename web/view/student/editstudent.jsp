<%-- 
    Document   : addstudent
    Created on : 14-Jun-2018, 10:45:17 AM
    Author     : Dev
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Edit Student</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp"/>
            </div>
            <div class="main">
                <h3 class="header">Edit Student</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <c:set var="student" value="${requestScope.editStudent}"/>
                <form action="<%=request.getContextPath()%>/edit_student" method="Post">
                    <h4>ID: <c:out value="${student.id}"/></h4>
                    <input type="hidden" name="id" value="${student.id}">
                    First Name<input type="text" name="firstname" value="${student.firstName}" required>
                    Last Name<input type="text" name="lastname" value="${student.lastName}" required>
                    Gender
                    <select name="gender" value="${student.gender}" required>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                    University/Organization<input type="text" name="org" value="${student.organisation}" required>
                    Address <input type="text" name="address" value="${student.address}" required>
                    City<input type="text" name="city" value="${student.city}" required>
                    Province<input type="text" name="province" value="${student.province}" required>
                    Country<input type="text" name="country" value="${student.country}" required>
                    Zip Code<input type="text" name="zipcode" value="${student.zipcode}" required>
                    Phone Number <input type="tel" name="pnumber" value="${student.phoneNumber}" required>
                    Email <input type="email" name="email" value="${student.email}" required>
                    Major<input type="text" name="major" value="${student.major}" required>
                    Date of Birth <input type="date" name="dob" value="${student.dateOfBirth}" required>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>
