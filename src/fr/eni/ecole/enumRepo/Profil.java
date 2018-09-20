package fr.eni.ecole.enumRepo;

public enum Profil {
    CANDIDAT_LIBRE(1), STAGIAIRE(2), RESPONSABLE(3), FORMATEUR(4), ADMIN(5), CELLULE_RECRUTEMENT(6);

    public int codeProfil;

    public int getCode() {
        return codeProfil;
    }

    private Profil(int code)
    {
        this.codeProfil = code;
    }

}
