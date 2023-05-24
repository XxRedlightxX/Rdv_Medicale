package com.medical.controller;

import com.medical.entities.Clinique;
import com.medical.entities.Patient;
import com.medical.service.CliniqueService;
import com.medical.service.MedecinService;
import com.medical.service.PatientService;
import com.medical.service.ServicesCliniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CliniqueController {

    @Autowired
    PatientService patientService;
    @Autowired
    MedecinService medecinService;

    @Autowired
    CliniqueService cliniqueService;

    @Autowired
    ServicesCliniqueService servicesCliniqueService;




    @GetMapping("/clinique/rechercher")
    public String rechercherClinique(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(name = "nom") String nom, Model model){
        List<Clinique> listeClinique;
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("servicesCliniqueService",servicesCliniqueService);
        model.addAttribute("cliniqueService",cliniqueService);

        model.addAttribute("nom", nom);
        if ( nom != null && !nom.equals("")) {
            listeClinique = cliniqueService.chercherCliniqueParNom(nom);
            model.addAttribute("ListeClinique", listeClinique);
            //model.addAttribute("listeClinique1", listeClinique);
            //model.addAttribute("nom", nom);
            return "CliniqueInfo";
        } else {
            listeClinique = cliniqueService.afficherLesCliniques();
            model.addAttribute("ListeClinique1", listeClinique);
            //model.addAttribute("nom", nom);
            return "CliniqueInfo";
        }
    }

    @GetMapping("/clinique/filtre")
    public String Typeservice(Model model,@RequestParam(name = "typeService") String typeService){
        System.out.println(typeService);
        System.out.println("hello u work?");
        List<Clinique> listCliniqueByService = cliniqueService.chercherParService(typeService);

        for (Clinique clinique : listCliniqueByService) {
            System.out.println("Nom : " + clinique.getNom());
            System.out.println("service : " + clinique.getServices());

        }
        model.addAttribute("ListeClinique",listCliniqueByService);
        return "CliniqueInfo";
    }


}
