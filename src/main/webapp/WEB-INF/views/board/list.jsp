<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${unit} 부대
<table>
    <tr>
        <th>pk</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성일</th>
        <th>작성자(닉네임)</th>
        <th>좋아요 수</th>
        <th>조회수</th>
        <th>분류</th>
        <th>작성자pk</th>
    </tr>
    <c:forEach items="${list}" var="item">

    </c:forEach>
</table>
