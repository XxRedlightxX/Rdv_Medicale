package com.medical.rest;

import com.medical.entities.Patient;
import com.medical.service.MedecinService;
import com.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRestControlleur {
    @Autowired
    PatientService patientService;

    @Autowired
    MedecinService medecinService;


    @PostMapping("/patient/check_id")
    public String verifierDoublonIdPatient(@Param("numassurance") String numassurance) {
        return patientService.Num_Assurance_passwordUnique(numassurance)? "OK": "Doublon";

    }

    @PostMapping("/medecin/check_id")
    public String verifierDoublonIdMedecin(@Param("numeroProfessionel") String numeroProfessionel) {

        return medecinService.Num_Assurance_password_Medecin_Unique(numeroProfessionel)? "OK": "Doublon";

    }





}
