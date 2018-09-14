package fr.eni.ecole.constantes;

import fr.eni.ecole.repo.Theme;

public class ConstantesSql {

    public static final String connexionQuery = "SELECT idUtilisateur, nom, prenom, email, password, codeProfil, codePromo FROM [BDD_QCM].[dbo].[UTILISATEUR] WHERE email = ? ";


    public static final String themeCreate = "INSERT INTO [BDD_QCM].[dbo].[THEME](libelle) VALUES (?) ";
    public static final String themeQuery = "SELECT * FROM [BDD_QCM].[dbo].[THEME] ";
    public static final String getThemeUpdate = "UPDATE [BDD_QCM].[dbo].[THEME] SET libelle = ? WHERE idTheme = ? ";
    public static final String themeDelete = "DELETE FROM [BDD_QCM].[dbo].[THEME] WHERE idTheme =  ? ";
}

