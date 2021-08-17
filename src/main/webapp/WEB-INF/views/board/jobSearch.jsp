<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=TT+Hoves&display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    <link href="/css/jobSearch.css" rel="stylesheet" />

    <title>구인구직정보</title>
</head>

<body>

<div class="v1_345">
    <div class="name"></div>
</div><span class="v458_254">구인구직</span>
<div>
    <c:forEach varStatus="status" var="item" items="${list}">
        <c:out value="${item}"/>
    </c:forEach>
</div>
</body>

</html>
