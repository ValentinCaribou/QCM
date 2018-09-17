package fr.eni.ecole.constantes;

public class ConstantesSql {

    public static final String connexionQuery = "SELECT idUtilisateur, nom, prenom, email, password, codeProfil, codePromo FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE email = ?";
    public static final String getThemeQcm = "SELECT [idTheme],[libelle] FROM [BDD_QCM].[dbo].[THEME]";
    public static final String getCandidat = "SELECT [idUtilisateur]" +
            "      ,[nom]" +
            "      ,[prenom]" +
            "      ,[email]" +
            "      ,[password]" +
            "      ,[codeProfil]" +
            "      ,[codePromo]" +
            "  FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE codeProfil = 1 or codeProfil = 2;";

    public static final String getCandidatPromotion = "SELECT [idUtilisateur]" +
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

    public static final String getCandidatCodePromo = "SELECT [idUtilisateur]" +
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

    public static final String getPromotion = "SELECT [codePromo]" +
            "      ,[Libelle]" +
            "  FROM [BDD_QCM].[dbo].[PROMOTION]";
}
