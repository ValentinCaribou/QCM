<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 09/07/2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bordure header">
    <div class="col-lg-10">
        <h1 class="text"><%=request.getParameter("title") != null ? request.getParameter("title") : "QCM"%></h1>
    </div>
</div>
