<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 03/07/2018
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ol>
    <li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
    <li><a href="${pageContext.request.contextPath}/listeFormation">Liste des QCM</a></li>
    <% if (session.getAttribute("status") == null){ %>
    <li><a href="${pageContext.request.contextPath}/identificationAnimateur">Accès animateur</a></li>
    <%} else {
        if(session.getAttribute("status").equals("Formateur")){ %>
    <li><a href="${pageContext.request.contextPath}/listeFormationModif">Accès animateur</a></li>
    <%}
        if (session.getAttribute("status").equals("Stagiaire")) { %>
    <li><a href="${pageContext.request.contextPath}/erreur">Accès animateur</a></li>
    <%}%>
    <%}%>
    <li><a href="${pageContext.request.contextPath}/identificationStagiaire" >Accès stagiaire</a></li>
    <li>
        <form>
            <input type="text" placeholder="Votre recherche"><br>
            <input type="submit" value="Rechercher">
        </form>
    </li>
</ol>
