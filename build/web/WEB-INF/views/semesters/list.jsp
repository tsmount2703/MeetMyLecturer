<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Semesters</h2>
<hr/>
<a href="<c:url value="/semesters/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <th>Semester ID</th>
        <th>Semester Name</th>
        <th>Start Day</th>
        <th>End Day</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="semesters" items="${list}" varStatus="loop">
        <tr>
            <!--<td>${loop.count}</td>-->
            <td>${semesters.semesterID}</td>
            <td>${semesters.semesterName}</td>
            <td>${semesters.startDay}</td>
            <td>${semesters.endDay}</td>
            <td>
                <a href="<c:url value="/semesters/update.do?semesterID=${semesters.semesterID}" />"><i class="bi bi-pencil-square"></i> Update</a> |
                <a href="<c:url value="/semesters/delete.do?semesterID=${semesters.semesterID}" />"><i class="bi bi-trash3"></i>Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

