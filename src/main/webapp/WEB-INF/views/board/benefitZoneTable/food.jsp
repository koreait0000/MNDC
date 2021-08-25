<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/benefitZone.css" rel="stylesheet"/>
<tr>
    <th scope="cols">상호명</th>
    <th scope="cols">카테고리</th>
    <th scope="cols">영업시간</th>
    <th scope="cols">전화번호</th>
    <%--<th>bdbk_ctnt</th>--%>
</tr>
<c:forEach var="i" items="${list}">
    <tr onclick="location.href='https://map.naver.com/v5/search/${i.address_01}'">
        <td>${i.title}</td>
        <td>${i.categoryid}</td>
        <td>${i.usetime}</td>
        <td>${i.tel_01}</td>
    </tr>
</c:forEach>