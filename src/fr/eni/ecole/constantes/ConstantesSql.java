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
    public static final String getTestQCM = "SELECT [idTest]" +
            "      ,[libelle]" +
            "      ,[description]" +
            "      ,[duree]" +
            "      ,[seuil_haut]" +
            "      ,[seuil_bas]" +
            "  FROM [BDD_QCM].[dbo].[TEST]";
}
