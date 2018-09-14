<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 03/07/2018
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ol>
    <li><a href="${pageContext.request.contextPath}/indexResponsable">Accueil</a></li>
    <li><a href="${pageContext.request.contextPath}/traitementInscription">Inscrire des gens</a></li>
    <li><a href="${pageContext.request.contextPath}/CreerUnCompte">Créer un compte</a></li>
    <li><a href="${pageContext.request.contextPath}/InscriptionPromo">Inscrire une pormotion</a></li>
    <li><a href="${pageContext.request.contextPath}/Result">Voir les résultats</a></li>
    <li>
        <form>
            <input type="text" placeholder="Votre recherche"><br>
            <input type="submit" value="Rechercher">
        </form>
    </li>
</ol>
