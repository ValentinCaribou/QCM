<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Formation" %>
<%@ page import="fr.eni.ecole.repo.FormRespDto" %>
<%@ page import="fr.eni.ecole.enumRepo.Profil" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/07/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/head.jsp">
            <jsp:param name="title" value="Section administration" />
        </jsp:include>
    </head>
    <body>
        <div class="col-lg-12">
            <jsp:include page="/WEB-INF/header.jsp">
                <jsp:param name="title" value="Section administration" />
            </jsp:include>
        </div>
        <div class="row2 bordure3">
            <body>
                    <div class="col-lg-6">
                        <form action="${pageContext.request.contextPath}/admin" method="post">
                            <label for="userName">Nom : </label>
                            <input class="form-control" id="userName" type="text">
                            <label for="userFirstName">Prénom : </label>
                            <input class="form-control" id="userFirstName" type="text">
                            <label for="userEmail">Mail : </label>
                            <input class="form-control" id="userEmail" type="email">
                            <label for="userPassword">Mot de passe : </label>
                            <input class="form-control" id="userPassword" type="password">
                            <div class="col-lg-4 offset-lg-4 align-items-md-center">
                                <span>Profil : </span>
                                <label class="radio-inline">
                                    <input type="radio" name="choixFormResp" value="<%=Profil.FORMATEUR.getCode()%>" checked> <%=Profil.FORMATEUR.toString().toLowerCase()%>
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="choixFormResp" value="<%=Profil.RESPONSABLE.getCode()%>"> <%=Profil.RESPONSABLE.toString().toLowerCase()%>
                                </label>
                            </div>
                            <br/>
                            <button class="btn btn-primary" type="submit" value="create">Valider</button>
                            <input class="btn float-md-right" type="reset" value="Annuler">
                        </form>
                    </div>
                    <div class="col-lg-6">
                        <table class="table texteColor">
                            <tr>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Email</th>
                                <th>Profil</th>
                                <th></th>
                            </tr>
                            <% ArrayList<FormRespDto> listeRespForm = (ArrayList<FormRespDto>) request.getAttribute("users");%>
                            <% for(FormRespDto respForm : listeRespForm){
                            %>
                            <tr>
                                <td><%=respForm.getNom()%></td>
                                <td><%=respForm.getPrenom()%></td>
                                <td><%=respForm.getEmail()%></td>
                                <td><%=respForm.getProfil()%></td>
                                <td>
                                    <form action="/admin/modifier" method="post">
                                        <button class="btn btn-outline-warning" type="submit" name="Modifier" value="<%=respForm.getIdUtilisateur()%>">Modifier</button>
                                    </form>
                                    <form action="/admin/supprimer">
                                        <button class="btn btn-outline-danger" type="submit" name="Supprimer" value="<%=respForm.getIdUtilisateur()%>">Supprimer</button>
                                    </form>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
            <div class="col-lg-12">

            </div>
            </body>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </body>
</html>
