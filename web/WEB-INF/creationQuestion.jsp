<%@ page import="fr.eni.ecole.repo.Theme" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Formateur</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/header.jsp">
        <jsp:param name="title" value="Creation question" />
    </jsp:include>
    <div class="row2 bordure3">
        <div class="col-lg-10">
            <div class="col-lg-6 offset-lg-3">
                <form  action="" method="post">
                    <label for="enonceQuestion" class="control-label ">Énoncé de la question: </label>
                    <textarea name="enonceQuestion" id="enonceQuestion" rows="4" cols="50"  class="form-control" ></textarea>
                    <label for="media" class="control-label ">Fichier d'illustration: </label>
                    <input type="file" name="media" id="media" class="form-control"/>
                    <label for="point" class="control-label ">Points attribués à cette question :</label>
                    <input type="number" name="point" id="point" class="form-control">
                    <label for="theme" class="control-label ">Theme correspondant: </label>
                        <select name="theme" id="theme" class="form-control">
                            <% ArrayList<Theme> listThemes = (ArrayList<Theme>) request.getAttribute("theme");%>
                            <% for(Theme listTheme : listThemes){
                            %>
                            <option value="<%=listTheme.getId()%>"><%=listTheme.getLibelle()%></option>
                            <%
                                }
                            %>
                        </select>
                    <br/>
                    <button type="submit" class="btn btn-outline-primary">Valider</button>
                </form>
            </div>
            <table class="table texteColor">

            </table>

        </div>
        <div class="col-lg-2 ">
            <%@include file="menuFormateur.jsp"%>
        </div>
    </div>
</div>
</body>
</html>