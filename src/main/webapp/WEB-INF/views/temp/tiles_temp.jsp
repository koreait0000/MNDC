<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
<%--    클릭시 구독페이지로 가기--%>
    <section id="banner">
        <tiles:insertAttribute name="banner"/>
    </section>
    <main>
        <tiles:insertAttribute name="content"/>
    </main>
</body>
</html>