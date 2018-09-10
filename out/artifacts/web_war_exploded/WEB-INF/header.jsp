<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 09/07/2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bordure">
    <div class="col-lg-10">
        <h1 class="text"><%=request.getParameter("title") != null ? request.getParameter("title") : "TP Web"%></h1>
    </div>
    <%
        String nom = (String) session.getAttribute("nom");
        String prenom = (String) session.getAttribute("prenom");
    %>
    <div>
        <h3 class="text"><%= nom == null || nom.equals("") ? "" : nom%> <%= prenom == null || prenom.equals("") ? "" : prenom%></h3>
        <% if (nom != null){
        %>
        <form method="post" action="${pageContext.request.contextPath}/deconnexion">
            <input class="btn" type="submit" value="Deconnection">
        </form>
        <%   }%>
    </div>
</div>
