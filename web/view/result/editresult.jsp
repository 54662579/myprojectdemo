<%-- 
    Document   : addresult
    Created on : 22-Jun-2018, 2:38:52 PM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.student.Student"%>
<%@page import="model.course.Course"%>
<%@page import="model.result.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Edit Result</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Edit Result</h3>
                <c:if test="${requestScope.error != null}">
                    <c:out value="${requestScope.error}"/>
                </c:if>
                <c:set var="r" value="${requestScope.result}"/>
                <p> Result ID: ${r.id} </p>
                <form action="<%=request.getContextPath()%>/edit_result" method="Post">
                    <input type="hidden" name="rid" value="${r.id}">
                    <select name="student" required>
                        <c:forEach items="${requestScope.students}" var="s">
                            <c:if test="${r.student.id == s.id}">
                                <option selected value="${s.id}">${s.id} ${s.firstName} ${s.lastName}</option>
                            </c:if>
                            <c:if test="${!(r.student.id == s.id)}">
                                <option value="${s.id}">${s.id} ${s.firstName} ${s.lastName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    <select name="course" required>
                        <c:forEach items="${requestScope.courses}" var="c">
                            <c:if test="${r.course.id == c.id}">
                                <option selected value="${c.id}">${c.courseName}</option>
                            </c:if>
                            <c:if test="${!(r.course.id == c.id)}">
                                <option value="${c.id}">${c.courseName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    Session Number<input type="number" name="session" min="101" max="1299" value="${r.sessionNumber}" required>
                    Mark<input type="number" name="mark" min="0" max="20" value="${r.mark}" required>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>
