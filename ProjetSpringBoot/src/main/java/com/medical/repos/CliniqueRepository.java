package com.medical.repos;

import com.medical.entities.Clinique;
import com.medical.entities.ServicesClinique;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CliniqueRepository extends CrudRepository<Clinique, Integer> {
    @Query("SELECT c FROM Clinique c WHERE c.nom  LIKE %?1%")
    public List<Clinique> findByName(String keyword);

    @Query("SELECT c FROM Clinique c WHERE c.coordonnees  LIKE %?1%")
    public List<Clinique> findByCoordonnees(String keyword);

    @Query("SELECT c FROM Clinique c JOIN c.services s WHERE s.nom LIKE %?1%")
    public List<Clinique> findByService(String keyword);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Clinique c SET c.nom = ?2,c.coordonnees = ?3 WHERE c.id_clinique = ?1")
    public void update(Integer id, String nom,String coordonnees);

    @Query("SELECT s FROM Clinique c  JOIN c.services s WHERE c.id_clinique = ?1")
    public List<ServicesClinique> findAllServicesDuneClinique(Integer id);

}
