<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/detail.css">

<div id="container">
    <div class="board">
        <div class="board_header">
            <div class="board_title">
                <div class="side">
                    <span>title</span>
                </div>
                <div class="side fr">
                    <span>2021.08.23</span>
                </div>
            </div>
            <div class="board_info">
                <div class="side">
                    <a href="/주소"><span>nickname</span></a>
                </div>
                <div class="side fr">
                    <span>조회수</span>
                    <span>추천수</span>
                    <span>댓글수</span>
                </div>
            </span>
        </div>
        <div class="wrap">
            글내용
        </div>
        <div class="comment">
            <div>전체 댓글 0개</div>
            <div class="fl">
                <form action="/board/comment" method="post">
                    <div class="cmt_txt_cont">
                        <div class="cmt_write">
                            <textarea id="memo" maxlength="400"></textarea>
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
