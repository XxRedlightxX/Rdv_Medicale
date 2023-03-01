/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.services;

import com.medic.entities.Medecin;
import com.medic.entities.Services;
import java.util.List;

/**
 *
 * @author hundl
 */
public interface ServicesDao {
    List<Services> findAll();
    Services findById(int id);
    Services findByName(String nom);
    Services findByDescription(String description); 
    boolean ajouterService(Services service);
    boolean update(Services service);
    boolean delete(int id);
}
