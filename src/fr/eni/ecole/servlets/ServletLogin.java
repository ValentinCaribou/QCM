package fr.eni.ecole.servlets;

import fr.eni.ecole.constantes.ConstantesSql;
import fr.eni.ecole.enumRepo.Profil;
import fr.eni.ecole.repo.User;

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

import static fr.eni.ecole.enumRepo.Profil.CANDIDAT_LIBRE;

@WebServlet(name = "ServletLogin", urlPatterns = "/authentification")
public class ServletLogin extends HttpServlet {
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
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            Cookie[] cookies = request.getCookies();

            HttpSession session = request.getSession();

            ArrayList<User> listeUser = new ArrayList<User>();

            String mail = (String) request.getParameter("mail");
            String password = (String) request.getParameter("password");

            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.connexionQuery);
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();

            String mailBdd = null;
            String passwordBdd = null;
            String nom = null;
            String prenom = null;
            String codePromo = null;
            int codeProfil = 0;

            if (session.getAttribute("mail") == request.getParameter("mail") && session.getAttribute("password") == request.getParameter("password")){
                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
            }

            while(resultSet.next()){
                mailBdd = resultSet.getString("email");
                passwordBdd = resultSet.getString("password");
                nom = resultSet.getString("nom");
                prenom = resultSet.getString("prenom");
                codePromo = resultSet.getString("codePromo");
                codeProfil = resultSet.getInt("codeProfil");
                String status = "Formateur";

                if (session.getAttribute("mail") == null){
                    session.setAttribute("mail", mail);
                    session.setAttribute("password", password);
                    session.setAttribute("nom", nom);
                    session.setAttribute("prenom", prenom);
                    session.setAttribute("codeProfil", codeProfil);
                    session.setAttribute("codePromo", codePromo);
                }
            }


            if (mail.equals(mailBdd) && password.equals(passwordBdd)){
                request.setAttribute("session", session);
                for (Profil p : Profil.values()){
                    if (codeProfil == p.getCode())
                    {
                        switch (p){
                            case CANDIDAT_LIBRE:
                            case STAGIAIRE:
                                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
                                break;

                            case RESPONSABLE:
                                this.getServletContext().getRequestDispatcher("/indexResponsable").forward(request, response);
                                break;

                            case FORMATEUR:
                                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
                                break;

                            case ADMIN:
                                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
                                break;

                            case CELLULE_RECRUTEMENT:
                                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
                                break;

                        }
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
