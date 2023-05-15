/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;

import com.medic.dao.rendezVous.RendezVousImplDao;
import com.medic.entities.RendezVous;
import java.util.List;

/**
 *
 * @author hundl
 */
public class RendezVousService {
    RendezVousImplDao dao = new RendezVousImplDao();
    private List<RendezVous> listeRendezVous = null;
    private RendezVous unRendezVous = null;
    private Boolean retour = false;

    public List<RendezVous> afficherTousLesRendezVous() {
        listeRendezVous = dao.findAll();
        return listeRendezVous;
    }

    public RendezVous chercherRendezVousParId(int id) {
        unRendezVous = dao.findByIdRv(id);
        return unRendezVous;
    }

    public List<RendezVous> chercherToutLesRendezVousIdPatient(int id) {
        listeRendezVous = dao.findByIdPatient(id);
        return listeRendezVous;
    }

    public List<RendezVous> chercherToutLesRendezVousIdMedecin(int id) {
        listeRendezVous = dao.findByIdMedecin(id);
        return listeRendezVous;
    }
    
    // Boot
    public int trouverLeIdMaxRendezVous() {
        int maxId = dao.findMaxIdRv();
        return maxId;
    }



    public boolean ajouterRendezVous(RendezVous rendezVous) {
        retour = dao.create(rendezVous);
        return retour;
    }

    public boolean modifierRendezVous(RendezVous rendezVous) {
        retour = dao.update(rendezVous);
        return retour;
    }

    public boolean supprimerRendezVous(int idRendezVous) {
        retour = dao.delete(idRendezVous);
        return retour;
    }
    
    // Boot
     public RendezVous verifierRendezVousPris(int idMedecin, String date, String heure) {
        unRendezVous = dao.verifierRendezVousPris(idMedecin,date,heure);
        return unRendezVous;
    }

    
    
}
