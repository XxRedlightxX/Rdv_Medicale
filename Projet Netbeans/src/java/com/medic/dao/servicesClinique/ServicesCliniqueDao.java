/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.servicesClinique;

import com.medic.entities.ServicesClinique;
import java.util.List;

/**
 *
 * @author hundl
 */
public interface ServicesCliniqueDao {
    List<ServicesClinique> findAll();
    ServicesClinique findById(int id);
    ServicesClinique findByName(String nom);
    ServicesClinique findByDescription(String description);
    List<ServicesClinique> findAllSeviceUneClinique();
    ServicesClinique ajouterSeviceUneClinique(ServicesClinique service);
    ServicesClinique supprimerSeviceUneClinique(int id);
    List<ServicesClinique> findAll();
    boolean ajouterService(ServicesClinique service);
    boolean update(ServicesClinique service,int idFindServiceClinique);
    boolean delete(int id);
    
}
