<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Timetables</h2>
<hr/>
<a href="<c:url value="/timetables/create.do" />"></i>Create</a>
<table class="table table-striped" border="1">
    <tr>
        <th>No.</th>
        <th>Subject Code</th>
        <th>Slot ID</th>
        <th>Lecturer ID</th>
        <th>Semester ID</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="timetables" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${timetables.subjectCode}</td>
            <td>${timetables.slotID}</td>
            <td>${timetables.lecturerID}</td>
            <td>${timetables.semesterID}</td>
            <td>
                <a href="<c:url value="/timetables/update.do?subjectCode=${timetables.subjectCode}&slotID=${timetables.slotID}&lecturerID=${timetables.lecturerID}&semesterID=${timetables.semesterID}"/>"><i class="bi bi-pencil-square"></i> Update</a> |
                <!--<a href="<c:url value="/timetables/update.do?subjectCode=${timetables.subjectCode}"/>"><i class="bi bi-pencil-square"></i> Update</a> |-->
                <a href="<c:url value="/timetables/delete.do?subjectCode=${timetables.subjectCode}&slotID=${timetables.slotID}&lecturerID=${timetables.lecturerID}&semesterID=${timetables.semesterID}" />"><i class="bi bi-trash3"></i>Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

