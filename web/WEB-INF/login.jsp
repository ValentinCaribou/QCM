<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/07/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
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
                <jsp:param name="title" value="TP Web - Acces Animateur" />
            </jsp:include>
            <div class="row2 bordure3">
                <div class="col-lg-10">
                    <form method="post" action="${pageContext.request.contextPath}/authentification">
                    <br>
                        <div class="col-lg-4-Me">
                            <h5>Identifiant : </h5>
                        </div>
                        <input type="text" name="mail" placeholder="identifiant"></br>
                        <div class="col-lg-4-Me">
                            <h5>Mot de passe : </h5>
                        </div>
                        <input type="password" name="password"><br>
                        <input type="submit" value="Se connecter">
                    </form>
                </div>
                <div class="col-lg-2 bordure2">
                    <%@include file="menu.jsp"%>
                </div>
            </div>
            <p class="eniecole">TP ENI Ecole</p>
        </div>
    </body>
</html>
