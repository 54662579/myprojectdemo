<%-- 
    Document   : menutab
    Created on : 18-Jun-2018, 11:43:35 AM
    Author     : Dev
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="vertical-menu">
    <a href="/CGS/index.jsp" class="active">Menu</a>
    <% if (request.isUserInRole("admin")) { %>
    <a href="<%=request.getContextPath()%>/student_add">Add Student</a>
    <a href="<%=request.getContextPath()%>/student_list">Student List</a>
    <a href="<%=request.getContextPath()%>/teacher_add">Add Teacher</a>
    <a href="<%=request.getContextPath()%>/teacher_list">Teacher List</a>
    <a href="<%=request.getContextPath()%>/course_add">Add Course</a>
    <a href="<%=request.getContextPath()%>/course_list">Course List</a>
    <a href="<%=request.getContextPath()%>/course_add_student">Add Student to a Course</a>
    <a href="<%=request.getContextPath()%>/course_add_teacher">Add Teacher to a Course</a>
    <% } %>
    <% if (request.isUserInRole("admin") || request.isUserInRole("teacher")) { %>
    <a href="<%=request.getContextPath()%>/result_add">Add Result</a>
    <a href="<%=request.getContextPath()%>/result_list">Result List</a> <% } %>
    <a href="<%=request.getContextPath()%>/logout">Log Out</a>
</div>
