<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/index.css">
<div id="container">
    <section class="bbs">
        <div>

        </div>
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
                            <a href="/주소값"><img src="../img/1.gif" width="120px" height="80px"></a>
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
        </div>
        <div class="search_bar">
            <form action="" class="form">
                <button type="submit" class="btn_search">
                    <i class="bi bi-search"></i>
                </button>
                <input type="text" name="search" class="search_keyword" value="${param.search}">
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
    </section>
</div>