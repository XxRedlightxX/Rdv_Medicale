package com.medical.repos;

import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.entities.ServicesClinique;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesCliniqueRepository extends CrudRepository<ServicesClinique, Integer> {
    @Query("SELECT s FROM ServicesClinique s WHERE s.nom LIKE %?1%")
    public List<ServicesClinique> findByNom(String keyword);

    @Query("SELECT s FROM ServicesClinique s WHERE s.description LIKE %?1%")
    public List<ServicesClinique> findByDescription(String description);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ServicesClinique s SET s.nom = ?2, s.description = ?3 WHERE s.id_service = ?1")
    public void update(Integer id, String nom, String description);

}
