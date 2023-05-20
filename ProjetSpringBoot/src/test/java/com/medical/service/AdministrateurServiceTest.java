package com.medical.service;

import com.medical.entities.Administrateur;
import com.medical.repos.AdministrateurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AdministrateurServiceTest {
    @Mock
    AdministrateurRepository repo;


    @Autowired
    AdministrateurService service;


    @Test
    public void test(){
        Administrateur ss = service.verifierExistenceAdmin("Admin","root");
        Administrateur sa = repo.getAdministrateurByUsernameMotPasse("Admin","root");

        System.out.println("Service : "+ss);
        System.out.println("Repo    : "+sa);

    }


}
