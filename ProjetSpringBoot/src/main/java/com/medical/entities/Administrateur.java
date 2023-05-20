package com.medical.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_administrateur;
    @Column(nullable = false)
    private String nom_utilisateur;
    @Column(nullable = false)
    private String password;

    public Administrateur() {
    }

    public Administrateur(String nom_utilisateur, String password) {
        this.nom_utilisateur = nom_utilisateur;
        this.password = password;
    }

    public Integer getId_administrateur() {
        return id_administrateur;
    }

    public void setId_administrateur(Integer id_administrateur) {
        this.id_administrateur = id_administrateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "id_administrateur=" + id_administrateur +
                ", nom_utilisateur='" + nom_utilisateur + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
