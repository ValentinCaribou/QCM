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
import static fr.eni.ecole.constantes.ConstantesSql.insertFormRespQuery;

@WebServlet(name = "ServletAdminCreate", urlPatterns = "/admin/create")
public class ServletAdminCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String choixFormResp = request.getParameter("choixFormResp");

            if( nom == null || nom.equals("") ||
                    prenom == null || prenom.equals("") ||
                    email == null || email.equals("") ||
                    password == null || password.equals("") ||
                    choixFormResp == null )
            {
                request.setAttribute("warningInsert", "Tous les champs sont obligatoires");
                this.doGet(request, response);
                return;
            }
            else {
                if(choixFormResp.equals("")) {
                    request.setAttribute("errorInsert", "Une erreur est survenue lors de l'enregistrement");
                    this.doGet(request, response);
                    return;
                }

                int formResp = Integer.parseInt(choixFormResp);

                PreparedStatement preparedStatement = connection.prepareStatement(insertFormRespQuery);
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);
                preparedStatement.setInt(5, formResp);
                preparedStatement.setNull(6, Types.NVARCHAR);
                preparedStatement.execute();

                request.setAttribute("warningInsert", null);
                request.setAttribute("errorInsert", null);
            }

            this.doGet(request, response);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/admin").forward(request, response);
    }
}
