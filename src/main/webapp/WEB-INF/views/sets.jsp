<%--
  Created by IntelliJ IDEA.
  User: clear
  Date: 05.03.2023
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/grid.js" />"></script>

<%@include file="index.jsp" %>

<style>
    body {
        margin: 10px;
    }
    .remove-button {
        cursor: pointer;
    }
</style>

<html>
<head>
    <title>K-Pack Set List</title>
</head>
<body>

<div>
    <a id="addButton" href="${pageContext.request.contextPath}/set_add_form">ADD NEW K-PACK SET</a>
</div>

<div>K-Pack Sets List</div>

<!-- component container -->
<div style="width:100%; height:100%;" id="grid"></div>
<script>
    // creating DHTMLX Grid

    var dataset = ${gson}

    const grid = new dhx.Grid("grid", {
        css: "grid",
        columns: [
            {
                width: 50,
                id: "id",
                header: [{text: "Id"}, {content: "comboFilter", customFilter: (value, match) => value === match}]
            },
            {
                width: 300,
                id: "title",
                header: [{text: "Title"}, {content: "comboFilter", customFilter: (value, match) => value === match}]
            },
            {
                width: 100, header: [{text: "Action"}],
                htmlEnable: true, align: "center",
                template: function () {

                    return "<a class='remove-button'>DELETE</a>"
                }
            }
        ],
        data: dataset,
        selection: "row",
        eventHandlers: {
            onclick: {
                "remove-button": function (e, data) {

                    location.href = '${pageContext.request.contextPath}/set/delete/' + JSON.stringify(data.row.id)

                },
            },
        },
    });

    grid.events.on("cellDblClick", function (row) {
        return window.location.href = '${pageContext.request.contextPath}/set/' + JSON.stringify(row.id);
    });
</script>

</body>
</html>
