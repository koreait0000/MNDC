<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/write.css">

<div id="container">
    <div class="wrap">
        <div class="banner"><img src="/img/블소1.jpg" width="720" height="90"></div>
<%--        ck에디터--%>
        <form action="/board/write" method="post">
            <div class="title"><input type="text" name="b_title" style="width: 908px"></div>
            <div class="inputArea">
                <label for="content"></label>
                <textarea rows="5" cols="50" id="content" name="b_ctnt"></textarea>
            </div>
            <div class="fr"><input type="submit" value="작성하기"></div>
        </form>
    </div>
    <footer>
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
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script src="//cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>
<script>
    var ckeditor_config = {
        resize_enaleb : false,
        enterMode : CKEDITOR.ENTER_BR,
        shiftEnterMode : CKEDITOR.ENTER_P,
        filebrowserUploadUrl : "/ckUpload"
    };

    CKEDITOR.replace("content", ckeditor_config);
</script>
