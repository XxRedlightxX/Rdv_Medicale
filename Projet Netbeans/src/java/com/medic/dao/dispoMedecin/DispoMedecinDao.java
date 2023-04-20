/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.dispoMedecin;

import com.medic.entities.DispoMedecin;
import java.util.List;

/**
 *
 * @author hundl
 */
public interface DispoMedecinDao {
    List<DispoMedecin> findAll();
    DispoMedecin findByIdDispo(int id);
    List<DispoMedecin> findDispoByIdMedecin(int idMedecin);
    List<DispoMedecin> findDispoByDate(String date);
    int findMaxIdDispo();
    DispoMedecin dispoExistante(int idMedecin,String date);
    boolean create(DispoMedecin dispo);
    boolean update(DispoMedecin dispo);
    boolean delete(int idDispo);
}
