package fr.eni.ecole.repo;

import java.sql.Date;

public class Epreuve {

    private int idEpreuve;
    private Date dateDebutValidite;
    private Date dateFinValidite;
    private int tempsEcoule;
    private String etat;
    private float note_obtenue;
    private float niveau_obtenu;
    private int idTest;
    private String nomTest;
    private int idUtilisateur;

    public Epreuve(int idEpreuve, Date dateDebutValidite, Date dateFinValidite, int tempsEcoule, String etat, float note_obtenue, float niveau_obtenu, int idTest, int idUtilisateur) {
        this.idEpreuve = idEpreuve;
        this.dateDebutValidite = dateDebutValidite;
        this.dateFinValidite = dateFinValidite;
        this.tempsEcoule = tempsEcoule;
        this.etat = etat;
        this.note_obtenue = note_obtenue;
        this.niveau_obtenu = niveau_obtenu;
        this.idTest = idTest;
        this.idUtilisateur = idUtilisateur;
    }

    public Epreuve(int idEpreuve, Date dateDebutValidite, Date dateFinValidite, int tempsEcoule, String etat, float note_obtenue, float niveau_obtenu, String nomTest, int idUtilisateur) {
        this.idEpreuve = idEpreuve;
        this.dateDebutValidite = dateDebutValidite;
        this.dateFinValidite = dateFinValidite;
        this.tempsEcoule = tempsEcoule;
        this.etat = etat;
        this.note_obtenue = note_obtenue;
        this.niveau_obtenu = niveau_obtenu;
        this.nomTest = nomTest;
        this.idUtilisateur = idUtilisateur;
    }

    public void setNote_obtenue(float note_obtenue) {
        this.note_obtenue = note_obtenue;
    }

    public void setNiveau_obtenu(float niveau_obtenu) {
        this.niveau_obtenu = niveau_obtenu;
    }

    public String getNomTest() {
        return nomTest;
    }

    public void setNomTest(String nomTest) {
        this.nomTest = nomTest;
    }

    public int getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(int idEpreuve) {
        this.idEpreuve = idEpreuve;
    }

    public Date getDateDebutValidite() {
        return dateDebutValidite;
    }

    public void setDateDebutValidite(Date dateDebutValidite) {
        this.dateDebutValidite = dateDebutValidite;
    }

    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public int getTempsEcoule() {
        return tempsEcoule;
    }

    public void setTempsEcoule(int tempsEcoule) {
        this.tempsEcoule = tempsEcoule;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getNote_obtenue() {
        return note_obtenue;
    }

    public void setNote_obtenue(int note_obtenue) {
        this.note_obtenue = note_obtenue;
    }

    public float getNiveau_obtenu() {
        return niveau_obtenu;
    }

    public void setNiveau_obtenu(int niveau_obtenu) {
        this.niveau_obtenu = niveau_obtenu;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
