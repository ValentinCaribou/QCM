package fr.eni.ecole.servlets;

import fr.eni.ecole.constantes.ConstantesSql;

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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletCreationTest", urlPatterns = "/test")
public class ServletCreationTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //recuperation des champs

        String libelle =request.getParameter("libelle");
        String description = request.getParameter("description");
        int duree = Integer.parseInt(request.getParameter("duree"));
        int seuil_haut = Integer.parseInt(request.getParameter("seuil_haut"));
        int seuil_bas = Integer.parseInt(request.getParameter("seuil_bas"));

        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.testCreate);
            preparedStatement.setString(1,libelle);
            preparedStatement.setString(2,description);
            preparedStatement.setInt(3, duree);
            preparedStatement.setInt(4, seuil_haut);
            preparedStatement.setInt(5, seuil_bas);
            preparedStatement.executeUpdate();

            this.doGet(request,response);

        }
        catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/tests").forward(request, response);
    }
}
