<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="stylesheet" href="/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="/css/login.css">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.userEntity" var="user"/>
</sec:authorize>
<div class="main-container">
    <form method="post" action="/join" id="form" class="main-wrap login-input-section-wrap">
        <h1>Join</h1>
    <sec:authorize access="isAnonymous()">
        <div class="login-input-wrap"><input type="text" name="id" placeholder="ID"></div>
        <div class="login-input-wrap"><input type="password" name="pw" placeholder="PW"></div>
        <div class="login-input-wrap"><input type="password" name="pw2" placeholder="PW2"></div>
        <div class="login-input-wrap"><input type="text" name="name" placeholder="NAME"></div>
    </sec:authorize>
        <div class="login-input-wrap"><input type="text" name="email" value="${user.email}" placeholder="EMAIL"></div>
        <div class="login-input-wrap"><input type="text" name="phoneNum" placeholder="휴대폰 번호 '-' 없이 입력"></div>
        <div class="login-button-wrap"><input type="submit" value="Join"></div>
        <div id="google_recaptha" class="Easy-sgin-in-wrap">
            <script src='https://www.google.com/recaptcha/api.js'></script>
                <div class="g-recaptcha" data-sitekey="6Lf-IYQbAAAAAGNjne1KZ2lqMRe9KC_xw1pOVPlo"></div>
        </div>
    </form>
</div>

