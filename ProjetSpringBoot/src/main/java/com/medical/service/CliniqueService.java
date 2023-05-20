package com.medical.service;

import com.medical.entities.Clinique;
import com.medical.entities.ServicesClinique;
import com.medical.repos.CliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CliniqueService {
    @Autowired
    private CliniqueRepository repo;

    public List<Clinique> afficherLesCliniques(){
        return (List<Clinique>)  repo.findAll();
    }

    public Clinique chercherCliniqueParId(int id){
        return repo.findById(id).get();
    }

    public List<Clinique> chercherCliniqueParNom(String nom) {
        return repo.findByName(nom);
    }
    public List<Clinique> chercherParCoordonnees(String coordonnees) {
        return repo.findByCoordonnees(coordonnees);
    }
    public List<Clinique> chercherParService(String service) {
        return repo.findByService(service);
    }

    public List<ServicesClinique> afficherLesServicesDuneClinique(Integer id) {
        return repo.findAllServicesDuneClinique(id);
    }


    public Clinique ajouterClinique(Clinique clinique){
        return  repo.save(clinique);
    }

    public void modifierClinique(Clinique clinique){
        repo.update(clinique.getId_clinique(), clinique.getNom(), clinique.getCoordonnees());
    }

    public void supprimerClinique(Integer id) {
        repo.deleteById(id);
    }

}
