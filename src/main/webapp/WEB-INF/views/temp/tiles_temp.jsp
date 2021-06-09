<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="common.css">
    <link rel="stylesheet" href="/css/<tiles:getAsString name="css"/>.css">
    <title>Title</title>0
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
    <main>
        <tiles:insertAttribute name="content"/>
    </main>
    <footer>
        <tiles:insertAttribute name="footer"/>
    </footer>
<script src="/js/<tiles:getAsString name="js"/>.js"></script>
<script src="/js/common.js"></script>
</body>
</html>