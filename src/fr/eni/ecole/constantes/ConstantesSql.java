package fr.eni.ecole.constantes;

public class ConstantesSql {
    /* BDD */
    public static final String connectionString = "java:comp/env/jdbc/pool_cnx";
    public static final String connectionQuery = "SELECT idUtilisateur, nom, prenom, email, password, codeProfil, codePromo FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE email = ?";

    /* Users */
    public static final String getUserQuery =   "SELECT [idUtilisateur]" +
                                                "      ,[nom]" +
                                                "      ,[prenom]" +
                                                "      ,[email]" +
                                                "      ,[password]" +
                                                "      ,[codeProfil]" +
                                                "      ,[codePromo] " +
                                                "  FROM [BDD_QCM].[dbo].[UTILISATEUR] ";

    public static final String getCandidatStagiaireQuery = getUserQuery + "WHERE codeProfil = ? or codeProfil = ?;";
    public static final String getFormRespQuery =   "SELECT [idUtilisateur] " +
                                                    "      ,[nom] " +
                                                    "      ,[prenom] " +
                                                    "      ,[email] " +
                                                    "      ,[password] " +
                                                    "      ,p.libelle AS profil " +
                                                    "  FROM [BDD_QCM].[dbo].[UTILISATEUR] u " +
                                                    "  JOIN [BDD_QCM].[dbo].[PROFIL] p " +
                                                    "  ON p.codeProfil = u.codeProfil " +
                                                    "  WHERE u.codeProfil = ? OR u.codeProfil = ?";

    public static final String getUserById = "SELECT [idUtilisateur] " +
                                             "      ,[nom] " +
                                             "      ,[prenom] " +
                                             "      ,[email] " +
                                             "      ,[password] " +
                                             "      ,[codeProfil] " +
                                             "      ,[codePromo] " +
                                             "  FROM [BDD_QCM].[dbo].[UTILISATEUR] u " +
                                             "  WHERE [idUtilisateur] = ?";

    public static final String insertFormRespQuery = "INSERT INTO [BDD_QCM].[dbo].[UTILISATEUR] " +
                                                     "           ([nom] " +
                                                     "           ,[prenom] " +
                                                     "           ,[email] " +
                                                     "           ,[password] " +
                                                     "           ,[codeProfil] " +
                                                     "           ,[codePromo]) " +
                                                     "     VALUES " +
                                                     "           ( ?" +
                                                     "           , ?" +
                                                     "           , ?" +
                                                     "           , ?" +
                                                     "           , ?" +
                                                     "           , ?)";

    public static final String deleteFormRespQuery = "DELETE FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE idUtilisateur = ?";

    public static final String updateFormRespQuery = "UPDATE [BDD_QCM].[dbo].[UTILISATEUR] " +
                                                     "   SET [nom] = ? " +
                                                     "      ,[prenom] = ? " +
                                                     "      ,[email] = ? " +
                                                     "      ,[password] = ? " +
                                                     "      ,[codeProfil] = ? " +
                                                     " WHERE idUtilisateur = ?";

    public static final String getCandidat = "SELECT [idUtilisateur]" +
            "      ,[nom]" +
            "      ,[prenom]" +
            "      ,[email]" +
            "      ,[password]" +
            "      ,[codeProfil]" +
            "      ,[codePromo]" +
            "  FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE codeProfil = 1 or codeProfil = 2;";

    public static final String connexionQuery = "SELECT idUtilisateur, nom, prenom, email, password, codeProfil, codePromo FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE email = ? ";


    public static final String themeCreate = "INSERT INTO [BDD_QCM].[dbo].[THEME](libelle) VALUES (?) ";
    public static final String themeQuery = "SELECT * FROM [BDD_QCM].[dbo].[THEME] ";
    public static final String getThemeQueryWithId = "SELECT * FROM [BDD_QCM].[dbo].[THEME] WHERE idTheme = ? ";
    public static final String getThemeUpdate = "UPDATE [BDD_QCM].[dbo].[THEME] SET libelle = ? WHERE idTheme = ? ";
    public static final String themeDelete = "DELETE FROM [BDD_QCM].[dbo].[THEME] WHERE idTheme =  ? ";

    public static final String questionCreate = "INSERT INTO [BDD_QCM].[dbo].[QUESTION] (enonce, media, points, idTheme) VALUES (?, ?, ?, ?)" ;

    public static final String testCreate = "INSERT INTO [BDD_QCM].[dbo].[QUESTION](libelle, description, duree, seuil_haut, seuil_bas) VALUES (?, ?, ?, ?, ?)";

    public static final String getCandidatByTwoCodePromo = "SELECT [idUtilisateur]" +
            "      ,[nom]" +
            "      ,[prenom]" +
            "      ,[email]" +
            "      ,[password]" +
            "      ,[codeProfil]" +
            "      ,p.libelle AS promotion" +
            "  FROM [BDD_QCM].[dbo].[UTILISATEUR] u" +
            "  JOIN [BDD_QCM].[dbo].[PROMOTION] p" +
            "  ON p.codePromo = u.codePromo" +
            "  WHERE u.codePromo = 1 or u.codePromo = 2;";

    public static final String getCandidatByCodePromo = "SELECT [idUtilisateur]" +
            "      ,[nom]" +
            "      ,[prenom]" +
            "      ,[email]" +
            "      ,[password]" +
            "      ,[codeProfil]" +
            "      ,[codePromo]" +
            "  FROM [BDD_QCM].[dbo].[UTILISATEUR]" +
            "  WHERE [codePromo] = ?;";

    public static final String createUser = "INSERT INTO [BDD_QCM].[dbo].[UTILISATEUR]\n" +
            "           ([nom]" +
            "           ,[prenom]" +
            "           ,[email]" +
            "           ,[password]" +
            "           ,[codeProfil]" +
            "           ,[codePromo])" +
            "     VALUES" +
            "           (?" +
            "           ,?" +
            "           ,?" +
            "           ,?" +
            "           ,?" +
            "           ,?)";

    /* Themes */
    public static final String getThemeQcm = "SELECT [idTheme],[libelle] FROM [BDD_QCM].[dbo].[THEME]";

    public static final String getThemeQcmQuery = "SELECT [idTheme],[libelle] FROM [BDD_QCM].[dbo].[THEME]";

    /* Tests */
    public static final String getTestQCM = "SELECT [idTest]" +
                                            "      ,[libelle]" +
                                            "      ,[description]" +
                                            "      ,[duree]" +
                                            "      ,[seuil_haut]" +
                                            "      ,[seuil_bas] " +
                                            "  FROM [BDD_QCM].[dbo].[TEST]";

    /* Inscriptions */
    public static final String insertInscription = "INSERT INTO [BDD_QCM].[dbo].[EPREUVE]" +
            "           ([dateDedutValidite]" +
            "           ,[dateFinValidite]" +
            "           ,[tempsEcoule]" +
            "           ,[etat]" +
            "           ,[note_obtenue]" +
            "           ,[niveau_obtenu]" +
            "           ,[idTest]" +
            "           ,[idUtilisateur])" +
            "     VALUES" +
            "           (?" +
            "           ,?" +
            "           ,?" +
            "           ,?" +
            "           ,?" +
            "           ,?" +
            "           ,?" +
            "           ,?)";

    /* Promotions */
    public static final String getPromotion = "SELECT [codePromo]" +
            "      ,[Libelle]" +
            "  FROM [BDD_QCM].[dbo].[PROMOTION]";

    /* Résultats */
    public static final String getResultUser = "SELECT [idEpreuve]" +
            "      ,[dateDedutValidite]" +
            "      ,[dateFinValidite]" +
            "      ,[tempsEcoule]" +
            "      ,[etat]" +
            "      ,[note_obtenue]" +
            "      ,[niveau_obtenu]" +
            "      ,t.libelle AS nomTest" +
            "      ,[idUtilisateur]" +
            "  FROM [BDD_QCM].[dbo].[EPREUVE] e" +
            "  JOIN [BDD_QCM].[dbo].[TEST] t" +
            "  ON e.idTest = t.idTest" +
            "  WHERE [idUtilisateur] = ?";
}
