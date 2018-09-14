<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.ecole.repo.Formation" %><%--
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
                <div class="col-lg-12">
                    <div class="col-lg-6">
                        <form action="${pageContext.request.contextPath}/createRespFormAccount">

                        </form>
                    </div>
                    <div class="col-lg-6">
                        <table class="table texteColor">
                            <tr>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Email</th>
                                <th>Profil</th>
                            </tr>
                            <% ArrayList<User> listeRespForm = (ArrayList<Formation>) request.getAttribute("listeRespForm");%>
                            <% for(Formation respForm : listeRespForm){
                            %>
                            <tr>
                                <td><%=respForm.getLibelle()%></td>
                                <td><%=respForm.getDescription()%></td>
                                <td><%=respForm.getDebut()%></td>
                                <td><%=respForm.getFin()%></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>
            <div class="col-lg-12">

            </div>
            </body>
        </div>
        <p class="eniecole">TP ENI Ecole</p>
    </body>
</html>
