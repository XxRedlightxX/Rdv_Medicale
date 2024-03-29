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
public class Clinique {
    private int id;
    private String nom;
    private String coordonnees;
    List<String> servicesOfferts;
    List<Medecin> medecinDansClinique;
    List<Patient> patientDeClinique;

    public Clinique(int id, String nom, String coordonnees, List<String> servicesOfferts, List<Medecin> medecinDansClinique, List<Patient> patientDeClinique) {
        this.id = id;
        this.nom = nom;
        this.coordonnees = coordonnees;
        this.servicesOfferts = servicesOfferts;
        this.medecinDansClinique = medecinDansClinique;
        this.patientDeClinique = patientDeClinique;
    }

    public List<Medecin> getMedecinDansClinique() {
        return medecinDansClinique;
    }

    public void setMedecinDansClinique(List<Medecin> medecinDansClinique) {
        this.medecinDansClinique = medecinDansClinique;
    }

    public List<Patient> getPatientDeClinique() {
        return patientDeClinique;
    }

    public void setPatientDeClinique(List<Patient> patientDeClinique) {
        this.patientDeClinique = patientDeClinique;
    }

    

    public Clinique() {
        servicesOfferts = new ArrayList<String>();
        medecinDansClinique = new ArrayList<Medecin>();
        patientDeClinique = new ArrayList<Patient>();
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(String coordonnees) {
        this.coordonnees = coordonnees;
    }

    public List<String> getServicesOfferts() {
        return servicesOfferts;
    }

    public void setServicesOfferts(List<String> servicesOfferts) {
        this.servicesOfferts = servicesOfferts;
    }

     public void ajouterService(String unService) {
        this.servicesOfferts.add(unService);
    }

    public void supprimerService(String unService) {
        for (int i = 0; i<this.servicesOfferts.size();i++) {
            if(this.servicesOfferts.get(i).equals(unService)){
                this.servicesOfferts.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Clinique{" + "id=" + id + ", nom=" + nom + ", coordonnees=" + coordonnees + ", servicesOfferts=" + servicesOfferts + ", medecinDansClinique=" + medecinDansClinique + ", patientDeClinique=" + patientDeClinique + '}';
    }

   
}
