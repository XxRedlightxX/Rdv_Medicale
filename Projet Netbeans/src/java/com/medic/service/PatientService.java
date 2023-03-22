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
    
    public Patient chercherPatientParNom(String nom){
        unPatient = dao.findByName(nom);
        return unPatient;
    }
    
    public Patient chercherPatientParPrenom(String prenom){
        unPatient = dao.findByFirstName(prenom);
        return unPatient;
    }
    
    public Patient chercherParAssuranceMaladie(String numeroAssurance){
        unPatient = dao.findByAssuranceMaladie(numeroAssurance);
        return unPatient;
    }
    
    public Patient chercherParNumeroSequentiel(String numeroSequentiel){
        unPatient = dao.findBynumeroSequentiel(numeroSequentiel);
        return unPatient;
    }
    
    public Patient chercherParDateNaissance(String dateNaissance){
        unPatient = dao.findBydateNaissance(dateNaissance);
        return unPatient;
    }
    
    public Patient chercherParSexe(String sexe){
        unPatient = dao.findBySexe(sexe);
        return unPatient;
    }
    
    public Patient verifierExistencePatient(String numeroAssurance,String motPasse){
        unPatient = dao.existByNumeroMotPasse(numeroAssurance,motPasse);
        return unPatient;
    }
    
    public boolean ajouterPatient(Patient unPatient){
        retour = dao.create(unPatient);
        return retour;
    }
    
    public boolean modifierPatient(Patient unPatient){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean supprimerPatient(Patient unPatient){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
