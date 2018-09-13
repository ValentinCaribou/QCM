package fr.eni.ecole.servlets;

import fr.eni.ecole.repo.Theme;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String theme = request.getParameter("theme");

        request.setAttribute("theme", theme);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Theme theme = new Theme();


        this.getServletContext().getRequestDispatcher("/themes").forward(request, response);


    }
}
