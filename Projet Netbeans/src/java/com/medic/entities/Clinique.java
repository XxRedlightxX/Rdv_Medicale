/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medic.entities;

import java.util.List;

/**
 *
 * @author 1482910
 */
public class Clinique {
    private int id;
    private String nom;
    private String coordonnées;
    private List<String> servicesOfferts;

    public Clinique(String nom, String coordonnées, List<String> servicesOfferts) {
        this.nom = nom;
        this.coordonnées = coordonnées;
        this.servicesOfferts = servicesOfferts;
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

    @Override
    public String toString() {
        return "Clinique{" + "id=" + id + ", nom=" + nom + ", coordonn\u00e9es=" + coordonnées + ", servicesOfferts=" + servicesOfferts + '}';
    }
}
