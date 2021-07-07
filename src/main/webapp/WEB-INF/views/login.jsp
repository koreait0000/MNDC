<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form method="post" action="/login">
        <div>아이디</div>
        <div><input type="text" name="id"></div>
        <div>비밀번호</div>
        <div><input type="password" name="pw"></div>
        <div><input type="submit" value="회원가입"></div>
    </form>
    <a href="/join">회원가입</a>
    <a href="/oauth2/authorization/google">구글로그인</a>
    <a href="/oauth2/authorization/facebook">페이스북로그인</a>
    <a href="/oauth2/authorization/naver">네이버로그인</a>
</div>