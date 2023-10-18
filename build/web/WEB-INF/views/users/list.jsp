<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Users</h2>
<hr/>
 <a href="<c:url value="/users/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <th>No.</th>
        <th>User ID</th>
        <th>Name</th>
        <th>Email</th>
        <!--<th>Password</th>-->
        <th>Status</th>
        <th>Role Name</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="users" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${users.userID}</td>
            <td>${users.userName}</td>
            <td>${users.userEmail}</td>
            <!--<td>${users.password}</td>-->
            <td>${users.statusText}</td>
            <td>${users.roleName}</td>
            <td>
                <a href="<c:url value="/users/update.do?userID=${users.userID}" />"><i class="bi bi-pencil-square"></i> Update</a> 
                <!--<a href="<c:url value="/toy/delete.do?id=${toy.id}" />"><i class="bi bi-trash3"></i>Delete</a>-->
            </td>
        </tr>
        
    </c:forEach>
</table>
