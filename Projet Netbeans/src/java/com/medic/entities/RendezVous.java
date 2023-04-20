/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.entities;

/**
 *
 * @author hundl
 */
public class RendezVous {
    private int idRendezVous;
    private int idPatientRv;
    private int idMedecinRv;
    private String dateRv;
    private String heureRv;
    private String raisonConsult;
    private String descriptionConsult;

    public RendezVous() {
    }

    public int getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(int idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public int getIdPatientRv() {
        return idPatientRv;
    }

    public void setIdPatientRv(int idPatientRv) {
        this.idPatientRv = idPatientRv;
    }

    public int getIdMedecinRv() {
        return idMedecinRv;
    }

    public void setIdMedecinRv(int idMedecinRv) {
        this.idMedecinRv = idMedecinRv;
    }

    public String getDateRv() {
        return dateRv;
    }

    public void setDateRv(String dateRv) {
        this.dateRv = dateRv;
    }

    public String getHeureRv() {
        return heureRv;
    }

    public void setHeureRv(String heureRv) {
        this.heureRv = heureRv;
    }

    public String getRaisonConsult() {
        return raisonConsult;
    }

    public void setRaisonConsult(String raisonConsult) {
        this.raisonConsult = raisonConsult;
    }

    public String getDescriptionConsult() {
        return descriptionConsult;
    }

    public void setDescriptionConsult(String descriptionConsult) {
        this.descriptionConsult = descriptionConsult;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "idRendezVous=" + idRendezVous + ", idPatientRv=" + idPatientRv + ", idMedecinRv=" + idMedecinRv + ", dateRv=" + dateRv + ", heureRv=" + heureRv + ", raisonConsult=" + raisonConsult + ", descriptionConsult=" + descriptionConsult + '}';
    }
    
    
    
}
