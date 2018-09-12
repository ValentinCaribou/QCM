<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/07/2018
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TP Web - Coneexion</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/header.jsp">
        <jsp:param name="title" value="TP Web - Connexion reussi" />
    </jsp:include>
</div>
<div class="row2 bordure3">
    <div class="col-lg-10">
        <h3>Bonjour <%=session.getAttribute("nom")%> <%=session.getAttribute("prenom")%></h3>
    </div>
    <div class="col-lg-2 bordure2">
        <%@include file="menu.jsp"%>
    </div>
</div>
<p class="eniecole">TP ENI Ecole</p>
</body>
</html>