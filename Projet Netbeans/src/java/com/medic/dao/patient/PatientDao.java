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
    Patient findByIdPatient(int id);
    List<Patient> findByName(String nom);
    List<Patient> findByFirstName(String prenom);
    Patient findByAssuranceMaladie(String assuranceMaladie);
    List<Patient> findBydateNaissance(String dateNaissance);
    List<Patient> findBySexe(String sexe);
    Patient existByNumeroMotPasse(String numero,String motPasse);
    boolean create(Patient patient,int idMedecin);
    boolean update(Patient patient,int idMedecin);
    boolean delete(int id);
}
