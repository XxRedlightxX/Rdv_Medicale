/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.medecin;

import com.medic.entities.Medecin;
import java.util.List;

/**
 *
 * @author 1482910
 */
public interface MedecinDao {
    List<Medecin> findAll();
    Medecin findById(int id);
    Medecin findByName(String nom);
    Medecin findByFirstName(String prenom);
    Medecin findBySpecialite(String specialite);
    Medecin findByPrix(float prix);
    Medecin findByCoordonnees(String coordonnees);
    Medecin findByClinique(String clinique);  
}
