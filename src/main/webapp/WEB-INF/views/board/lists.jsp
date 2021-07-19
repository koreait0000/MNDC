<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
<c:forEach items="${list}" var="item">
    부대 pk : ${item.mu_pk},
    부대 이름 : ${item.mu_name}
    부대 종류 : ${item.mu_type}
</c:forEach>
</div>
