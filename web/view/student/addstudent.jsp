<%-- 
    Document   : addstudent
    Created on : 14-Jun-2018, 10:45:17 AM
    Author     : Dev
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Add Student</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp"/>
            </div>
            <div class="main">
                <h3 class="header">Add Student</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <form action="<%=request.getContextPath()%>/student_add" method="Post">
                    First Name<input type="text" name="firstname" required>
                    Last Name<input type="text" name="lastname" required>
                    Gender
                    <select name="gender" required>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                    University/Organization<input type="text" name="org" required>
                    Address <input type="text" name="address" required>
                    City<input type="text" name="city" required>
                    Province<input type="text" name="province" required>
                    Country<input type="text" name="country" required>
                    Zip Code<input type="text" name="zipcode" required>
                    Phone Number <input type="tel" name="pnumber" required>
                    Email <input type="email" name="email" required>
                    Major<input type="text" name="major" required>
                    Date of Birth <input type="date" name="dob" required>
                    <input type="submit" value="Add">
                </form>
            </div>
        </div>
    </body>
</html>
