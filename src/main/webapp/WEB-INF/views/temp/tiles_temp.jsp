<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/common.css">
<%--    <link rel="stylesheet" href="/css/<tiles:getAsString name="css"/>.css">--%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>Title</title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
    <main>
        <tiles:insertAttribute name="content">
        </tiles:insertAttribute>
    </main>
    <footer>
        <tiles:insertAttribute name="footer"/>
    </footer>
<%--<script src="/js/<tiles:getAsString name="js"/>.js"></script>--%>
<script src="/js/common.js"></script>
</body>
</html>