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
        String enonce = request.getParameter("enonce");
        String media = request.getParameter("media");
        int points = Integer.parseInt(request.getParameter("points"));
        int idTheme = Integer.parseInt(request.getParameter("idTheme"));

        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.questionCreate);
            preparedStatement.setString(1,enonce);
            preparedStatement.setString(2, media);
            preparedStatement.setInt(3, points);
            preparedStatement.setInt(4, idTheme);
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
