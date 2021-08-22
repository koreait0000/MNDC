<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/subscription.css">
<%--<div class="subscription col-md-auto">
    <a href="/subscription"><img src="/img/subscription.jpg" width="500px" height="200px;"></a>
</div>--%>
<div class="jb-box">
    <video muted autoplay loop>
        <source src="/img/6.25video.mp4" type="video/mp4">
    </video>
    <div class="jb-text">
        <p>이미 오래전에 더 많은것을</p>
        <p>지불하셨습니다.</p>
        <button onclick="location.href='/subscription/info'" class="btn-1">구독</button>
    </div>
</div>