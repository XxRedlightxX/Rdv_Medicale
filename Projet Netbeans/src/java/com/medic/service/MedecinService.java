/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;


import com.medic.dao.medecin.MedecinImplDao;
import com.medic.entities.Medecin;
import java.util.List;

/**
 *
 * @author hundl
 */
public class MedecinService {
    MedecinImplDao dao = new MedecinImplDao();
    private List<Medecin> listeMedecin = null;
    private Medecin unMedecin = null;
    private Boolean retour = false;
    
    public List<Medecin> afficherLesMedecin(){
        listeMedecin = dao.findAll();
        return listeMedecin;     
    }
    
    public Medecin chercherMedecinParId(int id){
        unMedecin = dao.findByIdMedecin(id);
        return unMedecin;
    }
    
    public List<Medecin> chercherMedecinParNom(String nom){
        listeMedecin = dao.findByName(nom);
        return listeMedecin;
    }
    
    public List<Medecin> chercherMedecinParPrenom(String prenom){
        listeMedecin = dao.findByFirstName(prenom);
        return listeMedecin;
    }
    
    public List<Medecin> chercherParSpecialite(String specialite){
        listeMedecin = dao.findBySpecialite(specialite);
        return listeMedecin;
    }
    
    public List<Medecin> chercherParPrix(float prix){
        listeMedecin = dao.findByPrix(prix);
        return listeMedecin;
    }
    
    public List<Medecin> chercherParCoordonnees(String coordonnee){
        listeMedecin = dao.findByCoordonnees(coordonnee);
        return listeMedecin;
    }
    
    public List<Medecin> chercherParClinique(int idClinique){
        listeMedecin = dao.findByClinique(idClinique);
        return listeMedecin;
    }
    
    public Medecin verifierExistenceMedecin(String numeroAssurance,String motPasse){
        unMedecin = dao.existByNumeroMotPasse(numeroAssurance,motPasse);
        return unMedecin;
    }
    
    public boolean ajouterMedecin(Medecin medecin,int idClinique){
        retour = dao.create(medecin,idClinique);
        return retour;
    }
    
    public boolean modifierMedecin(Medecin medecin,int idClinique,int idFindClinique){
        retour = dao.update(medecin,idClinique,idFindClinique);
        return retour;
    }
    
    public boolean supprimerMedecin(int idMedecin){
        retour = dao.delete(idMedecin);
        return retour;
    }
    
}
