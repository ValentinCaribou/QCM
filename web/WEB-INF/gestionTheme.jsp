<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 14/09/2018
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formateur</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="../ressources/bootstrap-4.1.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-lg-12">
    <jsp:include page="/WEB-INF/header.jsp">
        <jsp:param name="title" value="Gestion theme" />
    </jsp:include>
    <div class="row2 bordure3">
        <div class="col-lg-10 creationThemeDivFormulaireCreation">
            <form class="form-group row" action="${pageContext.request.contextPath}/gestions" method="post">
                <div class="col-lg-6">
                    <input class="form-control" type="text" id="theme-text-input" name="libelle" value="<%=request.getAttribute("libelle")%>"  />
                    <input type="hidden" name="idTheme" value="<%=request.getAttribute("idTheme")%>" />
                </div>
                <div class="col-lg-6">
                    <button type="submit" class="btn btn-outline-primary" >Valider la modification</button>
                </div>
            </form>
            </table>
        </div>
        <div class="col-lg-2 ">
            <%@include file="menuFormateur.jsp"%>
        </div>
    </div>
</div>
</body>
</html>