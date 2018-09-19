package fr.eni.ecole.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        req.getParameter("codeProfil");
        if (req.getParameter("codeProfil").equals("3")) {

            // l'utilisateur a été identifié comme étant un administrateur
            // il est autorisé à accéder à la servlet filtrée
            chain.doFilter(req, resp) ;

        }  else {

            // l'utilisateur n'est pas authentifié correctement
            // on le redirige vers une page d'erreur
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/erreur") ;
            requestDispatcher.forward(req, resp) ;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
