/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.entities;

/**
 *
 * @author hundl
 */
public class Services {
    private String id;
    private String nom;
    private String description;

    public Services(String id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public Services() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Services{" + "id=" + id + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
    
}
