package com.medical.controller;

import com.medical.entities.DispoMedecin;
import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.service.MedecinService;
import com.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class InscriptionController {
    @Autowired
    PatientService patientService;

    @Autowired
    MedecinService medecinService;

    @GetMapping("/inscription/patient")
    public String InscriptionPatient(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, Patient patient){
        patientService.ajouterPatient(patient);
        return "connexionController?typeCompte=" + "patient" + "&username=" + patient.getNumero_assurance_maladie() + "&password=" + patient.getPassword();
    }

    @GetMapping("/inscription/medecin")
    public String InscriptionMedecin(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, Medecin medecin){
        medecinService.ajouterMedecin(medecin);
        return "connexionController?typeCompte=" + "medecin" + "&username=" + medecin.getId_medecin() + "&password=" + medecin.getPassword();
    }
}
