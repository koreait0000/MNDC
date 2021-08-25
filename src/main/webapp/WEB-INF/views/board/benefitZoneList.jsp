<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://fonts.googleapis.com/css?family=TT+Hoves&display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
<link href="/css/jobSearch.css" rel="stylesheet"/>
<link href="/css/benefitZoneList.css" rel="stylesheet"/>

<div id="container">
    <div class="v1_345">
        <div class="name"></div>
    </div><%--title, atchfl,organ, bdbk_ctnt--%>
    <span class="v458_254">${title}</span>
    <div class="side fr">
    </div>
    <table class="type09" border="1" style="position: relative;">
    <c:choose>
        <c:when test="${title eq '음식존'}">
            <jsp:include page="benefitZoneTable/food.jsp"></jsp:include>
        </c:when>
        <c:when test="${title eq '여행존'}">
            <jsp:include page="benefitZoneTable/tour.jsp"></jsp:include>
        </c:when>
        <c:when test="${title eq '영화존'}">
            <jsp:include page="benefitZoneTable/movie.jsp"></jsp:include>
        </c:when>
        <c:when test="${title eq '군혜택존'}">
            <jsp:include page="benefitZoneTable/military.jsp"></jsp:include>
        </c:when>
    </c:choose>
    </table>
</div>
<footer style="bottom: -250px; left: 280px;">
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
<script src="/js/jobSearch.js"></script>
