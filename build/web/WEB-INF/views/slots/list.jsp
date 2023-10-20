<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Slots</h2>
<hr/>
<a href="<c:url value="/slots/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <!--<th>No.</th>-->
        <th>Slot ID</th>
        <th>Day 1</th>
        <th>Day 2</th>
        <th>Start Time</th>
        <th>End Time</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="slots" items="${list}" varStatus="loop">
        <tr>
            <!--<td>${loop.count}</td>-->
            <td>${slots.slotID}</td>
            <td>${slots.day1}</td>
            <td>${slots.day2}</td>
            <td>${slots.startTime}</td>
            <td>${slots.endTime}</td>
            <td>
                <a href="<c:url value="/slots/update.do?slotID=${slots.slotID}" />"><i class="bi bi-pencil-square"></i> Update</a> |
                <a href="<c:url value="/slots/delete.do?slotID=${slots.slotID}" />"><i class="bi bi-trash3"></i>Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

