<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/index.css">
<div id="container">
    <section class="bbs">
<%--        광고--%>
        <article class="banner">
            <a href="/주소값"><img src="/img/imsi_banner.jpg" width="160px" height="600px"></a>
            <i class="bi bi-x-square"></i>
        </article>
<%--        사이드바--%>
        <article class="sidebar">
            <div class="box_fit">
                <h3 class="title">공고</h3>
            </div>
            <div class="box_content">
                <table>
                    <c:forEach var="i" begin="1" end="10">
                        <tr>
                            <td>${i}</td>
                        </tr>
                    </c:forEach>
                </table>
                </ul>
            </div>
        </article>
        <article class="sidebar">
            <div class="box_fit">
                <h3 class="title">혜택존</h3>
            </div>
            <div class="box_content">
                <table>
                    <c:forEach var="i" begin="1" end="10">
                        <tr>
                            <td>${i}</td>
                        </tr>
                    </c:forEach>
                </table>
                </ul>
            </div>
        </article>
        <div class="bbs_list">
            <ul>
<%--                베스트 글 or 공지글 ? 최대 3개 --%>
                <c:forEach var="i" begin="1" end="2">
                    <li class="best_list">
                        <div class="li">
                            <h3><a href="/주소값">title [댓글수]</a></h3>
                            <div>
                                <span class="regdate">2021.08.21 00:00:00 </span>
                                <span class="author">/ nickname</span>
                            </div>
                        </div>
                    </li>
                </c:forEach>
<%--                최신글--%>
                <c:forEach var="i" begin="1" end="20">
                    <li>
                        <div class="li">
                            <a href="/주소값"><img src="/img/logo.png" width="120px" height="70px"></a>
                            <h3><a href="/주소값">title [댓글수]</a></h3>
                            <div>
                                <span class="regdate">2021.08.21 00:00:00</span>
                            </div>
                            <div>
                                <span class="author">nickname</span>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <div class="search_bar">
                <form action="" class="form">
                    <button type="submit" class="btn_search">
                        <i class="bi bi-search"></i>
                    </button>
                    <input type="text" name="search" class="search_keyword" value="${param.search}">

                    <select name="search_target" class="select">
                        <option value="title_content">제목+내용</option>
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="nickname">닉네임</option>
                    </select>
                </form>
            </div>
            <div class="page">
                <a href="?page=${param.page-1}">
                    <i class="fa fa-angle-left"></i>
                    이전
                </a>
                <c:forEach var="i" begin="1" end="10">
                    <a href="?page=${i}">${i}</a>
                </c:forEach>
                <a href="?page=${param.page+1}">
                    다음
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
            <footer>
                <img src="/img/logo.png" width="120" height="70" class="footImg">
                <div class="copyright">
                    <address>
                        <span>Copyright © www.fmkorea.com All rights reserved.&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span>
                    </address>
                    <div id="about">
                        <span>ALMOND 운영팀: help@almond.com | <a href="/about/policy">이용약관</a> | <a href="/about/privacy"><b>개인정보처리방침</b></a></span>
                    </div>
                </div>
            </footer>
        </div>
    </section>
</div>
<script src="/js/index.js"></script>