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
    private String nom;
    private String prenom;
    private String specialite;
    private int numeroProfessionel;
    private float facturation;
    private String coordonnées;
    private String coordonnéesTravail;
    private String motDePasse;

    public Medecin(String nom, String prenom, String specialite, int numeroProfessionel, float facturation, String coordonnées, String coordonnéesTravail, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.numeroProfessionel = numeroProfessionel;
        this.facturation = facturation;
        this.coordonnées = coordonnées;
        this.coordonnéesTravail = coordonnéesTravail;
        this.motDePasse = motDePasse;
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

    public int getNumeroProfessionel() {
        return numeroProfessionel;
    }

    public void setNumeroProfessionel(int numeroProfessionel) {
        this.numeroProfessionel = numeroProfessionel;
    }

    public float getFacturation() {
        return facturation;
    }

    public void setFacturation(float facturation) {
        this.facturation = facturation;
    }

    public String getCoordonnées() {
        return coordonnées;
    }

    public void setCoordonnées(String coordonnées) {
        this.coordonnées = coordonnées;
    }

    public String getCoordonnéesTravail() {
        return coordonnéesTravail;
    }

    public void setCoordonnéesTravail(String coordonnéesTravail) {
        this.coordonnéesTravail = coordonnéesTravail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Medecin{" + "nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", numeroProfessionel=" + numeroProfessionel + ", facturation=" + facturation + ", coordonn\u00e9es=" + coordonnées + ", coordonn\u00e9esTravail=" + coordonnéesTravail + ", motDePasse=" + motDePasse + '}';
    }

}
