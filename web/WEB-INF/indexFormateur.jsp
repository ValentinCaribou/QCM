<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/09/2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil - Formateur</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/header.jsp">
        <jsp:param name="title" value="Accueil-Formateur" />
    </jsp:include>
    <div class="row2 bordure3">
        <div class="col-lg-10">


        </div>
        <div class="col-lg-2 ">
            <%@include file="menuFormateur.jsp"%>
        </div>
    </div>
</div>
</body>
</html>
