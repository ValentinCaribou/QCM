<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Formation" %>
<%@ page import="fr.eni.ecole.repo.FormRespDto" %>
<%@ page import="fr.eni.ecole.enumRepo.Profil" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="fr.eni.ecole.filter.VerifSession" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/07/2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean verif = VerifSession.checkSession(Profil.ADMIN.getCode(), request, response);

    if(!verif){
        response.sendRedirect("/erreur");
        return;
    }
%>
<html>
    <head>
        <jsp:include page="/WEB-INF/head.jsp">
            <jsp:param name="title" value="Section administration" />
        </jsp:include>
    </head>
    <body>
        <jsp:include page="/WEB-INF/headerNavAdmin.jsp" />
        <div class="col-lg-12">
            <jsp:include page="/WEB-INF/header.jsp">
                <jsp:param name="title" value="Section administration" />
            </jsp:include>
        </div>
        <div class="row2 bordure3">
            <%
                String warning = (String)request.getAttribute("warningInsert");
                String error = (String)request.getAttribute("errorInsert");

//                ArrayList<String> logs = request.getAttribute("logs") != null ? (ArrayList<String>) request.getAttribute("logs") : new ArrayList<>();
            %>
            <div class="col-lg-6">
                <div class="col-lg-12 bordure">
                    <%
                        if(warning != null && !warning.equals("")) {
                    %>
                    <div class="alert alert-warning">
                        <%=warning%>
                    </div>
                    <%
                        }
                    %>

                    <%
                        if(error != null && !error.equals("")) {
                    %>
                    <div class="alert alert-danger">
                        <%=error%>
                    </div>
                    <%
                        }
                    %>
                    <h3>Créer un formateur / responsable de formations</h3>
                    <form action="${pageContext.request.contextPath}/admin/create" method="post" class="label-strong">
                        <label for="userName">Nom : </label>
                        <input class="form-control" name="nom" id="userName" type="text">
                        <label for="userFirstName">Prénom : </label>
                        <input class="form-control" name="prenom" id="userFirstName" type="text">
                        <label for="userEmail">Mail : </label>
                        <input class="form-control" name="email" id="userEmail" type="email">
                        <label for="userPassword">Mot de passe : </label>
                        <input class="form-control" name="password" id="userPassword" type="password">
                        <div class="col-lg-4 offset-lg-4 align-items-md-center">
                            <label>Profil : </label>
                            <input type="radio" name="choixFormResp" value="<%=Profil.FORMATEUR.getCode()%>" checked /> <%=Profil.FORMATEUR.toString().toLowerCase()%>
                            <input type="radio" name="choixFormResp" value="<%=Profil.RESPONSABLE.getCode()%>" /> <%=Profil.RESPONSABLE.toString().toLowerCase()%>
                        </div>
                        <br/>
                        <button class="btn btn-primary" type="submit">Valider</button>
                        <input class="btn float-md-right" type="reset" value="Annuler">
                    </form>
                </div>
                <div class="col-lg-12">
                    <h3>Logs d'incidents</h3>
                    <div style="overflow: scroll; height: 240px;">
                        <%--<%--%>
                            <%--for(String log : logs) {--%>
                        <%--%>--%>
                        <%--<span><%=log%></span>--%>
                        <%--<%--%>
                            <%--}--%>
                        <%--%>--%>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <h3>Liste des formateurs et responsables de formations</h3>
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
                            <form action="${pageContext.request.contextPath}/admin/update" method="get">
                                <input type="hidden" name="id" value="<%=respForm.getIdUtilisateur()%>" />
                                <button class="btn btn-sm btn-outline-warning" type="submit">Modifier</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/admin/delete" method="post">
                                <input type="hidden" name="id" value="<%=respForm.getIdUtilisateur()%>" />
                                <button class="btn btn-sm btn-outline-danger" type="submit">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </body>
</html>
