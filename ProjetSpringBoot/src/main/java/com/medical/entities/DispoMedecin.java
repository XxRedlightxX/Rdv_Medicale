package com.medical.entities;

import javax.persistence.*;

@Entity
@Table (name = "disponibilites_medecin")
public class DispoMedecin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_disponibilites_medecin;
    @Column (nullable = false)
    private String date_dispo;
    @Column (nullable = false)
    private String heure_dispo_debut;
    @Column (nullable = false)
    private String heure_dispo_fin;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medecin medecin_dispo;

    public DispoMedecin() {
    }

    public DispoMedecin(String date_dispo, String heure_dispo_debut, String heure_dispo_fin, Medecin medecin_dispo) {
        this.date_dispo = date_dispo;
        this.heure_dispo_debut = heure_dispo_debut;
        this.heure_dispo_fin = heure_dispo_fin;
        this.medecin_dispo = medecin_dispo;
    }

    public int getId_disponibilites_medecin() {
        return id_disponibilites_medecin;
    }

    public void setId_disponibilites_medecin(int id_disponibilites_medecin) {
        this.id_disponibilites_medecin = id_disponibilites_medecin;
    }

    public String getDate_dispo() {
        return date_dispo;
    }

    public void setDate_dispo(String date_dispo) {
        this.date_dispo = date_dispo;
    }

    public String getHeure_dispo_debut() {
        return heure_dispo_debut;
    }

    public void setHeure_dispo_debut(String heure_dispo_debut) {
        this.heure_dispo_debut = heure_dispo_debut;
    }

    public String getHeure_dispo_fin() {
        return heure_dispo_fin;
    }

    public void setHeure_dispo_fin(String heure_dispo_fin) {
        this.heure_dispo_fin = heure_dispo_fin;
    }

    public Medecin getMedecin_dispo() {
        return medecin_dispo;
    }

    public void setMedecin_dispo(Medecin medecin_dispo) {
        this.medecin_dispo = medecin_dispo;
    }

    public int convertirHeure_dispo_debut(){
        return Integer.parseInt(this.heure_dispo_debut);
    }

    public int convertirHeure_dispo_fin(){
        return Integer.parseInt(this.heure_dispo_fin);
    }

    @Override
    public String toString() {
        return "DispoMedecin{" +
                "id_disponibilites_medecin=" + id_disponibilites_medecin +
                ", date_dispo='" + date_dispo + '\'' +
                ", heure_dispo_debut='" + heure_dispo_debut + '\'' +
                ", heure_dispo_fin='" + heure_dispo_fin + '\'' +
                ", medecin_dispo=" + medecin_dispo +
                '}';
    }
}
