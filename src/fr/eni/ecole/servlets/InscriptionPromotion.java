package fr.eni.ecole.servlets;

import fr.eni.ecole.enumRepo.Profil;
import fr.eni.ecole.filter.VerifSession;
import fr.eni.ecole.repo.Promotion;
import fr.eni.ecole.repo.Test;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.eni.ecole.constantes.ConstantesSql.*;

@WebServlet(name = "TraitementInscriptionPromo", urlPatterns = "/traitementInscriptionPromo")
public class InscriptionPromotion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");

            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();

            boolean verif = VerifSession.checkSession(Profil.RESPONSABLE.getCode(), request, response);

            if(!verif){
                response.sendRedirect("/erreur");
                return;
            }

            ArrayList<Test> listeTest = new ArrayList<Test>();
            ResultSet resultSetTest = statement.executeQuery(getTestQCM);
            while (resultSetTest.next()){

                listeTest.add(new Test(resultSetTest.getInt("idTest"),
                        resultSetTest.getString("libelle"),
                        resultSetTest.getString("description"),
                        resultSetTest.getInt("duree"),
                        resultSetTest.getInt("seuil_haut"),
                        resultSetTest.getInt("seuil_bas")));
            }
            request.setAttribute("listeTest", listeTest);

            ArrayList<Promotion> listePromotion = new ArrayList<Promotion>();
            ResultSet resultSetPromotion = statement.executeQuery(getPromotion);
            while (resultSetPromotion.next()){

                listePromotion.add(new Promotion(resultSetPromotion.getString("codePromo"),
                        resultSetPromotion.getString("Libelle")));
            }
            request.setAttribute("listePromotion", listePromotion);
            this.getServletContext().getRequestDispatcher("/inscriptionPromotion").forward(request, response);

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
