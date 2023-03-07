<%--
  Created by IntelliJ IDEA.
  User: clear
  Date: 04.03.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@include file="index.jsp" %>
<html>
<head>
    <title>K-Pack Add Form</title>
</head>
<body>

<div class="container">
    <form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/pack/add" method="post">
        <div class="form-group"><h3>New K-Pack</h3></div>
        <div class="form-group"><input type="text" class="form-control" name="title" placeholder="K-Pac Title"></div>
        <div class="form-group"><input type="text" class="form-control" name="description" placeholder="Description">
        </div>
        <div class="form-group"><input type="submit" class="btn btn-primary" value="Add"></div>
    </form>
</div>

</body>
</html>
