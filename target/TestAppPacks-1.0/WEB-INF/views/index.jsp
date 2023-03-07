<%--
  Created by IntelliJ IDEA.
  User: clear
  Date: 06.03.2023
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
    body {
        margin: 10px;
    }
</style>

<html>
<head>
<%--    <title>Index</title>--%>
</head>
<body>

<ul class="nav justify-content-center">
    <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/">INDEX</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/pack/all">PACKS</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/set/all">SETS</a>
    </li>
</ul>

</body>
</html>
