<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
<c:choose>
    <c:when test="${type eq 1}">육군</c:when>
    <c:when test="${type eq 2}">공군</c:when>
    <c:when test="${type eq 3}">해군</c:when>
    <c:when test="${type eq 4}">해병대</c:when>
</c:choose>
<c:forEach items="${list}" var="item">
    <a href="./list?mu_pk=${item.mu_pk}">
        부대 이름 : ${item.mu_name}
    </a>
    <br>
</c:forEach>
</div>
