package com.medical.repos;

import com.medical.entities.Clinique;
import com.medical.entities.DispoMedecin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispoMedecinRepository extends CrudRepository<DispoMedecin, Integer> {
    @Query("SELECT d FROM DispoMedecin d JOIN d.medecin_dispo m WHERE m.id_medecin = ?1")
    public List<DispoMedecin> findDispoByIdMedecin(Integer id_medecin);

    @Query("SELECT d FROM DispoMedecin d JOIN d.medecin_dispo m WHERE m.id_medecin = ?1 and d.date_dispo = ?2")
    public DispoMedecin verifierExistenceDispoMedecin(Integer id_medecin, String date_dispo);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE DispoMedecin d SET d.heure_dispo_debut = ?3,d.heure_dispo_fin = ?4 WHERE d.id_disponibilites_medecin = ?1 and d.date_dispo =?2")
    public void update(Integer id, String date_dispo,String heure_dispo_debut,String heure_dispo_fin);

}
