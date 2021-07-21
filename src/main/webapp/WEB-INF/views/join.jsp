<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <sec:authentication property="principal.userEntity" var="user"/>--%>
<%--</sec:authorize>--%>
<div>
    <form method="post" action="/join" id="form">
<%--    <sec:authorize access="isAnonymous()">--%>
        <div>아이디</div>
        <div><input type="text" name="mid"></div>
        <div>비밀번호</div>
        <div><input type="password" name="mpw"></div>
        <div>비밀번호확인</div>
        <div><input type="password" name="mpw2"></div>
<%--    </sec:authorize>--%>
        <div>이메일</div>
        <div><input type="text" name="email" value="${user.email}"></div>
        <div><input type="submit" value="회원가입"></div>
    </form>
</div>

