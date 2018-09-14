package fr.eni.ecole.servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ServletCreateRespFormAccount", urlPatterns = "/admin/createRespFormAccount")
public class ServletCreateRespFormAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            String nom = (String)request.getAttribute("nom");
            String prenom = (String)request.getAttribute("prenom");
            String email = (String)request.getAttribute("email");
            String password = (String)request.getAttribute("password");
            int codeProfil = (int)request.getAttribute("codeProfil");


        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
