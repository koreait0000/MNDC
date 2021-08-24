<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tr>
    <th scope="cols">관광단지</th>
    <th scope="cols">주소</th>
    <th scope="cols">전화번호</th>
    <%--<th>bdbk_ctnt</th>--%>
</tr>
<c:forEach var="i" items="${list}">
    <tr>
        <td>${i.subject}</td>
        <td>${i.address}</td>
        <td>${i.telephone}</td>
    </tr>
</c:forEach>