package com.medic.dao.patient;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */



import com.medic.entities.Patient;
import java.util.List;

/**
 *
 * @author 1482910
 */
public interface PatientDao {
    List<Patient> findAll();
    Patient findById(int id);
    Patient findByName(String nom);
    Patient findByFirstName(String prenom);
    Patient findByAssuranceMaladie(String assuranceMaladie);
    Patient findBynumeroSequentiel(String numeroSequentiel);
    Patient findBydateNaissance(String dateNaissance);
    Patient findBySexe(String sexe);
}
