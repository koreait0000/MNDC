<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="/css/detail.css">

<div id="container">
    <div class="board">
        <div class="board_header">
            <div class="board_title">
                <div class="side">
                    <span>${board.b_title}</span>
                </div>
                <div class="side fr">
                    <span>${board.b_regdt}</span>
                </div>fgbbfg
            </div>
            <div class="board_info">
                <div class="side">
                    <a href="#"><span>닉네임 : ${board.mnm}</span></a>
                </div>
                <div class="side fr">
                    <span>조회수 : ${board.b_view}</span>
                </div>
            </span>
            <hr>
        </div>
        <div class="wrap">
            ${board.b_ctnt}
        </div>
        <br>
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal.userEntity.mpk" var="mpk"/>
        </sec:authorize>
<%--        <sec:authorize access="isAuthenticated()">--%>
        <div style="text-align: center; margin: 10px">
            <button id="like-btn" data-bpk="${board.bpk}" data-mpk="${mpk}">추천하기 ${board.b_like}</button>
            <c:if test="${board.mpk eq mpk}">
                <button onclick="location.href=`/board/delete?bpk=${board.bpk}`">삭제하기</button>
            </c:if>
        </div>
<%--        </sec:authorize>--%>

        <div class="comment">
            <div>전체 댓글 0개</div>
            <div>
            <c:forEach items="${cmtList}" var="i">
                <div>
                    <div>
                        <span>${i.mnm}</span>
                        <span>${i.c_regdt}</span>
                        <span></span>
                    </div>
                    <div>
                        <div><span>${i.c_ctnt}</span><div>
                        <c:if test="${i.mpk eq mpk}">
                            <div><button onclick="location.href=`/cmt/delete?cpk=${i.cpk}&bpk=${board.bpk}`">삭제하기</button></div>
                        </c:if>
                    </div>
                </div>
                <hr>
            </c:forEach>
            </div>

            <div class="fl">
                <form action="/board/comment" method="post">
                    <input type="hidden" value="${mpk}" name="mpk">
                    <input type="hidden" value="${board.bpk}" name="bpk">
                    <div class="cmt_txt_cont">
                        <div class="cmt_write">
                            <textarea name="c_ctnt" id="memo" maxlength="400"></textarea>
                        </div>
                        <div class="cmt_cont_bottom">
                            <div class="fr">
                                <button type="submit" class="btn_blue">등록</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer style="bottom: -261px;">
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

<script src="/js/view.js"></script>
