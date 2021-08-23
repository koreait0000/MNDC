<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://fonts.googleapis.com/css?family=TT+Hoves&display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
<link href="/css/jobSearch.css" rel="stylesheet"/>

<div id="container">
    <div class="v1_345">
        <div class="name"></div>
    </div><%--title, atchfl,organ, bdbk_ctnt--%>
    <span class="v458_254">구인구직</span>
    <div class="side fr">
    <form action="/jobSearch" method="get" id="search">
        <select name="location">
        <c:forEach items="${locations}" var="item">
            <option value="${item.key}">${item.value}</option>
        </c:forEach>
        </select>
        <select name="category">
        <c:forEach items="${categories}" var="item">
            <option value="${item.key}">${item.value}</option>
        </c:forEach>
        </select>
        <input type="submit" value="검색하기">
    </form>
    </div>
    <table class="type09" border="1" style="position: relative;">
        <tr>
            <th scope="cols">제목</th>
            <th scope="cols">지역</th>
            <th scope="cols">주관</th>
            <%--<th>bdbk_ctnt</th>--%>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td scope="row"><a href="${item.link}"><c:out value="${item.contents}"/></a></td>
            <td><c:out value="${item.area}"/></td>
            <td scope="row"><c:out value="${item.company}"/></td>
            <%--<td><c:out value="${item.bdbk_ctnt}"/></td>--%>
            </tr>
        </c:forEach>
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
