package fr.eni.ecole.servlets;

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

import static fr.eni.ecole.constantes.ConstantesSql.connectionQuery;

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
        if(request.getParameter("value") != null) {
            this.doGet(request, response);
            return;
        }

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

            PreparedStatement preparedStatement = connection.prepareStatement(connectionQuery);
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();

            String mailBdd = null;
            String passwordBdd = null;
            String nom = null;
            String prenom = null;
            String codePromo = null;
            int codeProfil = 0;

            if (session.getAttribute("mail") == request.getParameter("mail") && session.getAttribute("password") == request.getParameter("password")){
                this.getServletContext().getRequestDispatcher("/index").forward(request, response);
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

                // redirection
                for(Profil p : Profil.values()) {
                    if(codeProfil == p.getCode()) {
                        System.out.println(codeProfil);
                        switch(p) {
                            case CANDIDAT_LIBRE:
                            case STAGIAIRE:
                                response.sendRedirect("/index");
                                break;

                            case RESPONSABLE:
                                response.sendRedirect("/indexResponsable");
                                break;

                            case FORMATEUR:
                                response.sendRedirect("/index");
                                break;

                            case CELLULE_RECRUTEMENT:
                                response.sendRedirect("/index");
                                break;

                            case ADMIN:
                                response.sendRedirect("/indexAdmin");
                                break;
                        }
                        return;
                    }
                }

                response.sendRedirect("/index");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
