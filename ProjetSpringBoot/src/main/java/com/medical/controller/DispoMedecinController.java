package com.medical.controller;

import com.medical.entities.DispoMedecin;
import com.medical.entities.Medecin;
import com.medical.service.DispoMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DispoMedecinController {

    @Autowired
    DispoMedecinService dispoMedecinService;

    @GetMapping("/medecin/definirDisponibilite")
    public String definirDispo(HttpServletRequest request, RedirectAttributes redirectAttributes,  Model model, DispoMedecin dispoMedecin){
        DispoMedecin dispoExistante = dispoMedecinService.verifierExistenceDispo(dispoMedecin.getMedecin().getId_medecin(),dispoMedecin.getDate_dispo());
        if (dispoExistante != null){
            model.addAttribute("invalide", "Vous avez déja établi des créneaux pour cette période veuillez choisir modifier");
            return "Medecin";
        } else {
            dispoMedecinService.ajouterDispoMedecin(dispoMedecin);
            return "Medecin";
        }
    }
}
