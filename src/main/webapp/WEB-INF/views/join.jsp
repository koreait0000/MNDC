<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.userEntity" var="user"/>
</sec:authorize>
<div>
    <form method="post" action="/join" id="form">
    <sec:authorize access="isAnonymous()">
        <div>아이디</div>
        <div><input type="text" name="id"></div>
        <div>비밀번호</div>
        <div><input type="password" name="pw"></div>
        <div>비밀번호확인</div>
        <div><input type="password" name="pw2"></div>
        <div>이름</div>
        <div><input type="text" name="name"></div>
    </sec:authorize>
        <div>이메일</div>
        <div><input type="text" name="email" value="${user.email}"></div>
        <div>휴대폰</div>
        <div><input type="text" name="phoneNum" placeholder="'-'없이 입력"></div>
        <div><input type="submit" value="회원가입"></div>
    </form>
</div>

