package fr.eni.ecole.servlets;

import fr.eni.ecole.enumRepo.Profil;
import fr.eni.ecole.filter.VerifSession;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static fr.eni.ecole.constantes.ConstantesSql.insertInscription;

@WebServlet(name = "ServletInscriptionCandidat", urlPatterns = "/servletInscriptionCandidat")
public class ServletInscriptionCandidat extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean verif = VerifSession.checkSession(Profil.RESPONSABLE.getCode(), request, response);

        if(!verif){
            response.sendRedirect("/erreur");
            return;
        }

        try {
            System.out.println("Inscription candidat");
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            Cookie[] cookies = request.getCookies();

            HttpSession session = request.getSession();

            String Candidat = request.getParameter("Utilisateur");
            int CandidatInt = Integer.parseInt(Candidat);
            String Test = request.getParameter("Test");
            int TestInt = Integer.parseInt(Test);
            Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
            Date dateFin = Date.valueOf(request.getParameter("dateFin"));

            System.out.println("Candidat : " + Candidat);
            System.out.println("Test : " + Test);
            System.out.println("Date de début : " + dateDebut);
            System.out.println("Date de fin : " + dateFin);

            PreparedStatement preparedStatement = connection.prepareStatement(insertInscription);
            preparedStatement.setDate(1, dateDebut);
            preparedStatement.setDate(2, dateFin);
            preparedStatement.setInt(3, 0);
            preparedStatement.setString(4, "EA");
            preparedStatement.setNull(5,java.sql.Types.INTEGER);
            preparedStatement.setNull(6, java.sql.Types.INTEGER);
            preparedStatement.setInt(7, TestInt);
            preparedStatement.setInt(8, CandidatInt);
            preparedStatement.executeUpdate();

            response.sendRedirect("/indexResponsable");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
