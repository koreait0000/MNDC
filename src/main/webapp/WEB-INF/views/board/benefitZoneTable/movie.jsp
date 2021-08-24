<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tr>
    <th scope="cols">영화명</th>
    <th scope="cols">상영날짜</th>
    <th scope="cols">상영시간</th>
    <%--<th>bdbk_ctnt</th>--%>
</tr>
<c:forEach var="i" items="${list}">
    <tr>
        <td>${i.bsubject}</td>
        <td>${i.bplaydate}</td>
        <td>${i.bplaytime}</td>
    </tr>
</c:forEach>