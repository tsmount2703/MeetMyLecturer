<%-- 
    Document   : list
    Created on : Oct 19, 2023, 3:02:35 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Bookings</h2>
<hr/>
<a href="<c:url value="/bookings/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <th>No.</th>
        <th>ID</th>
        <th>Booking ID</th>
        <th>Student ID</th>
        <th>Free Slots</th>
        <th>Status</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="bookings" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${bookings.ID}</td>
            <td>${bookings.bookingID}</td>
            <td>${bookings.studentID}</td>
            <td>${bookings.freeSlotID}</td>
            <td>${bookings.status}</td>
            <td>
                <a href="<c:url value="/bookings/update.do?ID=${bookings.ID}"/>"><i class="bi bi-pencil-square"></i> Update</a> |
                <a href="<c:url value="/bookings/delete.do?ID=${bookings.ID}"/>"><i class="bi bi-trash3"></i>Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

