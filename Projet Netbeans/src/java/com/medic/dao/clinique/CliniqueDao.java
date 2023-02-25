/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.clinique;

import com.medic.entities.Clinique;
import java.util.List;

/**
 *
 * @author 1482910
 */
public interface CliniqueDao {
    List<Clinique> findAll();
    Clinique findById(int id);
    Clinique findByName(String nom);
    Clinique findByCoordonnes(String coordonnees);
    Clinique findByService(String service);
    List<String> findAllServices();
    Clinique findByService(String service);
    //
    List<Medecin> findAllMedecin();
    List<Patient> findAllPatients();
}
