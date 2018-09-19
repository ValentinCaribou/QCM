<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Utilisateur" %>
<%@ page import="fr.eni.ecole.repo.Epreuve" %><%--
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
            <% Utilisateur candidat = (Utilisateur) request.getAttribute("Utilisateur");%>
            <h3>Eleve : <%=candidat.getNom() + " " + candidat.getPrenom()%></h3>
            <table class="table texteColor">
                <tr>
                    <th>Nom du test</th>
                    <th>Etat</th>
                    <th>Note obtenue</th>
                    <th>Niveau obtenue</th>
                    <th>Temps ecouler</th>
                </tr>
                <% ArrayList<Epreuve> listeEpreuves = (ArrayList<Epreuve>) request.getAttribute("listeResultat");%>
                <% for(Epreuve listeEpreuve : listeEpreuves){
                %>
                <tr>
                    <td><%=listeEpreuve.getNomTest()%></td>
                    <td><%=listeEpreuve.getEtat()%></td>
                    <td><%=listeEpreuve.getNote_obtenue()%></td>
                    <td><%=listeEpreuve.getNiveau_obtenu()%></td>
                    <td><%=listeEpreuve.getTempsEcoule()%></td>
                </tr>
                <%
                    }
                %>
            </table>
            <button type="button" class="btn btn-outline-success" onclick="location.href='${pageContext.request.contextPath}/servletResultat'">Retour</button>
        </div>
        </body>
    </div>
    <p class="eniecole">TP ENI Ecole</p>
</div>
</body>
</html>
