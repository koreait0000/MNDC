<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tr>
    <th scope="cols">지역</th>
    <th scope="cols">상호명</th>
    <th scope="cols">상세내용</th>
    <th scope="cols">전화번호</th>
</tr>
<c:forEach var="i" items="${list}">
    <tr onclick="location.href='${i.hmpg}'">
        <td>${i.rgn}</td>
        <td>${i.instltnnm}</td>
        <td>${i.dtlexpln}</td>
        <td>${i.cntadr}</td>
    </tr>
</c:forEach>