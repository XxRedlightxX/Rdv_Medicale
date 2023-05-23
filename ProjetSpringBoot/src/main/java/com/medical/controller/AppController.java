package com.medical.controller;

import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.entities.RendezVous;
import com.medical.repos.CliniqueRepository;
import com.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;


@Controller
public class AppController {

    @Autowired
    ServicesCliniqueService servicesCliniqueService;
    @Autowired
    CliniqueService cliniqueService;

    @Autowired
    MedecinService medecinService;

    @Autowired
    PatientService patientService;

    @Autowired
    DispoMedecinService dispoMedecinService;

    @Autowired
    RendezVousService rendezVousService;




    @GetMapping("/")
    public String pageAccueil(){
        return "Accueil";
    }

    @GetMapping("/enTete/connexion/patient")
    public String pageConnexionPatient(Model model){
        Patient patient = new Patient();
        model.addAttribute("patient",patient);
        model.addAttribute("medecinService",medecinService);


        return "Connexion_patient";
    }

    @GetMapping("/enTete/connexion/medecin")
    public String pageConnexionMedecin(Model model){
        Medecin medecin = new Medecin();
        model.addAttribute("medecin",medecin);
        model.addAttribute("servicesCliniqueService",servicesCliniqueService);
        model.addAttribute("cliniqueService",cliniqueService);
        return "Connexion_medecin";
    }
    @GetMapping("/enTete/connexion/administrateur")
    public String pageConnexionAdmin(){
        return "Connexion_admin";
    }

    @GetMapping("/enTete/patient/accueil")
    public String pageAccueilPatient(Model model){
        model.addAttribute("PatientService",patientService);
        return "Patient";
    }
    @GetMapping("/enTete/patient/rendezVous")
    public String pageRendezVousPatient(Model model){
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("RendezVousService",rendezVousService);
        model.addAttribute("CliniqueService",cliniqueService);

        return "pagePatientRendezVous";
    }
    @GetMapping("/enTete/patient/priseRendezVous")
    public String pagePriseRendezVousPatient(@PathVariable(name = "medecinChoisi",required = false) Medecin medecinChoisi, HttpServletRequest request, RedirectAttributes redirectAttributes, Model model){
        HttpSession session = request.getSession(true);
        String unNom = (String) session.getAttribute("username");
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
            medecinRv = medecinService.chercherMedecinParId(patientService.chercherPatientParAssuranceMaladie(unNom).getMedecin().getId_medecin());
        }
        model.addAttribute("medecinRv",medecinRv);
        return "PriseRendezVous";
    }

    @GetMapping("/enTete/patient/modifierRendezVous")
    public String pageModifierRendezVousPatient(@ModelAttribute("rendezVous") RendezVous rendezVous, HttpServletRequest request, RedirectAttributes redirectAttributes, Model model){
        HttpSession session = request.getSession(true);
        String unNom = (String) session.getAttribute("username");
        Medecin medecinRv = new Medecin();
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

    @GetMapping("/enTete/patient/rechercheClinique")
    public String pageRechereCliniquePatient(){ return "CliniqueInfo";
    }
    @GetMapping("/enTete/medecin/Accueil")
    public String pageAccueilMedecin(Model model){
        model.addAttribute("MedecinService",medecinService);
        return "Medecin";
    }
    @GetMapping("/enTete/medecin/rechercheClinique")
    public String pageRechereCliniqueMedecin(){ return "CliniqueInfo";
    }

    @GetMapping("/enTete/admin/pagePatients")
    public String pagePatientAdmin(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("listePatients", patientService.afficherLesPatients());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        model.addAttribute("medcinService",medecinService);
        model.addAttribute("medcinService",medecinService);
        return "pageAdminPatients";
    }
    @GetMapping("/enTete/admin/pageMedecin")
    public String pageMedecinAdmin(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("listePatients", patientService.afficherLesPatients());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        model.addAttribute("cliniqueService",cliniqueService);
        return "pageAdminMedecins";
    }

    @GetMapping("/enTete/admin/pageClinique")
    public String pageCliniqueAdmin(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("listePatients", patientService.afficherLesPatients());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "pageAdminCliniques";
    }

    @GetMapping("/enTete/admin/rechercheClinique")
    public String pageRechereCliniqueAdministrateur(){ return "CliniqueInfo";
    }




}
