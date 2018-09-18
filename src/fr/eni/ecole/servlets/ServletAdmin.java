package fr.eni.ecole.servlets;

import fr.eni.ecole.enumRepo.Profil;
import fr.eni.ecole.repo.FormRespDto;

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
import java.util.logging.Logger;

import static fr.eni.ecole.constantes.ConstantesSql.getFormRespQuery;

@WebServlet(name = "ServletAdmin", urlPatterns = "/admin")
public class ServletAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(getFormRespQuery);
            preparedStatement.setInt(1, Profil.RESPONSABLE.getCode());
            preparedStatement.setInt(2, Profil.FORMATEUR.getCode());
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<FormRespDto> utilisateurs = new ArrayList<>();
            while(resultSet.next()) {
                utilisateurs.add(
                        new FormRespDto(
                                resultSet.getInt("idUtilisateur"),
                                resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("profil")
                        )
                );
            }
            Logger logger = Logger.getLogger(this.getServletName());
            logger.info("test");

            request.setAttribute("users", utilisateurs);

            this.getServletContext().getRequestDispatcher("/adminPage").forward(request, response);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
