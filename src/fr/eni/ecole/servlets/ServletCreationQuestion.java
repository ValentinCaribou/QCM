package fr.eni.ecole.servlets;

import fr.eni.ecole.constantes.ConstantesSql;
import fr.eni.ecole.repo.Theme;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "ServletCreationQuestion", urlPatterns = "/question")
/*@MultipartConfig(location = "C:\\Users\\Administrateur\\IdeaProjects\\QCM\\out\\artifacts\\web_war_exploded\\mediaTemp\\",fileSizeThreshold=1048576,
        maxFileSize=20971520, maxRequestSize=52428800)*/
public class ServletCreationQuestion extends HttpServlet {

   /* public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "C:\\Users\\Administrateur\\IdeaProjects\\QCM\\out\\artifacts\\web_war_exploded\\media\\";*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperation des champs
        String enonce = request.getParameter("enonce");
        String media = request.getParameter("media");
        int points = Integer.parseInt(request.getParameter("points"));
        int idTheme = Integer.parseInt(request.getParameter("idTheme"));

        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesSql.questionCreate);
            preparedStatement.setString(1,enonce);
            preparedStatement.setString(2, media);
            preparedStatement.setInt(3, points);
            preparedStatement.setInt(4, idTheme);
            preparedStatement.executeUpdate();

            this.doGet(request,response);

        }
        catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        /*System.out.println(getServletContext().getRealPath("/index.jsp"));

        //recuperation du fichier
        Part part = request.getPart("media");
        //verification du fichier
        String nomFichier = getNomFichier(part);

        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // On écrit définitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
        }
        this.doGet(request,response);*/
    }

//    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
//        BufferedInputStream entree = null;
//        BufferedOutputStream sortie = null;
//        try {
//            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
//            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
//
//            byte[] tampon = new byte[TAILLE_TAMPON];
//            int longueur;
//            while ((longueur = entree.read(tampon)) > 0) {
//                sortie.write(tampon, 0, longueur);
//            }
//        } finally {
//            try {
//                sortie.close();
//            } catch (IOException ignore) {
//            }
//            try {
//                entree.close();
//            } catch (IOException ignore) {
//            }
//        }
//    }
//
//    private static String getNomFichier( Part part ) {
//        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
//            if ( contentDisposition.trim().startsWith( "filename" ) ) {
//                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
//            }
//        }
//        return null;
//    }


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
            this.getServletContext().getRequestDispatcher( "/questions" ).forward( request, response );

        }
        catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        //this.getServletContext().getRequestDispatcher("/questions").forward(request, response);
    }
}
