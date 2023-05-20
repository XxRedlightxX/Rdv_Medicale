package com.medical.service;

import com.medical.entities.DispoMedecin;
import com.medical.repos.DispoMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DispoMedecinService {
    @Autowired
    private DispoMedecinRepository repo;

    public List<DispoMedecin> afficherLesDispoMedecin(){
        return (List<DispoMedecin>)  repo.findAll();
    }
    public DispoMedecin chercherDispoMedecinParId(int id){
        return repo.findById(id).get();
    }
    public List<DispoMedecin> chercherDispoDunMedecinParSonId(int id){
        return repo.findDispoByIdMedecin(id);
    }
    public DispoMedecin verifierExistenceDispo(Integer id_medecin, String date){
        DispoMedecin uneDispo = repo.verifierExistenceDispoMedecin(id_medecin,date);
        return uneDispo;
    }
    public DispoMedecin ajouterDispoMedecin(DispoMedecin dispoMedecin){
        return  repo.save(dispoMedecin);
    }

    public void modifierDispoMedecin(DispoMedecin dispo){
        repo.update(dispo.getId_disponibilites_medecin(),dispo.getDate_dispo(),dispo.getHeure_dispo_debut(), dispo.getHeure_dispo_fin());
    }
    public void supprimerDispoMedecin(Integer id) {
        repo.deleteById(id);
    }
}
