package com.medical.controller;

import com.medical.entities.Medecin;
import com.medical.entities.RendezVous;
import com.medical.service.DispoMedecinService;
import com.medical.service.MedecinService;
import com.medical.service.PatientService;
import com.medical.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Controller
public class ChoixMedecinRendezVousController {
    @Autowired
    MedecinService medecinService;

    @Autowired
    PatientService patientService;

    @Autowired
    RendezVousService rendezVousService;

    @Autowired
    DispoMedecinService dispoMedecinService;

    @GetMapping("/rendezVous/choixMedecin/filtrerSpecialite/{nomSpecialite}")
    public String filtrerParSpecialite(@PathVariable(name = "nomSpecialite") String nomSpecialite, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        byte[] bytes = nomSpecialite.getBytes(StandardCharsets.ISO_8859_1);
        nomSpecialite = new String(bytes, StandardCharsets.UTF_8);
        model.addAttribute("listeMedecinRecherche", medecinService.chercherParSpecialite(nomSpecialite));
        return "RechercherMedecinRv";
    }

    @GetMapping("/rendezVous/choixMedecin/filterGMF/{medecinGMF}")
    public String filtrerParGMF(@PathVariable(name = "medecinGMF") String medecinGMF, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.chercherNomClinique(medecinGMF));
        return "RechercherMedecinRv";
    }

    @GetMapping("/rendezVous/choixMedecin/afficherTousLesMedecins")
    public String afficherTousLesMedecins(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.afficherLesMedecins());
        return "RechercherMedecinRv";
    }


    @GetMapping("/rendezVous/choixMedecin/prendeRendezVous/{medecinChoisi}")
    public String prendreRendezVousAvecMedecinChoisi(@PathVariable(name = "medecinChoisi") Medecin medecinChoisi, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        HttpSession session = request.getSession(true);
        String unNom = (String) session.getAttribute("nom");
        RendezVous rendezVous = new RendezVous();
        Medecin medecinRv = new Medecin();
        model.addAttribute("medecinChoisi", medecinChoisi);
        model.addAttribute("typeRecherche", "prendreRendezVous");
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        LocalDate date = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        model.addAttribute("jourSemaine", date);
        model.addAttribute("rendezVous",rendezVous);
        model.addAttribute("dispomedecinService",dispoMedecinService);
        model.addAttribute("rendezVousService",rendezVousService);
        if (medecinChoisi != null){
            medecinRv = medecinChoisi;
        } else {
            medecinRv = patientService.chercherPatientParAssuranceMaladie(unNom).getMedecin();
        }
        model.addAttribute("medecinRv",medecinRv);
        return "PriseRendezVous";
    }
}
