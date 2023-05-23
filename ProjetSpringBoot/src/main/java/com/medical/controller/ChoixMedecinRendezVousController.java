package com.medical.controller;

import com.medical.entities.Medecin;
import com.medical.entities.RendezVous;
import com.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/rendezVous/choixMedecin/filtrerSpecialite")
    public String filtrerParSpecialite(@Param("nomSpecialite") String nomSpecialite, HttpServletRequest request, RedirectAttributes redirectAttributes, Model model){
        byte[] bytes = nomSpecialite.getBytes(StandardCharsets.ISO_8859_1);
        nomSpecialite = new String(bytes, StandardCharsets.UTF_8);
        model.addAttribute("listeMedecinRecherche", medecinService.chercherParSpecialite(nomSpecialite));
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }

    @PostMapping("/rendezVous/choixMedecin/filterGMF")
    public String filtrerParGMF(@Param("medecinGMF") String medecinGMF, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.chercherNomClinique(medecinGMF));
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }

    @PostMapping("/rendezVous/choixMedecin/afficherTousLesMedecins")
    public String afficherTousLesMedecins(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.afficherLesMedecins());
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }

    @PostMapping("/rendezVous/choixMedecin/filterClinique")
    public String filtrerParClinique(@Param("nomClinique") String nomClinique, HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model){
        model.addAttribute("listeMedecinRecherche", medecinService.chercherNomClinique(nomClinique));
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("ServicesCliniqueService",servicesCliniqueService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "RechercherMedecinRv";
    }


    @PostMapping("/rendezVous/choixMedecin/prendeRendezVous/{medecinChoisi}")
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
