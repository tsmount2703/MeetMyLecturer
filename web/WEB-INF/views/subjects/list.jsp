<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Subjects</h2>
<hr/>
<a href="<c:url value="/subjects/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <!--<th>No.</th>-->
        <th>Subject Code</th>
        <th>Subject Name</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="subjects" items="${list}" varStatus="loop">
        <tr>
            <!--<td>${loop.count}</td>-->
            <td>${subjects.subjectCode}</td>
            <td>${subjects.subjectName}</td>
            <td>
                <a href="<c:url value="/subjects/update.do?subjectCode=${subjects.subjectCode}" />"><i class="bi bi-pencil-square"></i> Update</a> |
                <a href="<c:url value="/subjects/delete.do?subjectCode=${subjects.subjectCode}" />"><i class="bi bi-trash3"></i>Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

