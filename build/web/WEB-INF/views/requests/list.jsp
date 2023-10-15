<%-- 
    Document   : index
    Created on : Oct 7, 2023, 1:00:51 PM
    Author     : Dell
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Requests</h2>
<hr/>
<form action="<c:url value="/requests/search.do"/>">    
    <div>
        <p style="display: inline-block">Search By: </p>
        <select style="width: 200px; display: inline-block" name="select" class="form-control form-control-line"  >
            <option value="subjectCode">Subject Code</option>
            <option value="lecturer">Lecturer</option> 
            <option value="student">Student</option> 
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
            <!--<th>ID</th>-->
            <th>Subject Code</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Description</th>
            <th>Status</th>
            <th>Student ID</th>
            <th>Lecturer ID</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="requests" items="${list}" varStatus="loop">
            <tr>
                <!--<td>${requests.requestID}</td>-->
                <td>${requests.subjectCode}</td>
                <td>${requests.startTime}</td>
                <td>${requests.endTime}</td>
                <td>${requests.description}</td>
                <td>${requests.status}</td>
                <td>${requests.studentID}</td>
                <td>${requests.lecturerID}</td>
                <td>
                    <a href="<c:url value="" />"><i class="bi bi-pencil-square"></i>Edit</a> 
                    <br/>
                    <a href="<c:url value="" />"><i class="bi bi-trash3"></i>Delete</a>
                </td>
            </tr>

        </c:forEach>
    </table>


</form>
