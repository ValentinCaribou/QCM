package fr.eni.ecole.servlets;

import fr.eni.ecole.repo.Formation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "ServletFormation", urlPatterns = "/listeFormation")
public class ServletFormation extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");

            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();

            Cookie[] cookies = request.getCookies();

            String infos = null;
            if (cookies!=null){
                for (Cookie c : cookies){
                    if(c.getName().equals("Bonjour")){
                        infos = c.getValue();
                        break;
                    }
                }
            }
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, libelle, description, debut, fin FROM formations");
            ResultSet resultSet = statement.executeQuery("SELECT id, libelle, description, debut, fin FROM formations");
            ArrayList<Formation> listeFormation = new ArrayList<Formation>();
            while (resultSet.next()){

                listeFormation.add(new Formation(resultSet.getInt("id"),
                        resultSet.getString("libelle"),
                        resultSet.getString("description"),
                        resultSet.getDate("debut"),
                        resultSet.getDate("fin")));

                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("libelle"));
                System.out.println(resultSet.getString("description"));
                System.out.println(resultSet.getString("debut"));
                System.out.println(resultSet.getString("fin"));
            }

            request.setAttribute("listeFormation", listeFormation);

            File file = new File("test.txt");
            System.out.println("Chemin du fichier : " + file.getAbsolutePath());
            RequestDispatcher requestDispatcher;
            requestDispatcher = (RequestDispatcher) this.getServletContext().getRequestDispatcher("/WEB-INF/ListeResultat.jsp");
            requestDispatcher.include(request, response);

            connection.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
