package com.medical.entities;

import javax.persistence.*;

@Entity
@Table(name = "rendez_vous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_rendez_vous;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient_rv;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medecin medecin_rv;
    @Column(nullable = false)
    private String date_rv;
    @Column(nullable = false)
    private String heure_rv;
    @Column(nullable = false)
    private String raison_consult;
    private String description_consult;

    public RendezVous() {
    }

    public RendezVous(Patient patient_rv, Medecin medecin_rv, String date_rv, String heure_rv, String raison_consult, String description_consult) {
        this.patient_rv = patient_rv;
        this.medecin_rv = medecin_rv;
        this.date_rv = date_rv;
        this.heure_rv = heure_rv;
        this.raison_consult = raison_consult;
        this.description_consult = description_consult;
    }

    public int getId_rendez_vous() {
        return id_rendez_vous;
    }

    public void setId_rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public Patient getPatient_rv() {
        return patient_rv;
    }

    public void setPatient_rv(Patient patient_rv) {
        this.patient_rv = patient_rv;
    }

    public Medecin getMedecin_rv() {
        return medecin_rv;
    }

    public void setMedecin_rv(Medecin medecin_rv) {
        this.medecin_rv = medecin_rv;
    }

    public String getDate_rv() {
        return date_rv;
    }

    public void setDate_rv(String date_rv) {
        this.date_rv = date_rv;
    }

    public String getHeure_rv() {
        return heure_rv;
    }

    public void setHeure_rv(String heure_rv) {
        this.heure_rv = heure_rv;
    }

    public String getRaison_consult() {
        return raison_consult;
    }

    public void setRaison_consult(String raison_consult) {
        this.raison_consult = raison_consult;
    }

    public String getDescription_consult() {
        return description_consult;
    }

    public void setDescription_consult(String description_consult) {
        this.description_consult = description_consult;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "id_rendez_vous=" + id_rendez_vous +
                ", patient_rv=" + patient_rv +
                ", medecin_rv=" + medecin_rv +
                ", date_rv='" + date_rv + '\'' +
                ", heure_rv='" + heure_rv + '\'' +
                ", raison_consult='" + raison_consult + '\'' +
                ", description_consult='" + description_consult + '\'' +
                '}';
    }
}
