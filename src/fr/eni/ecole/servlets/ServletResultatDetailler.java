package fr.eni.ecole.servlets;

import fr.eni.ecole.repo.Epreuve;
import fr.eni.ecole.repo.Utilisateur;

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
import java.sql.*;
import java.util.ArrayList;

import static fr.eni.ecole.constantes.ConstantesSql.*;

@WebServlet(name = "ServletResultatDetailler", urlPatterns = "/servletResultatDetailler")
public class ServletResultatDetailler extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");

            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();

            String idUser = request.getParameter("idUser");
            int userId = Integer.parseInt(idUser);
            System.out.println("Id Utilisateur : " + userId + ";");

            ArrayList<Epreuve> listeResultat = new ArrayList<Epreuve>();
            PreparedStatement getResult = connection.prepareStatement(getResultUser);
            getResult.setInt(1, userId);
            ResultSet resultSet = getResult.executeQuery();

            while (resultSet.next()){

                listeResultat.add(new Epreuve(resultSet.getInt("idEpreuve"),
                        resultSet.getDate("dateDedutValidite"),
                        resultSet.getDate("dateFinValidite"),
                        resultSet.getInt("tempsEcoule"),
                        resultSet.getString("etat"),
                        resultSet.getFloat("note_obtenue"),
                        resultSet.getFloat("niveau_obtenu"),
                        resultSet.getString("nomTest"),
                        resultSet.getInt("idUtilisateur")));
            }

            request.setAttribute("listeResultat", listeResultat);

            PreparedStatement getOneCandidat = connection.prepareStatement(getOneUser);
            getOneCandidat.setInt(1, userId);
            ResultSet resultatCandidat = getOneCandidat.executeQuery();
            resultatCandidat.next();

            Utilisateur Candidat = new Utilisateur(resultatCandidat.getInt("idUtilisateur"),
                    resultatCandidat.getString("nom"),
                    resultatCandidat.getString("prenom"),
                    resultatCandidat.getString("email"),
                    resultatCandidat.getString("password"),
                    resultatCandidat.getInt("codeProfil"),
                    resultatCandidat.getString("codePromo"));

            request.setAttribute("Utilisateur", Candidat);

            this.getServletContext().getRequestDispatcher("/resultatDetail").forward(request, response);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
