package fr.eni.ecole.servlets;

import fr.eni.ecole.enumRepo.Profil;
import fr.eni.ecole.filter.VerifSession;
import fr.eni.ecole.repo.Test;
import fr.eni.ecole.repo.Theme;
import fr.eni.ecole.repo.Utilisateur;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static fr.eni.ecole.constantes.ConstantesSql.*;

@WebServlet(name = "CreationCompte", urlPatterns = "/creationCompte")
public class ServletCreation extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean verif = VerifSession.checkSession(Profil.RESPONSABLE.getCode(), request, response);

        if(!verif){
            response.sendRedirect("/erreur");
            return;
        }

        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");

            Connection connection = dataSource.getConnection();


            System.out.println("InscriptionCandidat");

            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String codeProfil = request.getParameter("valueUser");
            String codePromo = request.getParameter("valuePromo");
            int codeProfilInt = Integer.parseInt(codeProfil);

            PreparedStatement preparedStatement = connection.prepareStatement(createUser);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, codeProfilInt);
            preparedStatement.setString(6, codePromo);
            preparedStatement.executeUpdate();

            response.sendRedirect("/indexResponsable");

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
