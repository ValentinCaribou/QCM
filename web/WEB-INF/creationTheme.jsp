<%@ page import="fr.eni.ecole.repo.Theme" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 09:55
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
        <jsp:param name="title" value="Creation du theme" />
    </jsp:include>
    <div class="row2 bordure3">
        <div class="col-lg-10 creationThemeDivFormulaireCreation">
            <form class="form-group row" action="${pageContext.request.contextPath}/theme" method="post">
                <label for="theme-text-input" class="col-2 col-form-label">Nom du theme :</label>
                <div class="col-lg-6">
                    <input class="form-control" type="text" value="" id="theme-text-input" name="libelle">
                </div>
                <div class="col-lg-4">
                    <button type="submit" class="btn btn-outline-primary">Valider</button>
                </div>
            </form>
            <table class="table texteColor">
                <% ArrayList<Theme> listThemes = (ArrayList<Theme>) request.getAttribute("theme");%>
                <% for(Theme listTheme : listThemes){
                %>
                <tr>
                    <td><%=listTheme.getLibelle()%></td>
                    <td><button type="submit" class="btn btn-outline-warning">Modifier</button></td>
                    <td><button type="submit" class="btn btn-outline-danger">Supprimer</button></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <div class="col-lg-2 ">
            <%@include file="menuFormateur.jsp"%>
        </div>
    </div>
</div>
</body>
</html>
