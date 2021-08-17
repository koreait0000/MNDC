<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="https://fonts.googleapis.com/css?family=TT+Hoves&display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
<link href="/css/benefitZone.css" rel="stylesheet" />

<div class="v1_345">
    <div class="name"></div>
</div><span class="v458_253">다양한 혜택들</span><span class="v458_254">당신을 위한</span>
</br>
<div>
    <c:forEach var="item" varStatus="status" items="${list}">
        <div><c:out value="${item}"/></div>
    </c:forEach>
</div>
