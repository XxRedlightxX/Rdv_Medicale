package com.medical.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "services")
public class ServicesClinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_service;
    @Column(nullable = false)
    private String nom;
    private String description;

    public ServicesClinique() {
    }

    public ServicesClinique(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
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
        return "ServicesClinique{" +
                "id_service=" + id_service +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
