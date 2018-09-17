<%@ page import="fr.eni.ecole.repo.Theme" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Utilisateur" %>
<%@ page import="fr.eni.ecole.repo.Test" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/07/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/head.jsp">
    <jsp:param name="title" value="Inscrire un candidat / Stagiaire" />
</jsp:include>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/headerNavResponsable.jsp">
    </jsp:include>
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="Inscrire un candidat / Stagiaire" />
        </jsp:include>
        <div class="row2 bordure3">
            <div class="col-lg-10">
                <form method="post" action="${pageContext.request.contextPath}/servletInscriptionCandidat">
                    <h5 class="text">Inscription d'un candidat/Stagiaire</h5>
                <br>
                    <div class="col-lg-6">
                        <h6 for="listeUtilisateur">Liste des candidat :</h6>
                        <select class="form-control" id="listeUtilisateur" name="Utilisateur">
                            <% ArrayList<Utilisateur> listeUtilisateurs = (ArrayList<Utilisateur>) request.getAttribute("listeUtilisateur");%>
                            <% for(Utilisateur listeUtilisateur : listeUtilisateurs){
                            %>
                            <option value="<%=listeUtilisateur.getIdUtilisateur()%>"><%=listeUtilisateur.getNom() + " " + listeUtilisateur.getPrenom()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    </br>
                    <div class="col-lg-6">
                        <h6 for="listeTest">Liste des Tests :</h6>
                        <select class="form-control" id="listeTest" name="Test">
                            <% ArrayList<Test> listeTests = (ArrayList<Test>) request.getAttribute("listeTest");%>
                            <% for(Test listeTest : listeTests){
                            %>
                                <option value="<%=listeTest.getIdTest()%>"><%=listeTest.getLibelle()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    </br>
                    <div class="col-lg-6">
                    <h6>Choisir la date de début : </h6>
                    </br>
                        <input type="date" name="dateDebut">
                    </br>
                    <h6>Choisir la date de fin : </h6>
                    </br>
                        <input class="dateTime" type="date" name="dateFin">
                </br>
                    <input type="submit" class="btn btn-form-candidat" value="Valider">
                </div>
                </form>
            </div>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </div>
</div>
</body>
</html>
