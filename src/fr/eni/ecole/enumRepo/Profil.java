package fr.eni.ecole.enumRepo;

public enum Profil {
    CANDIDAT_LIBRE(1), STAGIAIRE(2), RESPONSABLE(3), FORMATEUR(4), ADMIN(5), CELLULE_RECRUTEMENT(6);

    private Integer codeProfil;

    public Integer getCode() {
        return codeProfil;
    }

    private Profil(Integer code)
    {
        this.codeProfil = code;
    }

}
