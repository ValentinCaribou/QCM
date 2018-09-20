package fr.eni.ecole.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerifSession {

    public static boolean checkSession(int paramSession, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("codeProfil") != null) {
            int sessionContenu = (int) session.getAttribute("codeProfil");
            if (sessionContenu == paramSession) {
                return true;
            } else {
                System.out.println("session invalide");
                return false;
            }
        } else {
            System.out.println("session invalide");
            return false;
        }
    }
}
