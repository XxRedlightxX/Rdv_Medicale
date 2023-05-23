package com.medical.controller;

import com.medical.entities.Patient;
import com.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/medecin/rechercherPatient")
    public String rechercherPatient(@PathVariable(name = "nom") String nom,HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        if (nom != null && !nom.equals("")) {
            model.addAttribute("rechercheListePatient", patientService.chercherPatientParNom(nom));
            return "Medecin";
        } else {
            return "Medecin";
        }
    }



}
