package com.medical.service;

import com.medical.entities.Medecin;
import com.medical.entities.RendezVous;
import com.medical.repos.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RendezVousService {
    @Autowired
    private RendezVousRepository repo;

    public List<RendezVous> afficherLesRendezVous(){
        return (List<RendezVous>)  repo.findAll();
    }

    public RendezVous chercherRendezVousParId(int id){
        return repo.findById(id).get();
    }

    public List<RendezVous> chercherRendezVousParIdPatient(int id){
        return repo.findRendezVousByIdPatient(id);
    }

    public List<RendezVous> chercherRendezVousParIdMedecin(int id){
        return repo.findRendezVousByByIdMedecin(id);
    }

    public RendezVous ajouterRendezVous(RendezVous rendezVous){
        return  repo.save(rendezVous);
    }

    public RendezVous verifierExistenceRendezVous(Medecin medecin, String dateRv, String heureRv){
        RendezVous unRendezVous = repo.verifierExistenceRendezVous(medecin, dateRv, heureRv);
        return unRendezVous;
    }

    public void modifierRendezVous(RendezVous rendezVous){
        repo.update(rendezVous.getId_rendez_vous(), rendezVous.getDate_rv(), rendezVous.getHeure_rv(), rendezVous.getRaison_consult(), rendezVous.getDescription_consult());
    }

    public void supprimerRendezVous(Integer id) {
        repo.deleteById(id);
    }


}
