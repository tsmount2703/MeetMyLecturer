<%-- 
    Document   : index
    Created on : Oct 7, 2023, 12:54:29 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${users==null}">
        <jsp:forward page="/users/login.do" />
    </c:when>
    <c:otherwise>
        <jsp:forward page="/home/index.do" />
    </c:otherwise>
</c:choose>
