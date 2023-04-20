/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;

import com.medic.dao.dispoMedecin.DispoMedecinImplDao;
import com.medic.entities.DispoMedecin;
import java.util.List;

/**
 *
 * @author hundl
 */
public class DispoMedecinService {

    DispoMedecinImplDao dao = new DispoMedecinImplDao();
    private List<DispoMedecin> listeDispos = null;
    private DispoMedecin uneDispo = null;
    private Boolean retour = false;

    public List<DispoMedecin> afficherLesDispoMedecins() {
        listeDispos = dao.findAll();
        return listeDispos;
    }

    public DispoMedecin chercherDispoMedecinParId(int id) {
        uneDispo = dao.findByIdDispo(id);
        return uneDispo;
    }

    public List<DispoMedecin> chercherDispoMedecinParIdDuMedecin(int id) {
        listeDispos = dao.findDispoByIdMedecin(id);
        return listeDispos;
    }

    public List<DispoMedecin> chercherDispoMedecinParDate(String date) {
        listeDispos = dao.findDispoByDate(date);
        return listeDispos;
    }

    public DispoMedecin verifierExistanceDispoMedecin(int idMedecin,String date) {
        uneDispo = dao.dispoExistante(idMedecin,date);
        return uneDispo;
    }

    public boolean ajouterDispoMedecin(DispoMedecin dispo) {
        retour = dao.create(dispo);
        return retour;
    }

    public boolean modifierDispoMedecin(DispoMedecin dispo) {
        retour = dao.update(dispo);
        return retour;
    }

    public boolean supprimerDispoMedecin(int idDispo) {
        retour = dao.delete(idDispo);
        return retour;
    }

    public int trouverLeIdMaxDispoMedecin() {
        int maxId = dao.findMaxIdDispo();
        return maxId;
    }
}
