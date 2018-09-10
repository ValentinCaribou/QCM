package fr.eni.ecole.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletDeconnexion", urlPatterns = "/deconnexion")
public class Deconnexion extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getParameter("mail");
        if(session.getAttribute("mail") == null){
            this.getServletContext().getRequestDispatcher("/index").forward(request, response);
        } else {
            session.getAttribute("mail");
            session.invalidate();
            this.getServletContext().getRequestDispatcher("/index").forward(request, response);
        }
    }
}
