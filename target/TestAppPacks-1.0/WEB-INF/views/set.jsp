<%--
  Created by IntelliJ IDEA.
  User: clear
  Date: 06.03.2023
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/grid.js" />"></script>
<%@include file="index.jsp" %>

<html>
<head>
    <title>K-Pack Set</title>
</head>
<body>

<h2>Set Title: ${set.title}</h2>
<div>
    <a href="${pageContext.request.contextPath}/set/all"><<</a><br>
    List of K-Packs for current set:
</div>

<div style="width:100%; height:100%;" id="grid"></div>
<script>
    // creating DHTMLX Grid

    var dataset=${kpacks}

    const grid = new dhx.Grid("grid", {
        css: "grid",
        columns: [
            { width: 50, id: "id", header: [{ text: "Id" }] },
            { width: 300, id: "title", header: [{ text: "Title" }] },
            { width: 300, id: "description", header: [{ text: "Description" }] }
        ],
        data: dataset,
        selection: "row"
    });
</script>

</body>
</html>
