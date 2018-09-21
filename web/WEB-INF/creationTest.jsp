<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formateur</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/header.jsp">
        <jsp:param name="title" value="Creation test" />
    </jsp:include>
    <div class="row2 bordure3">
        <div class="col-lg-10">
            <div class="col-lg-6 offset-lg-3">
                <form  action="" method="post" >
                    <label for="libelle" class="control-label ">Libelle du test: </label>
                    <input type="text" name="libelle" id="libelle" class="form-control"/>
                    <label for="description" class="control-label ">Descripttion du test: </label>
                    <textarea name="description" id="description" rows="4" cols="50"  class="form-control" ></textarea>
                    <label for="duree" class="control-label ">Durée du test en minute: </label>
                    <input type="number" name="duree" id="duree" class="form-control"/>
                    <label for="seuil_haut" class="control-label ">Seuil de Points à atteindre:</label>
                    <input type="number" name="seuil_haut" id="seuil_haut" class="form-control">
                    <label for="seuil_bas" class="control-label ">Seuil de Points minimum: </label>
                    <input type="number" name="seuil_bas" id="seuil_bas" class="form-control">
                    <br/>
                    <button type="submit" class="btn btn-outline-primary">Valider</button>
                </form>
            </div>

        </div>
        <div class="col-lg-2 ">
            <%@include file="menuFormateur.jsp"%>
        </div>
    </div>
</div>
</body>
</html>
