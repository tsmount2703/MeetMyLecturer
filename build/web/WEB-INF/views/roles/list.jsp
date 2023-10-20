<%-- 
    Document   : list
    Created on : Oct 19, 2023, 3:02:35 PM
    Author     : Dell
--%>

<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Roles</h2>
<hr/>
<a href="<c:url value="/roles/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <th>Role ID</th>
        <th>Role Name</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="roles" items="${list}" varStatus="loop">
        <tr>
            <!--<td>${loop.count}</td>-->
            <td>${roles.roleID}</td>
            <td>${roles.roleName}</td>
            <td>
                <a href="<c:url value="/roles/update.do?roleID=${roles.roleID}" />"><i class="bi bi-pencil-square"></i> Update</a> |
                <a href="<c:url value="/roles/delete.do?roleID=${roles.roleID}" />"><i class="bi bi-trash3"></i>Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

