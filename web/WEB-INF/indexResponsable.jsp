<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/09/2018
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Responsable</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/headerNavResponsable.jsp">
    </jsp:include>
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="TP Web - Liste formation" />
        </jsp:include>
    </div>
    <div class="row2 bordure3">
        <div class="col-lg-10">
            <p class="text">Bienvenue sur la page de Responsable</p>
            <p class="text">Accèdez à toutes les fonctionnalités qui vous sont autorisées</p>
            <p class="text"></p>
        </div>
        <%--<div class="col-lg-2 bordure2">--%>
            <%--<%@include file="menuResponsable.jsp"%>--%>
        <%--</div>--%>
    </div>
    <p class="eniecole">TP ENI Ecole</p>
</div>
</body>
</html>
