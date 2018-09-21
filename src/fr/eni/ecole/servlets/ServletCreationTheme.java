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
import java.util.ArrayList;

@WebServlet(name = "ServletCreationTheme", urlPatterns = "/theme")
public class ServletCreationTheme extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            String supprimer = request.getParameter("supprimer");
            if (supprimer != null && supprimer!=""){
                int supr = Integer.parseInt(request.getParameter("supprimer"));
                    PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.themeDelete);
                    preparedStatement.setInt(1,supr);
                    preparedStatement.executeUpdate();
                    this.doGet(request,response);
                    return;
            }
            String libelle = request.getParameter("libelle");
            if (libelle.equals("")  || libelle.equals(null)){
                this.doGet(request,response);
                return;
            }
            //String modifier =  request.getParameter("modifier");
            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.themeCreate);
            preparedStatement.setString(1,libelle);
            preparedStatement.executeUpdate();

            this.doGet(request,response);

        }
        catch (SQLException | NamingException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ArrayList<Theme> listThemes = new ArrayList<Theme>();

            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.themeQuery);
            ResultSet resultSet = preparedStatement.executeQuery();



            while(resultSet.next()) {
                String libelleBdd = resultSet.getString("libelle");
                Theme theme = new Theme(resultSet.getInt("IdTheme"),libelleBdd);
                listThemes.add(theme);
            }

            request.setAttribute( "theme", listThemes );
            this.getServletContext().getRequestDispatcher( "/themes" ).forward( request, response );

        }
        catch (SQLException | NamingException e) {
            e.printStackTrace();
        }



       // this.getServletContext().getRequestDispatcher("/themes").forward(request, response);


    }
}
