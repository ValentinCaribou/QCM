<%@ page import="fr.eni.ecole.repo.Theme" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Utilisateur" %>
<%@ page import="fr.eni.ecole.repo.Test" %>
<%@ page import="fr.eni.ecole.repo.Promotion" %>
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
    <jsp:include page="/WEB-INF/headerNavResponsable.jsp" />
    <div class="col-lg-12">
        <jsp:include page="/WEB-INF/header.jsp">
            <jsp:param name="title" value="Inscrire un candidat / Stagiaire" />
        </jsp:include>
        <div class="row2 bordure3">
            <div class="col-lg-6 offset-lg-3">
                <form method="post" class="label-strong" action="${pageContext.request.contextPath}/servletInscriptionPromotion">
                    <%--<h5 class="text">Inscription d'un candidat/Stagiaire</h5>--%>
                <br>
                    <div class="col-lg-12">
                        <label for="listePromotion">Liste des promotions :</label>
                        <select class="form-control" id="listePromotion" name="Promotion">
                            <% ArrayList<Promotion> listePromotions = (ArrayList<Promotion>) request.getAttribute("listePromotion");%>
                            <% for(Promotion listePromotion : listePromotions){
                            %>
                            <option value="<%=listePromotion.getCodePromo()%>"><%=listePromotion.getLibelle()%></option>
                            <%
                                }
                            %>
                        </select>
                        <br/>
                    </div>
                    </br>
                    <div class="col-lg-12">
                        <label for="listeTest">Liste des Tests :</label>
                        <select class="form-control" id="listeTest" name="Test">
                            <% ArrayList<Test> listeTests = (ArrayList<Test>) request.getAttribute("listeTest");%>
                            <% for(Test listeTest : listeTests){
                            %>
                                <option value="<%=listeTest.getIdTest()%>"><%=listeTest.getLibelle()%></option>
                            <%
                                }
                            %>
                        </select>
                        <br/>
                    </div>
                    </br>
                     <div class="col-lg-12">
                    <label for="dateDebut">Choisir la date de début : </label>
                    <br/>
                        <input class="form-control" type="date" name="dateDebut" id="dateDebut">
                    </br>
                    <label for="dateFin">Choisir la date de fin : </label>
                        <input class="form-control" class="dateTime" type="date" name="dateFin" id="dateFin">
                    </br>
                </br>
                    <input type="submit" class="btn btn-outline-primary btn-form-candidat" value="Valider">
                </div>
                </form>
            </div>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </div>
</div>
</body>
</html>
