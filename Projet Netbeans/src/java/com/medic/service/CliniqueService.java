/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;

import com.medic.dao.clinique.CliniqueImplDao;
import com.medic.entities.Clinique;
import com.medic.entities.Medecin;
import com.medic.entities.Patient;
import com.medic.entities.ServicesClinique;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hundl
 */
public class CliniqueService {
  CliniqueImplDao dao = new CliniqueImplDao();
    private List<Clinique> listeClinique = null;
    private Clinique uneClinique = null;
    private Boolean retour = false;  
    
    public List<Clinique> afficherLesCliniques(){
        listeClinique = dao.findAll();
        return listeClinique;     
    }
    
    public Clinique chercherCliniqueParId(int id){
        uneClinique = dao.findById(id);
        return uneClinique;     
    }
    
    public Clinique chercherCliniqueParNom(String nom){
        uneClinique = dao.findByName(nom);
        return uneClinique;     
    }
    
    public List<Clinique> chercherParCoordonnees(String coordonnees){
        listeClinique = dao.findByCoordonnes(coordonnees);
        return listeClinique;     
    }
    
    public List<Clinique> chercherParService(String service){
        listeClinique = dao.findByCoordonnes(service);
        return listeClinique;   
    }
    
    public List<ServicesClinique> afficherTousServicesDuneClinique(String nomService){
        List<ServicesClinique> listeServices = dao.findAllServicesClinique(nomService);
        return listeServices;   
    }
    
    public List<Medecin> afficherTousMedecinsDuneClinique(String nomMedecin){
        List<Medecin> listeMedecins = dao.findAllMedecinsClinique(nomMedecin);
        return listeMedecins;   
    }
    
    public List<Patient> afficherTousPatientsDuneClinique(String nomPatient){
        List<Patient> listePatients = dao.findAllPatientsClinique(nomPatient);
        return listePatients;   
    }
    
    public boolean ajouterClinique(Clinique clinique){
        retour = dao.create(clinique);
        return retour;
    }
    
    public boolean modifierClinique(Clinique clinique,int idFindClinique){
        retour = dao.update(clinique,idFindClinique);
        return retour;
    }
    
    public boolean supprimerClinique(int idClinique){
        retour = dao.delete(idClinique);
        return retour;
    }
    
}
