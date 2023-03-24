/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.administrateur;

import com.medic.entities.Administrateur;

/**
 *
 * @author hundl
 */
public interface AdministrateurDao {
    Administrateur existByNumeroMotPasse(String username,String motPasse);
}
