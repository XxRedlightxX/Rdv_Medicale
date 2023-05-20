package com.medical.service;

import com.medical.entities.Patient;
import com.medical.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> afficherLesPatients(){
        return (List<Patient>)  repo.findAll();
    }

    public Patient chercherPatientParId(int id){
        return repo.findById(id).get();
    }

    public List<Patient> chercherPatientParNom(String nom) {
        return repo.findByName(nom);
    }

    public Patient chercherPatientParAssuranceMaladie(String assurance){
        return repo.findByNumero_assurance_maladie(assurance);
    }

    public List<Patient> chercherPatientParDateNaissance(String dateNaissance){
        return repo.findByDateNaissance(dateNaissance);
    }

    public List<Patient> chercherPatientParSexe(String sexe){
        return repo.findBySexe(sexe);
    }

    public Patient verifierExistencePatient(String username, String password){
        Patient unPatient = repo.verifierExistencePatient(username,password);
        return unPatient;
    }

    public Patient ajouterPatient(Patient patient){
        return  repo.save(patient);
    }

    public void modifierPatient(Patient patient){
        repo.update(patient.getId_patient(),patient.getNom(),patient.getPrenom(),patient.getNumero_assurance_maladie(),patient.getnum_seq_numero_assurance_maladie(),patient.getDate_naissance(),patient.getSexe(), patient.getPassword(), patient.getMedecin());
    }

    public void supprimerPatient(Integer id) {
        repo.deleteById(id);
    }

}
