package fr.eni.ecole.servlets;

import fr.eni.ecole.repo.Test;
import fr.eni.ecole.repo.Utilisateur;

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

import static fr.eni.ecole.constantes.ConstantesSql.*;

@WebServlet(name = "ServletInscriptionPromotion", urlPatterns = "/servletInscriptionPromotion")
public class ServletInscriptionPromotion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("Inscription Promotion");
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            Cookie[] cookies = request.getCookies();

            HttpSession session = request.getSession();

            String Promotion = request.getParameter("Promotion");
            String promotion = Promotion.split("")[0];
            System.out.println(Promotion + ";");
            System.out.println(promotion + ";");
            int PromotiontInt = Integer.parseInt(promotion);
            String Test = request.getParameter("Test");
            int TestInt = Integer.parseInt(Test);
            Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
            Date dateFin = Date.valueOf(request.getParameter("dateFin"));

            System.out.println("Promotion : " + Promotion);
            System.out.println("Test : " + Test);
            System.out.println("Date de début : " + dateDebut);
            System.out.println("Date de fin : " + dateFin);

            ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
            PreparedStatement getCandidat = connection.prepareStatement(getCandidatCodePromo);
            getCandidat.setInt(1, PromotiontInt);
            ResultSet resultSetUtilisateurs = getCandidat.executeQuery();
            while (resultSetUtilisateurs.next()){

                listeUtilisateurs.add(new Utilisateur(resultSetUtilisateurs.getInt("idUtilisateur"),
                        resultSetUtilisateurs.getString("nom"),
                        resultSetUtilisateurs.getString("prenom"),
                        resultSetUtilisateurs.getString("email"),
                        resultSetUtilisateurs.getString("password"),
                        resultSetUtilisateurs.getInt("codeProfil"),
                        resultSetUtilisateurs.getString("codePromo")));
            }

            for(Utilisateur listeUtilisateur : listeUtilisateurs){
                PreparedStatement preparedStatement = connection.prepareStatement(insertInscription);
                preparedStatement.setDate(1, dateDebut);
                preparedStatement.setDate(2, dateFin);
                preparedStatement.setInt(3, 0);
                preparedStatement.setString(4, "EA");
                preparedStatement.setNull(5, Types.INTEGER);
                preparedStatement.setNull(6, Types.INTEGER);
                preparedStatement.setInt(7, TestInt);
                preparedStatement.setInt(8, listeUtilisateur.getIdUtilisateur());
                preparedStatement.executeUpdate();
            }
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
