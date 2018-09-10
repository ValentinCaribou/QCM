package fr.eni.ecole.servlets;

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

@WebServlet(name = "ServletIdentificationStag", urlPatterns = "/identificationUserStag")
public class ServletIdentificationStagiaire extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");
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

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nom, prenom, email, motdepasse FROM stagiaires WHERE email = ?");
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Mail de la session : " + mail);
            System.out.println("Password de la session : " + password);

            String mailBdd = null;
            String passwordBdd = null;
            String nom = null;
            String prenom = null;

            if (session.getAttribute("mail") == request.getParameter("mail")){
                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
            }

            System.out.println("Mail de la session : " + session.getAttribute("mail"));

            while(resultSet.next()){
                mailBdd = resultSet.getString("email");
                passwordBdd = resultSet.getString("motdepasse");
                nom = resultSet.getString("nom");
                prenom = resultSet.getString("prenom");
                String status = "Stagiaire";
                System.out.println("Mail enregistrer en BDD : " + mailBdd);
                System.out.println("Password enregistrer en BDD : " + passwordBdd);
                if (session.getAttribute("mail") == null){
                    session.setAttribute("mail", mail);
                    session.setAttribute("password", password);
                    session.setAttribute("nom", nom);
                    session.setAttribute("prenom", prenom);
                    session.setAttribute("status", status);
                    System.out.println("Session stagiaire créer !");
                }
            }


            if (mail.equals(mailBdd) && password.equals(passwordBdd)){
                request.setAttribute("session", session);
                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
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
