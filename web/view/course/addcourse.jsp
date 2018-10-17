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
        <title>Add Course</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp"/>
            </div>
            <div class="main">
                <h3 class="header">Add Course</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <form action="<%=request.getContextPath()%>/course_add" method="Post">
                    Course Name<input type="text" name="cname" required>
                    Course Description<textarea name="cdescription" style="height:200px" required></textarea>
                    Course Code<input type="text" name="ccode" required>
                    Credit Number<input type="number" min="1" max="8" name="cnumber" required>
                    <input type="submit" value="Add">
                </form>
            </div>
        </div>
    </body>
</html>
