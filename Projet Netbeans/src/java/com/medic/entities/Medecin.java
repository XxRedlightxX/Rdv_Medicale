/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medic.entities;

/**
 *
 * @author 1482910
 */
public class Medecin {
    private int numeroProfessionel;
    private String nom;
    private String prenom;
    private String specialite;
    private float facturation;
    private String coordonnees;
    private String nomClinique;
    private String motDePasse;

    public Medecin(int numeroProfessionel, String nom, String prenom, String specialite, float facturation, String coordonnees, String nomClinique, String motDePasse) {
        this.numeroProfessionel = numeroProfessionel;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.facturation = facturation;
        this.coordonnees = coordonnees;
        this.nomClinique = nomClinique;
        this.motDePasse = motDePasse;
    }

    public int getNumeroProfessionel() {
        return numeroProfessionel;
    }

    public Medecin() {
    }

    public void setNumeroProfessionel(int numeroProfessionel) {
        this.numeroProfessionel = numeroProfessionel;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public float getFacturation() {
        return facturation;
    }

    public void setFacturation(float facturation) {
        this.facturation = facturation;
    }

    public String getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(String coordonnees) {
        this.coordonnees = coordonnees;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Medecin{" + "numeroProfessionel=" + numeroProfessionel + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", facturation=" + facturation + ", coordonnees=" + coordonnees + ", nomClinique=" + nomClinique + ", motDePasse=" + motDePasse + '}';
    }
}
