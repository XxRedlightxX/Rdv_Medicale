package com.medical.controller;

import com.medical.entities.RendezVous;
import com.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        model.addAttribute("typeAction","modifier");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/action/ajouter")
    public String ajouterRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("rendezVous") RendezVous rendezVous){
        rendezVousService.ajouterRendezVous(rendezVous);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/modifier")
    public String modifierRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("rendezVous") RendezVous rendezVous){
        rendezVousService.modifierRendezVous(rendezVous);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/supprimer/{id}")
    public String supprimerRendezVous(@PathVariable(name = "id") Integer id,HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        rendezVousService.supprimerRendezVous(rendezVousService.chercherRendezVousParId(id).getId_rendez_vous());
        String message = "Le rendez-vous à été annulé";
        model.addAttribute("message", message);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/changerTemps")
    public String changerTempsRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, @ModelAttribute("rendezVous") RendezVous rendezVous){
        model.addAttribute("unRendezVousModifier", rendezVous);
        return "ModifierTempsRendezVous";
    }


}
