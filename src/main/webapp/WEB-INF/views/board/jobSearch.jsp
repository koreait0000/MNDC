<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://fonts.googleapis.com/css?family=TT+Hoves&display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
<link href="/css/jobSearch.css" rel="stylesheet"/>


<div class="v1_345">
    <div class="name"></div>
</div><%--title, atchfl,organ, bdbk_ctnt--%>
<span class="v458_254">구인구직</span>

<table class="type09">
    <tr>
        <th scope="cols">제목</th>
        <th scope="cols">지원서류</th>
        <th scope="cols">주관</th>
        <%--<th>bdbk_ctnt</th>--%>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
        <td scope="row"><c:out value="${item.title}"/></td>
        <td><c:out value="${item.atchfl}"/></td>
        <td scope="row"><c:out value="${item.organ}"/></td>
        <%--<td><c:out value="${item.bdbk_ctnt}"/></td>--%>
        </tr>
    </c:forEach>
</table>


<script src="/js/jobSearch.js"></script>
