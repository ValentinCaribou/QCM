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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import static fr.eni.ecole.constantes.ConstantesSql.deleteFormRespQuery;
import static fr.eni.ecole.constantes.ConstantesSql.insertFormRespQuery;

@WebServlet(name = "ServletAdminDelete", urlPatterns = "/admin/delete")
public class ServletAdminDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            String id = request.getParameter("id");
            if(id != null && !id.equals("")) {
                int idUtilisateur = Integer.parseInt(id);

                PreparedStatement preparedStatement = connection.prepareStatement(deleteFormRespQuery);
                preparedStatement.setInt(1, idUtilisateur);
                preparedStatement.execute();
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/admin");
    }
}
