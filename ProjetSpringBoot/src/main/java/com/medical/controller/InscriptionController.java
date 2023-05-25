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
        System.out.println(patient);
        patientService.ajouterPatient(patient);
        redirectAttributes.addAttribute("username",patient.getNumero_assurance_maladie());
        redirectAttributes.addAttribute("password",patient.getPassword());
        return "redirect:/connexion/patient";
    }

    @PostMapping("/inscription/medecin")
    public String InscriptionMedecin(@ModelAttribute("medecin") Medecin medecin,HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        System.out.println(medecin);
        medecinService.ajouterMedecin(medecin);
        redirectAttributes.addAttribute("username",medecin.getId_medecin());
        redirectAttributes.addAttribute("password",medecin.getPassword());
        return "redirect:/connexion/medecin";
    }
}
