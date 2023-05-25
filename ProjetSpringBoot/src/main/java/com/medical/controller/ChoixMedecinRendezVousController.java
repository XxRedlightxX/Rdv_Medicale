package com.medical.controller;

import com.medical.entities.Medecin;
import com.medical.entities.RendezVous;
import com.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    ServicesCliniqueService servicesCliniqueService;

    @Autowired
    CliniqueService cliniqueService;

    @GetMapping("/rendezVous/choixMedecin/filtrerSpecialite")
    public String filtrerParSpecialite(@Param("nomSpecialite") String nomSpecialite, HttpServletRequest request, RedirectAttributes redirectAttributes, Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.chercherParSpecialite(nomSpecialite));
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }

    @GetMapping("/rendezVous/choixMedecin/filterGMF")
    public String filtrerParGMF(@Param("medecinGMF") String medecinGMF, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.chercherNomClinique(medecinGMF));
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }

    @GetMapping("/rendezVous/choixMedecin/afficherTousLesMedecins")
    public String afficherTousLesMedecins(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.afficherLesMedecins());
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }

    @GetMapping("/rendezVous/choixMedecin/filterClinique")
    public String filtrerParClinique(@Param("nomClinique") String nomClinique, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.chercherNomClinique(nomClinique));
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }


    @GetMapping("/rendezVous/choixMedecin/prendeRendezVous/{id}")
    public String prendreRendezVousAvecMedecinChoisi(@PathVariable(name = "id") Integer id, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        RendezVous rendezVous = new RendezVous();
        Medecin medecinRv = medecinService.chercherMedecinParId(id);
        model.addAttribute("typeRecherche", "prendreRendezVous");
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        LocalDate date = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        model.addAttribute("jourSemaine", date);
        model.addAttribute("rendezVous",rendezVous);
        model.addAttribute("dispomedecinService",dispoMedecinService);
        model.addAttribute("rendezVousService",rendezVousService);
        model.addAttribute("medecinRv",medecinRv);
        return "PriseRendezVous";
    }
}
