package com.medical.repos;

import com.medical.entities.Clinique;
import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.entities.ServicesClinique;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.nom  LIKE %?1% or p.prenom LIKE %?1%")
    public List<Patient> findByName(String keyword);

    @Query("SELECT p FROM Patient p WHERE p.numero_assurance_maladie = ?1")
    public Patient findByNumero_assurance_maladie(String assurance);

    @Query("SELECT p FROM Patient p WHERE p.date_naissance = ?1")
    public List<Patient> findByDateNaissance(String dateNaissance);

    @Query("SELECT p FROM Patient p WHERE p.sexe = ?1")
    public List<Patient> findBySexe(String sexe);

    @Query("SELECT p FROM Patient p WHERE p.numero_assurance_maladie = ?1 and p.password = ?2")
    public Patient verifierExistencePatient(String username, String password);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Patient p  SET p.nom = ?2,p.prenom = ?3, p.numero_assurance_maladie = ?4,p.num_seq_numero_assurance_maladie = ?5,p.date_naissance= ?6, p.sexe = ?7,p.password = ?8 ,p.medecin = ?9 WHERE p.id_patient = ?1")
    public void update(Integer id,String nom,String prenom,String numeroAssurance, Integer numeroSequentiel, String dateNaissance,String sexe,String password,Medecin medecin);


}
