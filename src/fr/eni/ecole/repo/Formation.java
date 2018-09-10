package fr.eni.ecole.repo;

import java.sql.Date;

public class Formation {
    private int id;
    private String libelle;
    private String description;
    private Date debut;
    private Date fin;

    public Formation(int id, String libelle, String description, Date debut, Date fin) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.debut = debut;
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
