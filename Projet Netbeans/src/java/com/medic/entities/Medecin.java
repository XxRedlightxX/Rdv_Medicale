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
public class Medecin {

    private int numeroProfessionel;
    private String nom;
    private String prenom;
    private String specialite;
    private float facturation;
    private String motDePasse;
    private String coordonnees;
    private int idCliniqueEmploi;

    List<Patient> listePatients;

    public Medecin() {
        listePatients = new ArrayList<Patient>();
    }

    public String getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(String coordonnees) {
        this.coordonnees = coordonnees;
    }

    public List<Patient> getListePatients() {
        return listePatients;
    }

    public void setListePatients(List<Patient> listePatients) {
        this.listePatients = listePatients;
    }

    

    public int getNumeroProfessionel() {
        return numeroProfessionel;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getIdCliniqueEmploi() {
        return idCliniqueEmploi;
    }

    public void setIdCliniqueEmploi(int idCliniqueEmploi) {
        this.idCliniqueEmploi = idCliniqueEmploi;
    }

    @Override
    public String toString() {
        return "Medecin{" + "numeroProfessionel=" + numeroProfessionel + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", facturation=" + facturation + ", motDePasse=" + motDePasse + ", coordonnees=" + coordonnees + ", listePatients=" + listePatients + '}';
    }

}
