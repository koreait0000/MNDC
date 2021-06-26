<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/join.css">
<div>로고</div>
<div>네이버 아이디 인증</div>
<div>
    <div><span>아이디</span></div>
    <input type="text" name="uid" value="" placeholder="아이디">
</div>
<div>
    <div>
        <div><span>휴대폰번호</span></div>
        <input type="text" id="inputPhoneNumber" placeholder="공백 또는 '-'없이 숫자로 입력해주세요">
        <button type="button" id="sendPhoneNumber">발송</button>
    </div>
    <div>
        <input type="text" id="inputCertifiedNumber" placeholder="인증 번호를 입력해주세요">
        <button type="button" id="checkBtn">인증하기</button>
        <p class="ok">입력하신 휴대폰 번호로 인증코드를 발송했습니다. 만약 인증코드가 오지 않으면 입력하신 번호를 다시 확인해주세요.</p>
        <p class="error">공백 또는 '-'없이 숫자로 입력해주세요.</p>
        ${error}
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="/js/join.js"></script>