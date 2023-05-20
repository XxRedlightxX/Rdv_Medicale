package com.medical.repos;

import com.medical.entities.Clinique;
import com.medical.entities.DispoMedecin;
import com.medical.entities.Medecin;
import com.medical.entities.ServicesClinique;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Integer> {
    @Query("SELECT m FROM Medecin m WHERE m.nom LIKE %?1% OR m.prenom LIKE %?1%")
    public List<Medecin> findByName(String keyword);

    @Query("SELECT m FROM Medecin m JOIN m.specialite s WHERE s.nom = ?1")
    public List<Medecin> findBySpecialite(String keyword);

    @Query("SELECT m FROM Medecin m WHERE m.facturation = ?1")
    public List<Medecin> findByPrix(Float prix);

    @Query("SELECT m FROM Medecin m WHERE m.coordonnees_medecin LIKE %?1%")
    public List<Medecin> findByCoordonnees(String keyword);

    @Query("SELECT m FROM Medecin m JOIN m.clinique s WHERE s.nom LIKE %?1%")
    public List<Medecin> findByClinique(String nomClinique);

    @Query("SELECT m FROM Medecin m WHERE m.id_medecin = ?1 and m.password = ?2")
    public Medecin verifierExistenceMedecin(String id_medecin, String password);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Medecin m  SET m.nom = ?2,m.prenom = ?3, m.specialite = ?4,m.id_medecin = ?1,m.facturation= ?5, m.coordonnees_medecin = ?6,m.password = ?7 ,m.clinique = ?8 WHERE m.id_medecin = ?1 ")
    public void update(Integer id, String nom, String prenom,ServicesClinique specialite,float facturation,String coordonnees,String password,Clinique clinique);


}