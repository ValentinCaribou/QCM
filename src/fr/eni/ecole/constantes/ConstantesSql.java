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

    /* Themes */
    public static final String getTestQCM = "SELECT [idTest]" +
                                            "      ,[libelle]" +
                                            "      ,[description]" +
                                            "      ,[duree]" +
                                            "      ,[seuil_haut]" +
                                            "      ,[seuil_bas] " +
                                            "  FROM [BDD_QCM].[dbo].[TEST]";
    public static final String getThemeQcmQuery = "SELECT [idTheme],[libelle] FROM [BDD_QCM].[dbo].[THEME]";

    /* Inscriptions */
    public static final String insertInscription =  "INSERT INTO [BDD_QCM].[dbo].[EPREUVE]" +
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
}
