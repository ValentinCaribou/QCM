<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 09/07/2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <nav class="navbar navbar-dark bg-dark NavBar">
        <div class="col-lg-8">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/indexResponsable"><strong>QCM</strong></a>

            <a class="navbar-brand textSize" href="${pageContext.request.contextPath}/indexResponsable">Accueil</a>

            <a class="navbar-brand textSize" href="${pageContext.request.contextPath}/traitementInscription">Inscrire des gens</a>

            <a class="navbar-brand textSize" href="${pageContext.request.contextPath}/creationCandidat">Créer un compte</a>

            <a class="navbar-brand textSize" href="${pageContext.request.contextPath}/traitementInscriptionPromo">Inscrire une promotion</a>

            <a class="navbar-brand textSize" href="${pageContext.request.contextPath}/servletResultat">Voir les résultats</a>
        </div>
        <div class="offset-lg-1 col-lg-3 row">
            <%
                String nom = (String) session.getAttribute("nom");
                String prenom = (String) session.getAttribute("prenom");
            %>
            <div class="offset-lg-2 col-lg-4">
                <h3 class="text prenom"><%= nom == null || nom.equals("") ? "" : nom%> <%= prenom == null || prenom.equals("") ? "" : prenom%></h3>
            </div>
            <% if (nom != null){
            %>
            <div class="col-lg-6">
                <form method="post" action="${pageContext.request.contextPath}/deconnexion">
                    <input class="btn btn-outline-danger" type="submit" value="Deconnection">
                </form>
                <%
                }
                else {
                %>
                <form method="post" action="${pageContext.request.contextPath}/login">
                    <input class="btn btn-outline-primary" type="submit" value="Login">
                </form>
            </div>
            <%
                }
            %>
    </div>
    </nav>
</div>