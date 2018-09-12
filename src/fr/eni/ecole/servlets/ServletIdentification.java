package fr.eni.ecole.servlets;

import fr.eni.ecole.Constantes.ConstantesSql;
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

@WebServlet(name = "ServletIdentification", urlPatterns = "/identificationUser")
public class ServletIdentification extends HttpServlet {
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

            if (session.getAttribute("mail") == request.getParameter("mail")){
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
                this.getServletContext().getRequestDispatcher("/formateur").forward(request, response);
            }

            String infos = null;
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("Bonjour")) {
                        infos = c.getValue();
                        break;
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
