<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/mypage.css">
<div id="container">
    <div>
        <h1>프로필</h1>
        <form action="/mypage/profile_update" method="post">
            <section>
                <div class="img_logo"></div>
                <div class="my_info">
                    <div><span>name</span> <img src="/img/일병.jpg"></div>
                    <div><input type="text" name="introduction" placeholder="소개글을 입력하세요."></div>
                </div>
            </section>
            <div class="btn_section">
                <button type="button">취소</button>
                <button type="submit">저장</button>
            </div>
        </form>
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