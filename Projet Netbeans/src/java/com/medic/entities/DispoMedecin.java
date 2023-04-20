/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.entities;

/**
 *
 * @author hundl
 */
public class DispoMedecin {
    private int idDispoMedecin;
    private int idMedecinDispo;
    private String dateDispo;
    private String heureDispoDebut;
    private String heureDispoFin;
    private int idRv;

    public DispoMedecin() {
    }

    public int getIdDispoMedecin() {
        return idDispoMedecin;
    }

    public void setIdDispoMedecin(int idDispoMedecin) {
        this.idDispoMedecin = idDispoMedecin;
    }

    public int getIdMedecinDispo() {
        return idMedecinDispo;
    }

    public void setIdMedecinDispo(int idMedecinDispo) {
        this.idMedecinDispo = idMedecinDispo;
    }

    public String getDateDispo() {
        return dateDispo;
    }

    public void setDateDispo(String dateDispo) {
        this.dateDispo = dateDispo;
    }



    public int getIdRv() {
        return idRv;
    }

    public void setIdRv(int idRv) {
        this.idRv = idRv;
    }

    @Override
    public String toString() {
        return "DispoMedecin{" + "idDispoMedecin=" + idDispoMedecin + ", idMedecinDispo=" + idMedecinDispo + ", dateDispo=" + dateDispo + ", heureDispoDebut=" + heureDispoDebut + ", heureDispoFin=" + heureDispoFin + ", idRv=" + idRv + '}';
    }

    public String getHeureDispoDebut() {
        return heureDispoDebut;
    }

    public void setHeureDispoDebut(String heureDispoDebut) {
        this.heureDispoDebut = heureDispoDebut;
    }

    public String getHeureDispoFin() {
        return heureDispoFin;
    }

    public void setHeureDispoFin(String heureDispoFin) {
        this.heureDispoFin = heureDispoFin;
    }

    
    
}
