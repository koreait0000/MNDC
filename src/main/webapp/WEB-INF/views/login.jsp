<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/css/layout.css" rel="stylesheet" type="text/css" media="all">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/login.css">
<div class="main-container">
    <h1>Login</h1>
    <c:if test="${param.auth eq 1}">
        <div>이메일 인증이 완료되었습니다. 로그인을 시도해주세요.</div>
    </c:if>
    <c:if test="${param.auth eq 0}">
        <div>이메일 인증을 시도해주세요</div>
    </c:if>

    <form method="post" id="form" action="/login" class="main-wrap login-input-section-wrap">
        <div class="login-input-wrap"><input type="text" name="mid" class="mid" placeholder="ID"></div>
        <div class="login-input-wrap password-wrap"><input type="password" name="mpw" class="mpw" placeholder="PW"></div>
        <div class="login-button-wrap"><input type="button" name="button1" value="LOG IN"></div>
    </form>
    <div class="login-stay-sign-in">
        Don't you have ID? <a href="/join">join</a>
    </div>
    <div class="Easy-sgin-in-wrap">
        <h1>Easier sign in</h1>
        <ul class="sign-button-list">
            <li><a href="/oauth2/authorization/google"><img class="login-lmg-size" src="/img/demo/ButtonImg/btnGoogle.png"></img></a></li>
            <li><a href="/oauth2/authorization/facebook"><img class="login-lmg-size" src="/img/demo/ButtonImg/btnFacebook.png"></img></a></li>
            <li><a href="/oauth2/authorization/naver"><img class="login-lmg-size" src="/img/demo/ButtonImg/btnG.png"></img></a></li>
        </ul>
    </div>
</div>
<script src="/js/login.js"></script>

