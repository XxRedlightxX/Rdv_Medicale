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
    public String verifierDoublonIdPatient(@Param("numero_assurance_maladie") String Num_assur, @Param("password") String password, @Param("idpatient") Integer id ) {
        return patientService.Num_Assurance_passwordUnique(Num_assur,password,id)? "Ok": "Doublon";

    }

    @PostMapping("/medecin/check_id")
    public String verifierDoublonIdMedecin(@Param("id_medecin") String medecin, @Param("password") String password, @Param("idmedcin") Integer id ) {
        return medecinService.Num_Assurance_password_Medecin_Unique(medecin,password,id)? "Ok": "Doublon";

    }





}
