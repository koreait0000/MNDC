<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="/css/layout.css" rel="stylesheet" type="text/css" media="all">
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
</body>
</html>
