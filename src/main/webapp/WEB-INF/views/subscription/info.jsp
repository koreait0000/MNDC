<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--TODO: pay는 연결했는데. 구매했을때 혜택? 그리고 가격? 다른데 보고 고민해보고 해야할듯?--%>

<link rel="stylesheet" href="/css/info.css">

<div class="img-container-box">
    <div class="img-container">
        <div><img src="/img/이등병.jpg"></div>
        <button id="payment-button1" class="pay-btn">1000</button>
    </div>
    <div class="img-container">
        <div><img src="/img/일병.jpg"></div>
        <button id="payment-button2" class="pay-btn">2000</button>
    </div>
    <div class="img-container">
        <div><img src="/img/상병.jpg"></div>
        <button id="payment-button3" class="pay-btn">3000</button>
    </div>
    <div class="img-container">
        <div><img src="/img/병장.jpg"></div>
        <button id="payment-button4" class="pay-btn">4000</button>
    </div>
</div>
<div>구매 시 위 뱃지가 수여됩니다.</div>
<script src="https://js.tosspayments.com/v1"></script>
<script src="/js/pay.js"></script>