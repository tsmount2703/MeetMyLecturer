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
<form action="<c:url value="/bookings/search.do"/>">    
    <div>
        <p style="display: inline-block">Search By: </p>
        <select style="width: 200px; display: inline-block" name="select" class="form-control form-control-line"  >
            <option name="select" value="subjectCode">Subject Code</option>
            <option  name="select" value="lecturer">Lecturer</option> 
            <option  name="select" value="student">Student</option> 
        </select>

        <select style="width: 200px; display: inline-block"  name="semester" class="form-control form-control-line"  >
            <option name="semester" value="SP22">SPRING2022</option>
            <option name="semester" value="SU22">SUMMER2022</option> 
            <option name="semester" value="FA22">FALL2022</option> 
            <option name="semester" value="SP23">SPRING2023</option>
            <option name="semester" value="SU23">SUMMER2023</option> 
            <option name="semester" value="FA23">FALL2023</option> 
        </select>   

        <input style="height: 38px; display: inline-block" type="text" placeholder="Please enter ID" name="ID"  >
        <button style="display: inline-block; margin-bottom: 4px" type="submit" class="btn btn-success" name="select" value="${requestScope[select]}">Search <i class="bi bi-search"></i></button> 
        <h5 style="color: red">${msg}</h5>
    </div>
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
</form>
