<%--
  Created by IntelliJ IDEA.
  User: clear
  Date: 05.03.2023
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@include file="index.jsp" %>

<html>
<head>
    <title>K Pac Set Add Form</title>
</head>
<body>

<div class="container">
    <form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/set/add" method="post">
        <div class="form-group"><h3>New K-Pack Set</h3></div>
        <div class="form-group"><input type="text" class="form-control" name="title" placeholder="Set title"></div>

        <label>Available K-Pack for new set</label>

        <table class="table table-hover table-sm">
            <thead>
            <tr>
                <th>Add</th>
                <th scope="col">K-Pack title</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="kpack" items="${kpacks}">
                <tr>
                    <td align="center">
                        <input type="checkbox" name="selectedKPacks"
                               value="<c:out value="${kpack.id}"/>"/>
                    </td>
                    <td>${kpack.title}</td>

                </tr>
            </c:forEach>

            </tbody>
        </table>

        <div class="form-group"><input type="submit" class="btn btn-primary" value="Save"></div>
    </form>
</div>

</body>
</html>
