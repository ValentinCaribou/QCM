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
    <li>
        <form>
            <input type="text" placeholder="Votre recherche"><br>
            <input type="submit" value="Rechercher">
        </form>
    </li>
</ol>
