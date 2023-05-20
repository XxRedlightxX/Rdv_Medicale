package com.medical.repos;

import com.medical.entities.DispoMedecin;
import com.medical.entities.Medecin;
import com.medical.entities.RendezVous;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends CrudRepository<RendezVous, Integer> {
    @Query("SELECT r FROM RendezVous r JOIN r.patient_rv p WHERE p.id_patient = ?1")
    public List<RendezVous> findRendezVousByIdPatient(Integer id_patient);

    @Query("SELECT r FROM RendezVous r JOIN r.medecin_rv m WHERE m.id_medecin = ?1")
    public List<RendezVous> findRendezVousByByIdMedecin(Integer id_patient);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE RendezVous r  SET r.date_rv = ?2,r.heure_rv = ?3,r.raison_consult = ?4,r.description_consult=?5 WHERE r.id_rendez_vous = ?1")
    public void update(Integer id,String date_rv,String heure_rv,String raison_consult, String description_consult);

    @Query("SELECT r FROM RendezVous r JOIN r.medecin_rv m WHERE r.medecin_rv = ?1 and r.date_rv = ?2 and r.heure_rv = ?3")
    public RendezVous verifierExistenceRendezVous(Medecin medecin,String date,String heure);



}
