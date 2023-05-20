package com.medical.service;

import com.medical.entities.Administrateur;
import com.medical.repos.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdministrateurService {
    @Autowired
    private AdministrateurRepository repo;

    public Administrateur verifierExistenceAdmin(String username, String motPasse){
        Administrateur unAdmin = repo.getAdministrateurByUsernameMotPasse(username,motPasse);
        return unAdmin;
    }
}
