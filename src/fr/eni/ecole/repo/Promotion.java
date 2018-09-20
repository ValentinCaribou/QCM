package fr.eni.ecole.repo;

public class Promotion {

    private String codePromo;
    private String libelle;

    public Promotion(String codePromo, String libelle) {
        this.codePromo = codePromo;
        this.libelle = libelle;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
