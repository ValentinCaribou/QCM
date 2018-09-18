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
    <jsp:include page="/WEB-INF/headerNavResponsable.jsp" />
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="Creation d'un compte" />
        </jsp:include>
        <div class="row2 bordure3">
            <div class="col-lg-6 offset-lg-3">
                <form method="post" class="label-strong" action="${pageContext.request.contextPath}/creationCompte">
                <br>
                    <label for="nom">Nom : </label>
                    <input class="form-control" type="text" name="nom" placeholder="nom" id="nom"></br>
                    <label for="prenom">Prenom : </label>
                    <input class="form-control" type="text" name="prenom" placeholder="prenom" id="prenom"></br>
                    <label for="email">Email : </label>
                    <input class="form-control" type="text" name="email" placeholder="email" id="email"></br>
                    <label for="password">Mot de passe : </label>
                    <input class="form-control" type="password" name="password" id="password"><br>
                    <label>Type de candidat : </label><br/>
                    <div>
                        <div class="radio">
                            <input type="radio" name="valueUser" value="<%=Profil.CANDIDAT_LIBRE.getCode()%>"> Candidat libre
                        </div>
                        <div class="radio">
                            <input type="radio" name="valueUser" value="<%=Profil.STAGIAIRE.getCode()%>"> Stagiaire
                        </div>
                    </div>
                    </br>
                    <label>Année en cours : </label><br/>
                    <div>
                        <div class="radio">
                            <input type="radio" name="valuePromo" value="1"> 1ère Année
                        </div>
                        <div class="radio">
                            <input type="radio" name="valuePromo" value="2"> 2ème Année
                        </div>
                        <div class="radio">
                            <input type="radio" name="valuePromo" value="3"> 3ème Année
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
