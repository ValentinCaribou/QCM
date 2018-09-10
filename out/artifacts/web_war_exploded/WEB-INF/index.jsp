<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TP Web - Accueil</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
  </head>
  <body>
  <div class="col-lg-12">
    <jsp:include page="/WEB-INF/header.jsp">
      <jsp:param name="title" value="TP Web - Accueil" />
    </jsp:include>
    <div class="row2 bordure3">
      <div class="col-lg-10">
        <p class="text">Bienvenue sur le TP Web !</p>
        <p class="text">Accèdez à toutes les fonctionnalités qui vous sont autorisées en vous rendant sur votre page rubrique d'accès (animateur ou stagiaire)</p>
        <p class="text">Pour faire une recherche sur Google, utiliser le formulaire de recherche.</p>
      </div>
      <div class="col-lg-2 bordure2">
        <%@include file="menu.jsp"%>
      </div>
    </div>
    <p class="eniecole">TP ENI Ecole</p>
  </div>
  </body>
</html>