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
    private String coordonnées;
    List<String> servicesOfferts;
    List<Medecin> medecinDansClinique;
    List<Patient> patientDeClinique;

    public Clinique(String nom, String coordonnées, List<String> servicesOfferts,List<Medecin> medecinDansClinique,         List<Patient> patientDeClinique;;) {
        this.nom = nom;
        this.coordonnées = coordonnées;
        this.servicesOfferts = servicesOfferts;
        this.medecinDansClinique = medecinDansClinique;
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

    public String getCoordonnées() {
        return coordonnées;
    }

    public void setCoordonnées(String coordonnées) {
        this.coordonnées = coordonnées;
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
        for (int i = 0; i<this.servicesOfferts.length();i++) {
            if(this.servicesOfferts.get(i).equals(unService)){
                this.servicesOfferts.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Clinique{" + "id=" + id + ", nom=" + nom + ", coordonn\u00e9es=" + coordonnées + ", servicesOfferts=" + servicesOfferts + '}';
    }
}
