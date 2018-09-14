package fr.eni.ecole.constantes;

public class ConstantesSql {
    public static final String connectionString = "java:comp/env/jdbc/pool_cnx";
    public static final String connectionQuery = "SELECT idUtilisateur, nom, prenom, email, password, codeProfil, codePromo FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE email = ?";

    public static final String getThemeQcm = "SELECT [idTheme],[libelle] FROM [BDD_QCM].[dbo].[THEME]";
    public static final String getCandidat = "SELECT [idUtilisateur]" +
            "      ,[nom]" +
            "      ,[prenom]" +
            "      ,[email]" +
            "      ,[password]" +
            "      ,[codeProfil]" +
            "      ,[codePromo]" +
            "  FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE codeProfil = 1 or codeProfil = 2;";
    public static final String getTestQCM = "SELECT [idTest]" +
            "      ,[libelle]" +
            "      ,[description]" +
            "      ,[duree]" +
            "      ,[seuil_haut]" +
            "      ,[seuil_bas]" +
            "  FROM [BDD_QCM].[dbo].[TEST]";

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
}
