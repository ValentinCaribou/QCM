package fr.eni.ecole.servlets;

import fr.eni.ecole.constantes.ConstantesSql;
import fr.eni.ecole.repo.Theme;

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

@WebServlet(name = "ServletGestionTheme", urlPatterns ="/gestions" )
public class ServletGestionTheme extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTheme = Integer.parseInt(request.getParameter("idTheme"));
        String libelle = request.getParameter("libelle");

                try {
                    Context context = new InitialContext();
                    DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
                    Connection connection = dataSource.getConnection();


                    PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.getThemeUpdate);
                    preparedStatement.setString(1,libelle);
                    preparedStatement.setInt(2,idTheme);

                    preparedStatement.executeUpdate();

                    request.setAttribute( libelle,libelle );
                }
                catch (SQLException | NamingException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("/theme");
                }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTheme = Integer.parseInt(request.getParameter("idTheme"));

        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.getThemeQueryWithId);
            preparedStatement.setInt(1, idTheme);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                request.setAttribute("idTheme",resultSet.getInt("idTheme"));
                request.setAttribute( "libelle", resultSet.getString("libelle") );
            }



        }catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/gestion").forward(request, response);
    }
}
