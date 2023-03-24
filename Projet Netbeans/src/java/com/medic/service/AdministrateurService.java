/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;

import com.medic.dao.administrateur.AdministrateurImplDao;
import com.medic.entities.Administrateur;

/**
 *
 * @author hundl
 */
public class AdministrateurService {
    AdministrateurImplDao dao = new AdministrateurImplDao();
    private Administrateur unAdmin = null;
    
    public Administrateur verifierExistenceAdmin(String username,String motPasse){
        unAdmin = dao.existByNumeroMotPasse(username,motPasse);
        return unAdmin;
    }
}
