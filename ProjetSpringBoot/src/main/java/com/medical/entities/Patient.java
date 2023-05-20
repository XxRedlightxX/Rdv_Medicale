package com.medical.entities;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_patient;
    @Column (nullable = false)
    private String nom;
    @Column (nullable = false)
    private String prenom;
    @Column (nullable = false)
    private String numero_assurance_maladie;
    @Column (nullable = false)
    private int num_seq_numero_assurance_maladie;
    @Column (nullable = false)
    private String date_naissance;
    @Column (nullable = false)
    private String sexe;
    @Column (nullable = false)
    private String password;
    @ManyToOne
    private Medecin medecin;

    public Patient() {
    }

    public Patient(String nom, String prenom, String numero_assurance_maladie, int num_seq_numero_assurance_maladie, String date_naissance, String sexe, String password, Medecin medecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero_assurance_maladie = numero_assurance_maladie;
        this.num_seq_numero_assurance_maladie = num_seq_numero_assurance_maladie;
        this.date_naissance = date_naissance;
        this.sexe = sexe;
        this.password = password;
        this.medecin = medecin;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero_assurance_maladie() {
        return numero_assurance_maladie;
    }

    public void setNumero_assurance_maladie(String numero_assurance_maladie) {
        this.numero_assurance_maladie = numero_assurance_maladie;
    }

    public int getnum_seq_numero_assurance_maladie() {
        return num_seq_numero_assurance_maladie;
    }

    public void setnum_seq_numero_assurance_maladie(int num_seq_numero_assurance_maladie) {
        this.num_seq_numero_assurance_maladie = num_seq_numero_assurance_maladie;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id_patient=" + id_patient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero_assurance_maladie='" + numero_assurance_maladie + '\'' +
                ", num_seq_numero_assurance_maladie=" + num_seq_numero_assurance_maladie +
                ", date_naissance='" + date_naissance + '\'' +
                ", sexe='" + sexe + '\'' +
                ", password='" + password + '\'' +
                ", medecin=" + medecin +
                '}';
    }
}
