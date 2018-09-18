package fr.eni.ecole.servlets;

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

import static fr.eni.ecole.constantes.ConstantesSql.*;
import static fr.eni.ecole.enumRepo.Profil.FORMATEUR;
import static fr.eni.ecole.enumRepo.Profil.RESPONSABLE;

@WebServlet(name = "ServletAdminUpdate", urlPatterns = "/admin/update")
public class ServletAdminUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            int id = Integer.parseInt(request.getParameter("id"));
            String nom = (String)request.getParameter("userName");
            String prenom = (String)request.getParameter("userFirstName");
            String email = (String)request.getParameter("userEmail");
            String password = (String)request.getParameter("userPassword");
            int codeProfil = Integer.parseInt(request.getParameter("codeProfil"));

            if( nom == null || nom.equals("") ||
                prenom == null || prenom.equals("") ||
                email == null || email.equals("") ||
                password == null || password.equals("") )
            {
                request.setAttribute("warningInsertFormResp", "Tous les champs sont obligatoires");
                this.doGet(request, response);
            }
            else {
                if(codeProfil != FORMATEUR.getCode() && codeProfil != RESPONSABLE.getCode()) {
                    request.setAttribute("errorInsertFormResp", "Une erreur est survenue lors de l'enregistrement de la modification");
                    this.doGet(request, response);
                }

                PreparedStatement preparedStatement = connection.prepareStatement(updateFormRespQuery);
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);
                preparedStatement.setInt(5, codeProfil);
                preparedStatement.setInt(6, id);
                preparedStatement.execute();

                request.setAttribute("warningInsertFormResp", null);
                request.setAttribute("errorInsertFormResp", null);
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();

        }

        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            String id = request.getParameter("id");
            if(id != null && !id.equals("")) {
                int idUtilisateur = Integer.parseInt(id);

                PreparedStatement preparedStatement = connection.prepareStatement(getUserById);
                preparedStatement.setInt(1, idUtilisateur);
                ResultSet res = preparedStatement.executeQuery();

                while(res.next()) {
                    request.setAttribute("id", idUtilisateur);
                    request.setAttribute("nom", res.getString("nom"));
                    request.setAttribute("prenom", res.getString("prenom"));
                    request.setAttribute("email", res.getString("email"));
                    request.setAttribute("password", res.getString("password"));
                    request.setAttribute("codeProfil", res.getInt("codeProfil"));
                }
            }

            this.getServletContext().getRequestDispatcher("/updatePage").forward(request, response);

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
