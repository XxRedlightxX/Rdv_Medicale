package com.medical.controller;

import com.medical.entities.Medecin;
import com.medical.entities.Patient;
import com.medical.entities.RendezVous;
import com.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Controller
public class RendezVousController {

    @Autowired
    RendezVousService rendezVousService;
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



    @PostMapping("/rendezVous/page/ajouter")
    public String envoiPageAjouterRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("rendezVous") RendezVous rendezVous){
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","ajouter");
        model.addAttribute("PatientService",patientService);
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("CliniqueService",cliniqueService);

        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/page/modifier/{id}")
    public String envoiPageModifierRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@PathVariable(name = "id") Integer id){
        RendezVous rendezVous = rendezVousService.chercherRendezVousParId(id);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","modifier");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/page/supprimer/{id}")
    public String envoiPageSupprimerRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, @PathVariable(name = "id") Integer id){
        RendezVous rendezVous = rendezVousService.chercherRendezVousParId(id);
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","supprimer");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/page/modifierDateHeure")
    public String sauvegarderChangementsRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("unRendezVousModifier") RendezVous rendezVous){
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("typeAction","modifier");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/action/ajouter")
    public String ajouterRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("rendezVous") RendezVous rendezVous){
        rendezVousService.ajouterRendezVous(rendezVous);
        String message = "Le rendez-vous à été ajouté";
        redirectAttributes.addFlashAttribute("message", message);
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("RendezVousService",rendezVousService);
        model.addAttribute("CliniqueService",cliniqueService);

        return "pagePatientRendezVous";
    }

    @PostMapping("/rendezVous/action/modifier")
    public String modifierRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("rendezVous") RendezVous rendezVous){
        rendezVousService.modifierRendezVous(rendezVous);
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("RendezVousService",rendezVousService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "pagePatientRendezVous";
    }

    @PostMapping("/rendezVous/action/supprimer/{id}")
    public String supprimerRendezVous(@PathVariable(name = "id") Integer id,HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        System.out.println(id);
        rendezVousService.supprimerRendezVous(id);
        String message = "Le rendez-vous à été annulé";
        model.addAttribute("message", message);
        model.addAttribute("MedecinService",medecinService);
        model.addAttribute("PatientService",patientService);
        model.addAttribute("RendezVousService",rendezVousService);
        model.addAttribute("CliniqueService",cliniqueService);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/changerTemps")
    public String changerTempsRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@RequestParam("idRendezVous") String idRendezVous,@RequestParam("idPatient") String idPatient,@RequestParam("idMedecin") String idMedecin,@RequestParam("dateRv") String dateRv,@RequestParam("heureRv") String heureRv,@RequestParam("raisonConsult") String raisonConsult, @RequestParam("descriptionConsult") String descriptionConsult) {
        RendezVous rendezVous = new RendezVous(patientService.chercherPatientParId(Integer.parseInt(idPatient)),medecinService.chercherMedecinParId(Integer.parseInt(idMedecin)), dateRv, heureRv, raisonConsult, descriptionConsult);
        rendezVous.setId_rendez_vous(Integer.parseInt(idRendezVous));
        System.out.println(rendezVous);
        LocalDate date = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        model.addAttribute("jourSemaine", date);
        model.addAttribute("medecinRv",rendezVous.getMedecin_rv());
        model.addAttribute("rendezVousService",rendezVousService);
        model.addAttribute("dispomedecinService",dispoMedecinService);
        model.addAttribute("unRendezVousModifier", rendezVous);
        return "ModifierTempsRendezVous";
    }


}
