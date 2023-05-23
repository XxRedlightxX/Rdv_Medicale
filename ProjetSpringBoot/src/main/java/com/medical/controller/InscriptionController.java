package com.medical.controller;

import com.medical.entities.DispoMedecin;
import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.entities.RendezVous;
import com.medical.service.MedecinService;
import com.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class InscriptionController {
    @Autowired
    PatientService patientService;

    @Autowired
    MedecinService medecinService;

    @PostMapping("/inscription/patient")
    public String InscriptionPatient(@ModelAttribute("patient") Patient patient,HttpServletRequest request, RedirectAttributes redirectAttributes, Model model){
        patientService.ajouterPatient(patient);
        return "connexionController?typeCompte=" + "patient" + "&username=" + patient.getNumero_assurance_maladie() + "&password=" + patient.getPassword();
    }

    @PostMapping("/inscription/medecin")
    public String InscriptionMedecin(@ModelAttribute("medecin") Medecin medecin,HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        medecinService.ajouterMedecin(medecin);
        return "connexionController?typeCompte=" + "medecin" + "&username=" + medecin.getId_medecin() + "&password=" + medecin.getPassword();
    }
}
