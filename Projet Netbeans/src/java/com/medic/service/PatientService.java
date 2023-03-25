/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;

import com.medic.dao.patient.PatientImplDao;
import com.medic.entities.Patient;
import java.util.List;

/**
 *
 * @author hundl
 */
public class PatientService {
    PatientImplDao dao = new PatientImplDao();
    private List<Patient> listePatients = null;
    private Patient unPatient = null;
    private Boolean retour = false;
    
    public List<Patient> afficherLesPatients(){
        listePatients = dao.findAll();
        return listePatients;     
    }
    
    public Patient chercherPatientParId(int id){
        unPatient = dao.findByIdPatient(id);
        return unPatient;
    }
    
    public List<Patient> chercherPatientParNom(String nom){
        listePatients = dao.findByName(nom);
        return listePatients;
    }
    
    public List<Patient> chercherPatientParPrenom(String prenom){
        listePatients = dao.findByFirstName(prenom);
        return listePatients;
    }
    
    public Patient chercherParAssuranceMaladie(String numeroAssurance){
        unPatient = dao.findByAssuranceMaladie(numeroAssurance);
        return unPatient;
    }
        
    public List<Patient> chercherParDateNaissance(String dateNaissance){
        listePatients = dao.findBydateNaissance(dateNaissance);
        return listePatients;
    }
    
    public List<Patient> chercherParSexe(String sexe){
        listePatients = dao.findBySexe(sexe);
        return listePatients;
    }
    
    public Patient verifierExistencePatient(String numeroAssurance,String motPasse){
        unPatient = dao.existByNumeroMotPasse(numeroAssurance,motPasse);
        return unPatient;
    }
    
    public boolean ajouterPatient(Patient unPatient,int idMedecin){
        retour = dao.create(unPatient,idMedecin);
        return retour;
    }
    
    public boolean modifierPatient(Patient unPatient,int idMedecin,int idFindPatient){
        retour = dao.update(unPatient, idMedecin,idFindPatient);
        return retour;
    }
    
    public boolean supprimerPatient(int idPatient){
        retour = dao.delete(idPatient);
        return retour;
    }
    
    public int trouverLeIdMaxPatient(){
     int maxId = dao.findMaxIdPatient();
     return maxId;
    }
    
}
