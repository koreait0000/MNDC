<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://fonts.googleapis.com/css?family=TT+Hoves&display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
<link href="/css/benefitZone.css" rel="stylesheet"/>

<div id="container">
    <div class="v1_345">
        <div class="name"></div>
    </div>
    <span class="v458_253">다양한 혜택들</span><span class="v458_254">당신을 위한</span>
    </br>
    <div>
        <%--<c:forEach var="item" varStatus="status" items="${list}">
            <div><c:out value="${item}"/></div>
        </c:forEach>--%>
    </div>
    <div class="img-container-box">
        <div class="img-container">
            <div>
                <a href="#" class="column" id="caption1">
                    <img class="img-item" src="img/food.jpg">
                    <span class="text"><h1>음식</h1></span>
                </a>
            </div>
            <div>
                <a href="#" class="column" id="caption2">
                    <img class="img-item" src="img/hotel.jpg">
                    <span class="text"><h1>관광</h1></span>
                </a>
            </div>
            <div>
                <a href="#" class="column" id="caption3">
                    <img class="img-item" src="img/movie.jpg">
                    <span class="text"><h1>영화</h1></span>
                </a>
            </div>
        </div>
    </div>
    <footer style="top: 1000px;">
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
