package com.medical.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "clinique")
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_clinique;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String coordonnees;

    @ManyToMany
    @JoinTable(
            name = "clinique_has_services",
            joinColumns = @JoinColumn(name = "clinique_id_clinique"),
            inverseJoinColumns = @JoinColumn(name = "services_id_service")
    )
    private Set<ServicesClinique> services = new HashSet();

    public void ajouterService(ServicesClinique service){
        this.services.add(service);
    }

    public Clinique() {
    }

    public Clinique(String nom, String coordonnees) {
        this.nom = nom;
        this.coordonnees = coordonnees;
    }

    public Integer getId_clinique() {
        return id_clinique;
    }

    public void setId_clinique(Integer id_clinique) {
        this.id_clinique = id_clinique;
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

    public Set<ServicesClinique> getServices() {
        return services;
    }

    public void setServices(Set<ServicesClinique> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Clinique{" +
                "id_clinique=" + id_clinique +
                ", nom='" + nom + '\'' +
                ", coordonnees='" + coordonnees + '\'' +
                ", services=" + services +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clinique)) return false;
        Clinique clinique = (Clinique) o;
        return getId_clinique().equals(clinique.getId_clinique()) && getNom().equals(clinique.getNom()) && getCoordonnees().equals(clinique.getCoordonnees()) && getServices().equals(clinique.getServices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_clinique(), getNom(), getCoordonnees(), getServices());
    }
}
