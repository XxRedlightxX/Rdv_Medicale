/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medic.entities;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 1482910
 */
public class Patient {
    private String id;
    private String nom;
    private String prenom;
    private String numeroAssuranceMaladie;
    private int numeroSequentiel;
    private String dateNaissance;
    private String sexe;
    private String motDePasse;

    public Patient(String id, String nom, String prenom, String numeroAssuranceMaladie, int numeroSequentiel, String dateNaissance, String sexe, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroAssuranceMaladie = numeroAssuranceMaladie;
        this.numeroSequentiel = numeroSequentiel;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.motDePasse = motDePasse;
    }



    public Patient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNumeroAssuranceMaladie() {
        return numeroAssuranceMaladie;
    }

    public void setNumeroAssuranceMaladie(String numeroAssuranceMaladie) {
        this.numeroAssuranceMaladie = numeroAssuranceMaladie;
    }

    public int getNumeroSequentiel() {
        return numeroSequentiel;
    }

    public void setNumeroSequentiel(int numeroSequentiel) {
        this.numeroSequentiel = numeroSequentiel;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }   

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numeroAssuranceMaladie=" + numeroAssuranceMaladie + ", numeroSequentiel=" + numeroSequentiel + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", motDePasse=" + motDePasse + '}';
    }


}
