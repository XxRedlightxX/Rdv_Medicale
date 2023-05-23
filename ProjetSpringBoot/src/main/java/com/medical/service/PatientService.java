package com.medical.service;

import com.medical.entities.Medecin;
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


    public boolean Num_Assurance_passwordUnique(String email, String password, Integer id) {
        //On cherche un utilisateur à partir de son email
        Patient userByEmail = repo.verifierExistencePatient(email, password);

        if (userByEmail == null) return true;


        boolean isCreatingNewUser = false;
        if (id == null) {
            isCreatingNewUser = true;
        }
        //Si l' id utilisateur n'existe pas mais l' email existe,
        //on retourne false car pas email unique, on ne peut pas creer un nouveau utilisateur
        //dans le mode de création utilisateur
        if (isCreatingNewUser) {
            //mais l'email existe, on retourne false car pas unique email
            if (userByEmail != null) return false;
        } else {
            //dans le mode d'edition utilisateur
            //Si l'id existe mais l'id qu'on edite  est différent de celui
            //de l'utilisateur possedant l'email,
            //on retourne false, car on ne peut pas creer un nouveau , puisqu email existe
            if (userByEmail.getId_patient() != id) {
                return false;
            }
        }
        return true;
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
