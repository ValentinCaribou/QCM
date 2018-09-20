<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/07/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>TP Web - Accueil</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/headerNavResponsable.jsp" />
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="Affichage des resultats" />
        </jsp:include>
    </div>
    <div class="row2 bordure3">
        <body>
        <div class="col-lg-12">
            <table class="table texteColor">
                <tr>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Promotion</th>
                    <th>Voir les resultats</th>
                </tr>
                <% ArrayList<Utilisateur> listeUtilisateurs = (ArrayList<Utilisateur>) request.getAttribute("listeCandidat");%>
                <% for(Utilisateur listeUtilisateur : listeUtilisateurs){
                %>
                <tr>
                    <td><%=listeUtilisateur.getNom()%></td>
                    <td id="prenom"><%=listeUtilisateur.getPrenom()%></td>
                    <td id="Promo"><%=listeUtilisateur.getCodePromo()%></td>
                    <td>
                    <form method="post" action="${pageContext.request.contextPath}/servletResultatDetailler">
                        <input type="submit" class="btn btn-outline-success" value="Voir"/>
                        <input type="hidden" name="idUser" value="<%=listeUtilisateur.getIdUtilisateur()%>"/>
                    </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        </body>
    </div>
    <p class="eniecole">TP ENI Ecole</p>
</div>
</body>
</html>
