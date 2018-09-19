<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 09/07/2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TP Web - Erreur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/headerNav.jsp" />
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="QCM - Page d'erreur" />
        </jsp:include>
    </div>
    <div class="row2 bordure3">
        <div class="col-lg-10">
            <p class=" alert alert-danger">Erreur votre status ne vous permet pas d'acceder à cette page !</p>
        </div>
    </div>
</div>
<p class="eniecole">TP ENI Ecole</p>
</body>
</html>