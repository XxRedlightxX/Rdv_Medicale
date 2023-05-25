package com.medical.service;

import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.repos.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MedecinService {
    @Autowired
    private MedecinRepository repo;

    public List<Medecin> afficherLesMedecins(){
        return (List<Medecin>)  repo.findAll();
    }

    public Medecin chercherMedecinParId(int id){
        return repo.findById(id).get();
    }

    public List<Medecin> chercherMedecinParNom(String nom) {
        return repo.findByName(nom);
    }

    public List<Medecin> chercherParSpecialite(String specialite) {
        return repo.findBySpecialite(specialite);
    }

    public List<Medecin> chercherParPrix(Float prix) {
        return repo.findByPrix(prix);
    }

    public List<Medecin> chercherParCoordonnees(String specialite) {
        return repo.findByCoordonnees(specialite);
    }

    public List<Medecin> chercherNomClinique(String nomClinique) {
        return repo.findByClinique(nomClinique);
    }

    public Medecin verifierExistenceMedecin2(String username, String password){
        try {
            Medecin unMedecin = repo.verifierExistenceMedecin2(Integer.parseInt(username),password);
            return unMedecin;
        } catch (Exception ex){
            return null;
        }

    }

    public Medecin ajouterMedecin(Medecin medecin){
        return  repo.save(medecin);
    }

    public void modifierMedecin(Medecin medecin){
        repo.update(medecin.getId_medecin(), medecin.getNom(), medecin.getPrenom(), medecin.getspecialite(), medecin.getFacturation(), medecin.getCoordonnees_medecin(),medecin.getPassword(),medecin.getClinique());
    }

    public void supprimerMedecin(Integer id) {
        repo.deleteById(id);
    }

    public boolean Num_Assurance_password_Medecin_Unique(String email, String password, Integer id) {
        //On cherche un utilisateur à partir de son email
        Medecin userByEmail = repo.verifierExistenceMedecin(email, password);


        if (userByEmail == null) return true;


        boolean isCreatingNewUser = false;
        if (id == null) {
            isCreatingNewUser = true;
        }
        //Si l' id utilisateur n'existe pas mais l' email existe,
        //on retourne false car pas email unique, on ne peut pas creer un nouveau utilisateur
        //dans le mode de création utilisateur
        if (isCreatingNewUser) {
            //mais l'email existe, on retourne false car pas unique email
            if (userByEmail != null) return false;
        } else {
            //dans le mode d'edition utilisateur
            //Si l'id existe mais l'id qu'on edite  est différent de celui
            //de l'utilisateur possedant l'email,
            //on retourne false, car on ne peut pas creer un nouveau , puisqu email existe
            if (userByEmail.getId_medecin() != id) {
                return false;
            }
        }
        return true;
    }

}
