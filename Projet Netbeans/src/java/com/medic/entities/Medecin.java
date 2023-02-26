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
    List<Patient> listePatients;

    public Medecin(int numeroProfessionel, String nom, String prenom, String specialite, float facturation, String motDePasse, List<Patient> listePatients) {
        this.numeroProfessionel = numeroProfessionel;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.facturation = facturation;
        this.motDePasse = motDePasse;
        this.listePatients = listePatients;
    }



    public List<Patient> getListePatients() {
        return listePatients;
    }

    public void setListePatients(List<Patient> listePatients) {
        this.listePatients = listePatients;
    }

    

    public Medecin() {
        listePatients = new ArrayList<Patient>();
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

    @Override
    public String toString() {
        return "Medecin{" + "numeroProfessionel=" + numeroProfessionel + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", facturation=" + facturation + ", motDePasse=" + motDePasse + ", listePatients=" + listePatients + '}';
    }



  
}
