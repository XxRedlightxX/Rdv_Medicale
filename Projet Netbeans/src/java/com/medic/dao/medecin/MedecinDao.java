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
    Medecin findByIdMedecin(int id);
    List<Medecin> findByName(String nom);
    List<Medecin> findByFirstName(String prenom);
    List<Medecin> findBySpecialite(String specialite);
    List<Medecin> findByPrix(float prix);
    List<Medecin> findByCoordonnees(String coordonnees);
    List<Medecin> findByClinique(int idClinique);
    Medecin existByNumeroMotPasse(String numero,String motPasse);
    boolean create(Medecin medecin,int idClinique);
    boolean update(Medecin medecin,int idClinique,int idFindMedecin);
    boolean delete(int id);
    int findMaxIdMedecin();
}
