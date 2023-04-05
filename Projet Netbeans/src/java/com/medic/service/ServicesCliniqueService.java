/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.service;

import com.medic.dao.servicesClinique.ServicesCliniqueImplDao;
import com.medic.entities.ServicesClinique;
import java.util.List;

/**
 *
 * @author hundl
 */
public class ServicesCliniqueService {

    ServicesCliniqueImplDao dao = new ServicesCliniqueImplDao();
    private List<ServicesClinique> listeServicesClinique = null;
    private ServicesClinique unServiceClinique = null;
    private Boolean retour = false;

    public List<ServicesClinique> afficherServicesClinique() {
        listeServicesClinique = dao.findAll();
        return listeServicesClinique;
    }

    public ServicesClinique chercherServiceCliniqueParId(int id) {
        unServiceClinique = dao.findById(id);
        return unServiceClinique;
    }

    public ServicesClinique chercherServiceCliniqueParNom(String nom) {
        unServiceClinique = dao.findByName(nom);
        return unServiceClinique;
    }

    public ServicesClinique chercherServiceCliniqueParDescription(String description) {
        unServiceClinique = dao.findByDescription(description);
        return unServiceClinique;
    }
    
    public boolean ajouterServicesClinique(ServicesClinique service){
        retour = dao.ajouterService(service);
        return retour;
    }
    
    public boolean modifierServicesClinique(ServicesClinique service,int idFindServiceClinique){
        retour = dao.update(service, idFindServiceClinique);
        return retour;
    }
    
    public boolean supprimerServicesClinique(int idServicesClinique){
        retour = dao.delete(idServicesClinique);
        return retour;
    }
    
    public List<ServicesClinique> afficherLesServicesDuneClinique(int idClinique){
        listeServicesClinique  = dao.findAllSeviceUneClinique(idClinique);
        return listeServicesClinique;
    }
    
    public boolean ajouterUnServiceAClinique(int idClinique,int idService){
        retour  = dao.ajouterSeviceUneClinique(idClinique, idService);
        return retour;
    }
    
    public boolean supprimerUnServiceAClinique(int idClinique,int idService){
        retour  = dao.supprimerSeviceUneClinique(idClinique, idService);
        return retour;
    }



}
