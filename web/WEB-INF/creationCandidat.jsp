<%@ page import="fr.eni.ecole.enumRepo.Profil" %><%--
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
    <jsp:include page="/WEB-INF/headerNavResponsable.jsp">
    </jsp:include>
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="Creation d'un compte" />
        </jsp:include>
        <div class="row2 bordure3">
            <div class="col-lg-10">
                <form method="post" action="${pageContext.request.contextPath}/creationCompte">
                <br>
                    <div class="col-lg-4-Me">
                        <h5>Nom : </h5>
                    </div>
                    <input type="text" name="nom" placeholder="nom"></br>
                    <div class="col-lg-4-Me">
                        <h5>Prenom : </h5>
                    </div>
                    <input type="text" name="prenom" placeholder="prenom"></br>
                    <div class="col-lg-4-Me">
                        <h5>Email : </h5>
                    </div>
                    <input type="text" name="email" placeholder="email"></br>
                    <div class="col-lg-4-Me">
                        <h5>Mot de passe : </h5>
                    </div>
                    <input type="password" name="password"><br>
                    <div class="col-lg-4-Me">
                        <h5>Type de candidat : </h5>
                    </div>
                    <div>
                        <div class="radio">
                            <label><input type="radio" name="valueUser" value="<%=Profil.CANDIDAT_LIBRE.getCode()%>">Candidat libre</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="valueUser" value="<%=Profil.STAGIAIRE.getCode()%>">Stagiaire</label>
                        </div>
                    </div>
                    </br>
                    <div class="col-lg-4-Me">
                        <h5>Année en cours : </h5>
                    </div>
                    <div>
                        <div class="radio">
                            <label><input type="radio" name="valuePromo" value="1">1ère Année</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="valuePromo" value="2">2ème Année</label>
                        </div>
                    </div>
                    </br>
                    <input type="submit" class="btn" value="Valider">
                </form>
            </div>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </div>
</div>
</body>
</html>
