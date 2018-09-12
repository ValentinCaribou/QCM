package fr.eni.ecole.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hd = request.getHeader("User-Agent");
//        response.sendRedirect("http://www.google.fr");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (hd.contains("MSIE")){
            response.setStatus(404);
        }
        out.println("<h2>");
        response.getWriter().append("Server at: ").append(request.getContextPath());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getParameter("nom"));
        System.out.println(Arrays.deepToString(request.getParameterValues("nom")));
        System.out.println(request.getQueryString());
        Enumeration<String> nomDesParametres = request.getParameterNames();

        while (nomDesParametres.hasMoreElements()){
            String nomCourant = nomDesParametres.nextElement();
            System.out.println(request.getParameter(nomCourant));
        }

        out.println("</h2>");

        String url = "jdbc:sqlserver://localhost/BDD_QCM";
        String utilisateur = "sa";
        String motDePasse = "Pa$$w0rd";
        Connection connexion = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
