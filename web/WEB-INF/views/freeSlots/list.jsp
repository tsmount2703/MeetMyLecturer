<%-- 
    Document   : list
    Created on : Oct 19, 2023, 3:02:35 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Free Slots</h2>
<hr/>
<a href="<c:url value="/freeSlots/create.do" />"></i>Create</a>
    <table class="table table-striped" border="1">
        <tr>
            <th>ID</th>
            <th>Free Slot ID</th>
            <th>Subject Code</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Password</th>
            <th>Capacity</th>
            <th>Meet Link</th>
            <th>Count</th>
            <th>Lecturer ID</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="freeSlots" items="${list}" varStatus="loop">
            <tr>
                <td>${freeSlots.ID}</td>
                <td>${freeSlots.freeSlotID}</td>
                <td>${freeSlots.subjectCode}</td>
                <td>${freeSlots.startTime}</td>
                <td>${freeSlots.endTime}</td>
                <td>${freeSlots.password}</td>
                <td>${freeSlots.capacity}</td>
                <td>${freeSlots.meetLink}</td>
                <td>${freeSlots.count}</td>
                <td>${freeSlots.lecturerID}</td>
                <td>
                    <a href="<c:url value="/freeSlots/update.do?ID=${freeSlots.ID}" />"><i class="bi bi-pencil-square"></i> Update</a> |
                    <a href="<c:url value="/freeSlots/delete.do?ID=${freeSlots.ID}" />"><i class="bi bi-trash3"></i>Delete</a>
                </td>
            </tr>

        </c:forEach>
    </table>

