package com.medical.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "medecin")
public class Medecin {
    @Id
    @Column (nullable = false)
    private int id_medecin;
    @Column (nullable = false)
    private String nom;
    @Column (nullable = false)
    private String prenom;
    @ManyToOne
    @JoinColumn(name="specialite", referencedColumnName ="nom",nullable = false)
    private ServicesClinique specialite;

    @Column (nullable = false)
    private float facturation;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private String coordonnees_medecin;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Clinique clinique;

    public Medecin() {
    }

    public Medecin(String nom, String prenom, ServicesClinique specialite, float facturation, String password, String coordonnees_medecin, Clinique clinique) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.facturation = facturation;
        this.password = password;
        this.coordonnees_medecin = coordonnees_medecin;
        this.clinique = clinique;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
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

    public ServicesClinique getspecialite() {
        return specialite;
    }

    public void setspecialite(ServicesClinique specialite) {
        this.specialite = specialite;
    }

    public float getFacturation() {
        return facturation;
    }

    public void setFacturation(float facturation) {
        this.facturation = facturation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoordonnees_medecin() {
        return coordonnees_medecin;
    }

    public void setCoordonnees_medecin(String coordonnees_medecin) {
        this.coordonnees_medecin = coordonnees_medecin;
    }

    public Clinique getClinique() {
        return clinique;
    }

    public void setClinique(Clinique clinique) {
        this.clinique = clinique;
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "id_medecin=" + id_medecin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", specialite=" + specialite +
                ", facturation=" + facturation +
                ", password='" + password + '\'' +
                ", coordonnees_medecin='" + coordonnees_medecin + '\'' +
                ", clinique=" + clinique +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medecin)) return false;
        Medecin medecin = (Medecin) o;
        return getId_medecin() == medecin.getId_medecin() && Float.compare(medecin.getFacturation(), getFacturation()) == 0 && getNom().equals(medecin.getNom()) && getPrenom().equals(medecin.getPrenom()) && specialite.equals(medecin.specialite) && getPassword().equals(medecin.getPassword()) && getCoordonnees_medecin().equals(medecin.getCoordonnees_medecin()) && getClinique().equals(medecin.getClinique());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_medecin(), getNom(), getPrenom(), specialite, getFacturation(), getPassword(), getCoordonnees_medecin(), getClinique());
    }
}
