package fr.eni.ecole.servlets;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static fr.eni.ecole.constantes.ConstantesSql.getQuestionsByIdTheme;
import static fr.eni.ecole.constantes.ConstantesSql.getThemesByIdTest;

@WebServlet(name = "ServletTest", urlPatterns = "/test")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();

            String idTest = request.getParameter("idTest");
            if(idTest == null || idTest.equals("")) {
                request.setAttribute("errorIdTest", "Le test n'a pas pu être trouvé");
                this.getServletContext().getRequestDispatcher("/listeTests").forward(request, response);
                return;
            }

            int id = Integer.parseInt(idTest);

            PreparedStatement preparedStatementThemes = connection.prepareStatement(getThemesByIdTest);
            preparedStatementThemes.setInt(1, id);
            ResultSet resultSetThemes = preparedStatementThemes.executeQuery();

            ArrayList<FormRespDto> questions = new ArrayList<>();
            while(resultSetThemes.next()) {
                PreparedStatement preparedStatementQuestions = connection.prepareStatement(getQuestionsByIdTheme);
                preparedStatementQuestions.setInt(1, id);
                ResultSet resultSetQuestions = preparedStatementQuestions.executeQuery();
            }

            //request.setAttribute("users", utilisateurs);

            this.getServletContext().getRequestDispatcher("/testPage").forward(request, response);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
