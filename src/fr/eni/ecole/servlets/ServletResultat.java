package fr.eni.ecole.servlets;

import fr.eni.ecole.repo.Formation;
import fr.eni.ecole.repo.Utilisateur;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static fr.eni.ecole.constantes.ConstantesSql.getCandidatCodePromo;
import static fr.eni.ecole.constantes.ConstantesSql.getCandidatPromotion;

@WebServlet(name = "ServletResultat", urlPatterns = "/servletResultat")
public class ServletResultat extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");

            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();
            
            ArrayList<Utilisateur> listeResultat = new ArrayList<Utilisateur>();
            ResultSet resultSet = statement.executeQuery(getCandidatPromotion);
            while (resultSet.next()){

                listeResultat.add(new Utilisateur(resultSet.getInt("idUtilisateur"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("codeProfil"),
                        resultSet.getString("promotion")));
            }

            request.setAttribute("listeCandidat", listeResultat);

            this.getServletContext().getRequestDispatcher("/resultat").forward(request, response);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
