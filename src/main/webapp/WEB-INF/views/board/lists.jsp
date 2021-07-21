<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/css/layout.css" rel="stylesheet" type="text/css" media="all">

<div class="lists-container">
    <div>
<c:choose>
    <c:when test="${type eq 1}">육군</c:when>
    <c:when test="${type eq 2}">해군</c:when>
    <c:when test="${type eq 3}">공군</c:when>
    <c:when test="${type eq 4}">해병대</c:when>
</c:choose>

<c:forEach items="${list}" var="item">
    <a href="./list?mu_pk=${item.mu_pk}">
        ${item.mu_name}
    </a>
    <br>
</c:forEach>
</div>
</div>
