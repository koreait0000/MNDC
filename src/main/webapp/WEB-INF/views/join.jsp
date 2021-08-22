<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${param.error eq 1}">이미 존재하는 아이디 또는 이메일입니다.</c:if>
    <sec:authorize access="isAnonymous()">
        <div class="login-input-wrap"><input type="text" name="mid" value="${param.mid}" placeholder="ID"></div>
        <div class="login-input-wrap"><span id="idError"></span></div>
        <div class="login-input-wrap"><input type="password" name="mpw" placeholder="PW"></div>
        <div class="login-input-wrap"><span id="pwError"></span></div>
        <div class="login-input-wrap"><input type="password" name="mpw2" placeholder="PW2"></div>
        <div class="login-input-wrap"><span id="pwError2"></span></div>
<%--        <div class="login-input-wrap"><input type="text" name="mnm" placeholder="NAME"></div>--%>
    </sec:authorize>
        <div class="login-input-wrap"><input type="text" name="email" value="${user.email}" placeholder="EMAIL"></div>
        <div class="login-input-wrap"><span id="emailError"></span></div>
<%--        <div class="login-input-wrap"><input type="text" name="phoneNum" placeholder="휴대폰 번호 '-' 없이 입력"></div>--%>
        <div class="login-button-wrap"><input id="btn" type="button" value="Join"></div>
    </form>
    <footer style="top: 1500px;">
        <img src="/img/logo.png" width="120" height="70" class="footImg">
        <div class="copyright">
            <address>
                <span>Copyright © www.almond.com All rights reserved.&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span>
            </address>
            <div id="about">
                <span>ALMOND 운영팀: help@almond.com | <a href="/about/policy">이용약관</a> | <a href="/about/privacy"><b>개인정보처리방침</b></a></span>
            </div>
        </div>
    </footer>
</div>
<script src="/js/join.js"></script>