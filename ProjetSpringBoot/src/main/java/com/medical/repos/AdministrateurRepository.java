package com.medical.repos;

import com.medical.entities.Administrateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends CrudRepository<Administrateur, Integer> {
    @Query("SELECT a FROM Administrateur a WHERE a.nom_utilisateur = :username and a.password=:motPasse")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Administrateur getAdministrateurByUsernameMotPasse(@Param("username") String username, @Param("motPasse") String motPasse);

}
