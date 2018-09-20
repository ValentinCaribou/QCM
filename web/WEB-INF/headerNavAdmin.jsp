<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 09/07/2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-12">
    <nav class="navbar navbar-dark bg-dark NavBar">
        <div class="col-lg-8">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin"><strong>QCM</strong></a>

            <%--<a class="navbar-brand textSize" href="${pageContext.request.contextPath}/traitementInscription">Liste des epreuves</a>--%>
        </div>
        <div class="offset-lg-1 col-lg-3 row">
            <%
                String nom = (String) session.getAttribute("nom");
                String prenom = (String) session.getAttribute("prenom");
            %>
            <div class="offset-lg-2 col-lg-3">
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