package com.medical.service;

import com.medical.entities.ServicesClinique;
import com.medical.repos.ServicesCliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicesCliniqueService {
    @Autowired
    private ServicesCliniqueRepository repo;

    public List<ServicesClinique> afficherServicesCliniques(){
        return (List<ServicesClinique>)  repo.findAll();
    }

    public ServicesClinique chercherServicesCliniqueParId(int id){
        return repo.findById(id).get();
    }

    public List<ServicesClinique> chercherServiceCliniqueParNom(String nom) {
        return repo.findByNom(nom);
    }

    public List<ServicesClinique> chercherServiceCliniqueParDescription(String description) {
        return repo.findByDescription(description);
    }

    public ServicesClinique ajouterServicesClinique(ServicesClinique servicesClinique){
        return  repo.save(servicesClinique);
    }

    public void modifierServiceClinique(ServicesClinique servicesClinique){
        repo.update(servicesClinique.getId_service(), servicesClinique.getNom(), servicesClinique.getDescription());
    }

    public void supprimerServiceClinique(Integer id) {
        repo.deleteById(id);
    }

}
