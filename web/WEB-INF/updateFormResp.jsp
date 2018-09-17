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
        <%
            int id = (int)request.getAttribute("id");
            String nom = (String)request.getAttribute("nom");
            String prenom = (String)request.getAttribute("prenom");
            String email = (String)request.getAttribute("email");
            String password = (String)request.getAttribute("password");
            int codeProfil = (int)request.getAttribute("codeProfil");

            String warning = (String)request.getAttribute("warningInsert");
            String error = (String)request.getAttribute("errorInsert");
        %>

        <div class="col-lg-6 offset-lg-3">
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
            <h3>Modification du formateur / responsable de formations</h3>
            <form action="${pageContext.request.contextPath}/admin/update" method="post">
                <label for="userName">Nom : </label>
                <input class="form-control" name="userName" value="<%=nom%>" id="userName" type="text">
                <label for="userFirstName">Prénom : </label>
                <input class="form-control" name="userFirstName" value="<%=prenom%>" id="userFirstName" type="text">
                <label for="userEmail">Mail : </label>
                <input class="form-control" name="userEmail" value="<%=email%>" id="userEmail" type="email">
                <label for="userPassword">Mot de passe : </label>
                <input class="form-control" name="userPassword" value="<%=password%>" id="userPassword" type="password">
                <div class="col-lg-4 offset-lg-4 align-items-md-center">
                    <span>Profil : </span>
                    <label class="radio-inline">
                        <input type="radio" name="codeProfil" value="<%=Profil.FORMATEUR.getCode()%>" <%=codeProfil == Profil.FORMATEUR.getCode() ? "checked" : "" %> > <%=Profil.FORMATEUR.toString().toLowerCase()%>
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="codeProfil" value="<%=Profil.RESPONSABLE.getCode()%>" <%=codeProfil == Profil.RESPONSABLE.getCode() ? "checked" : "" %> > <%=Profil.RESPONSABLE.toString().toLowerCase()%>
                    </label>
                </div>
                <input type="hidden" name="id" value="<%=id%>"/>
                <br/>
                <button class="btn btn-primary" type="submit">Valider</button>
                <button class="btn float-md-right" type="button" onclick="location.href='${pageContext.request.contextPath}/admin'">Annuler</button>
            </form>
        </div>

        <p class="eniecole">TP ENI Ecole</p>
    </body>
</html>
