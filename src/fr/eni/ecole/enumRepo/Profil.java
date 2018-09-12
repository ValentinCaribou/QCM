package fr.eni.ecole.enumRepo;

public enum Profil {
    CANDIDAT_LIBRE(1), STAGIAIRE(2), RESPONSABLE(3), FORMATEUR(4), ADMIN(5), CELLULE_RECRUTEMENT(6);

    public Integer codeProfil;

    public Integer getCode() {
        return codeProfil;
    }

    Profil(Integer code)
    {
        this.codeProfil = code;
    }

}
