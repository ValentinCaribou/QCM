package fr.eni.ecole.servlets;

import fr.eni.ecole.enumRepo.Profil;
import fr.eni.ecole.filter.VerifSession;
import fr.eni.ecole.repo.*;

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

@WebServlet(name = "TraitementInscription", urlPatterns = "/traitementInscription")
public class InscriptionCandidat extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean verif = VerifSession.checkSession(Profil.RESPONSABLE.getCode(), request, response);

        if(!verif){
            response.sendRedirect("/erreur");
            return;
        }

        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();

            HttpSession session = request.getSession();

            ArrayList<Theme> listeTheme = new ArrayList<Theme>();
            ResultSet resultSet = statement.executeQuery(getThemeQcm);
            while (resultSet.next()){

                listeTheme.add(new Theme(resultSet.getInt("idTheme"),
                        resultSet.getString("libelle")));
            }
            request.setAttribute("listeTheme", listeTheme);

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

            ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

            PreparedStatement preparedStatement = connection.prepareStatement(getCandidatStagiaireQuery);
            preparedStatement.setInt(1, Profil.CANDIDAT_LIBRE.getCode());
            preparedStatement.setInt(2, Profil.STAGIAIRE.getCode());
            ResultSet resultSetCandidat = preparedStatement.executeQuery();
            while (resultSetCandidat.next()){

                listeUtilisateur.add(new Utilisateur(resultSetCandidat.getInt("idUtilisateur"),
                        resultSetCandidat.getString("nom"),
                        resultSetCandidat.getString("prenom"),
                        resultSetCandidat.getString("email"),
                        resultSetCandidat.getString("password"),
                        resultSetCandidat.getInt("codeProfil"),
                        resultSetCandidat.getString("codePromo")));
            }
            request.setAttribute("listeUtilisateur", listeUtilisateur);
//            response.sendRedirect("/inscriptionCandidat");
            this.getServletContext().getRequestDispatcher("/inscriptionCandidat").forward(request, response);

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
