package com.medical.controller;

import com.medical.entities.DispoMedecin;
import com.medical.entities.Medecin;
import com.medical.entities.RendezVous;
import com.medical.service.DispoMedecinService;
import com.medical.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DispoMedecinController {

    @Autowired
    DispoMedecinService dispoMedecinService;

    @Autowired
    MedecinService medecinService;

    @GetMapping("/medecin/definirDisponibilite")
    public String definirDispo(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, @ModelAttribute("dispoMedecin") DispoMedecin dispoMedecin){
        DispoMedecin dispoExistante = dispoMedecinService.verifierExistenceDispo(dispoMedecin.getMedecin_dispo().getId_medecin(),dispoMedecin.getDate_dispo());
        model.addAttribute("MedecinService",medecinService);

        if (dispoExistante != null){
            String message = "Vous avez déja établi des créneaux pour cette période veuillez choisir modifier";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/enTete/medecin/Accueil";
        } else {
            String message = "Disponibilités pour le "+dispoMedecin.getDate_dispo()+" établies";
            dispoMedecinService.ajouterDispoMedecin(dispoMedecin);
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/enTete/medecin/Accueil";
        }
    }

    @GetMapping("/medecin/changerTarif")
    public String definirTarif(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model,@RequestParam("tarif") String tarif,@RequestParam("id_medecin") String id_medecin){
        model.addAttribute("MedecinService",medecinService);
        Float facturation = Float.parseFloat(tarif);
        Medecin unMedecin = medecinService.chercherMedecinParId(Integer.parseInt(id_medecin));
        unMedecin.setFacturation(facturation);
        medecinService.modifierMedecin(unMedecin);
        return "Medecin";
    }
}
