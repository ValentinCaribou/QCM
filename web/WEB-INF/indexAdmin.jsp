<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Formation" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/07/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
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
                <jsp:param name="title" value="Section administration" />
            </jsp:include>
        </div>
        <div class="row2 bordure3">
            <body>
                <div class="col-lg-12">
                </div>
            </body>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </body>
</html>
