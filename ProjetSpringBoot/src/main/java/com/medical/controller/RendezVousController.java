package com.medical.controller;

import com.medical.entities.RendezVous;
import com.medical.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RendezVousController {

    @Autowired
    RendezVousService rendezVousService;

    @PostMapping("/rendezVous/page/ajouter")
    public String envoiPageAjouterRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@ModelAttribute("rendezVous") RendezVous rendezVous){
        System.out.println("Form submitted. rendezVous: " + rendezVous);
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","ajouter");
        //return "PatientGestionRendezVous";
        return "Accueil";
    }

    @GetMapping("/rendezVous/page/modifier")
    public String envoiPageModifierRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","modifier");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/page/supprimer")
    public String envoiPageSupprimerRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","supprimer");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/page/modifierDateHeure")
    public String sauvegarderChangementsRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        model.addAttribute("unRendezVous",rendezVous);
        model.addAttribute("typeAction","modifier");
        return "PatientGestionRendezVous";
    }

    @GetMapping("/rendezVous/action/ajouter")
    public String ajouterRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        rendezVousService.ajouterRendezVous(rendezVous);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/modifier")
    public String modifierRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        rendezVousService.modifierRendezVous(rendezVous);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/supprimer")
    public String supprimerRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        rendezVousService.supprimerRendezVous(rendezVous.getId_rendez_vous());
        String message = "Le rendez-vous à été annulé";
        model.addAttribute("message", message);
        return "pagePatientRendezVous";
    }

    @GetMapping("/rendezVous/action/changerTemps")
    public String changerTempsRendezVous(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, RendezVous rendezVous){
        model.addAttribute("unRendezVous", rendezVous);
        return "ModifierTempsRendezVous";
    }


}
