package com.medical.controller;

import com.medical.entities.*;
import com.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdministrateurController {

    @Autowired
    PatientService patientService;
    @Autowired
    MedecinService medecinService;

    @Autowired
    CliniqueService cliniqueService;

    @Autowired
    ServicesCliniqueService servicesCliniqueService;

    // Envoyer vers les pages
    @PostMapping("/administrateur/patient/envoiPageAjouter")
    public String afficherPageAjouterPatient(Model model){
        Patient patient = new Patient();
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("patient",patient);
        model.addAttribute("typeAction", "ajouter");
        return "AdminGestionPatients";
    }

    @PostMapping("/administrateur/patient/envoiPageModifier/{id}")
    public String afficherPageModifierPatient(@PathVariable(name = "id") Integer id,Model model){
        Patient patient = new Patient();
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("patient",patient);
        model.addAttribute("typeAction", "modifier");
        Patient unPatient = patientService.chercherPatientParId(id);
        model.addAttribute("unPatient",unPatient);
        return "AdminGestionPatients";
    }

    @PostMapping("/administrateur/patient/envoiPageSupprimer/{id}")
    public String afficherPageSupprimerPatient(@PathVariable(name = "id") Integer id,Model model){
        Patient patient = new Patient();
        model.addAttribute("patient",patient);
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("typeAction", "supprimer");
        Patient unPatient = patientService.chercherPatientParId(id);
        model.addAttribute("unPatient",unPatient);
        return "AdminGestionPatients";
    }

    @PostMapping("/administrateur/medecin/envoiPageAjouter")
    public String afficherPageAjouterMedecin(Model model){
        Medecin medecin = new Medecin();
        model.addAttribute("servicesCliniqueService",servicesCliniqueService);
        model.addAttribute("cliniqueService",cliniqueService);
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("medecin",medecin);
        model.addAttribute("typeAction", "ajouter");
        return "AdminGestionMedecins";
    }

    @PostMapping("/administrateur/medecin/envoiPageModifier/{id}")
    public String afficherPageModifierMedecin(@PathVariable(name = "id") Integer id,Model model){
        Medecin medecin = new Medecin();
        model.addAttribute("servicesCliniqueService",servicesCliniqueService);
        model.addAttribute("cliniqueService",cliniqueService);
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("medecin",medecin);
        model.addAttribute("typeAction", "modifier");
        Medecin unMedecin = medecinService.chercherMedecinParId(id);
        model.addAttribute("unMedecin",unMedecin);
        return "AdminGestionMedecins";
    }

    @PostMapping("/administrateur/medecin/envoiPageSupprimer/{id}")
    public String afficherPageSupprimerMedecin(@PathVariable(name = "id") Integer id,Model model){
        Medecin medecin = new Medecin();
        model.addAttribute("servicesCliniqueService",servicesCliniqueService);
        model.addAttribute("cliniqueService",cliniqueService);
        model.addAttribute("medecinService",medecinService);
        model.addAttribute("medecin",medecin);
        model.addAttribute("typeAction", "supprimer");
        Medecin unMedecin = medecinService.chercherMedecinParId(id);
        model.addAttribute("unMedecin",unMedecin);
        return "AdminGestionMedecins";
    }

    @PostMapping("/administrateur/clinique/envoiPageAjouter")
    public String afficherPageAjouterClinique(Model model){
        Clinique clinique = new Clinique();
        model.addAttribute("clinique",clinique);
        model.addAttribute("typeAction", "ajouter");
        return "AdminGestionCliniques";
    }

    @PostMapping("/administrateur/clinique/envoiPageModifier/{id}")
    public String afficherPageModifierClinique(@PathVariable(name = "id") Integer id,Model model){
        Clinique clinique = new Clinique();
        model.addAttribute("clinique",clinique);
        model.addAttribute("typeAction", "modifier");
        Clinique unClinique = cliniqueService.chercherCliniqueParId(id);
        model.addAttribute("uneClinique",unClinique);
        return "AdminGestionCliniques";
    }

    @PostMapping("/administrateur/clinique/envoiPageSupprimer/{id}")
    public String afficherPageSupprimerClinique(@PathVariable(name = "id") Integer id,Model model){
        Clinique clinique = new Clinique();
        model.addAttribute("clinique",clinique);
        model.addAttribute("typeAction", "supprimer");
        Clinique unClinique = cliniqueService.chercherCliniqueParId(id);
        model.addAttribute("uneClinique",unClinique);
        return "AdminGestionCliniques";
    }

    // Faire les actions sur la base de données
    @PostMapping("/administrateur/patient/ajouterPatient")
    public String ajouterPatient(HttpServletRequest request,RedirectAttributes redirectAttributes,Patient patient,Model model){
        String message = "Le patient " + patient.getNom() + " " + patient.getPrenom() + " à été ajouté";
        patientService.ajouterPatient(patient);
        redirectAttributes.addFlashAttribute("message",message);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("listePatients", patientService.afficherLesPatients());
        return "redirect:/enTete/admin/pagePatients";
    }

    @PostMapping("/administrateur/patient/modifierPatient/{id}")
    public String modifierPatient(Patient patient,HttpServletRequest request, RedirectAttributes redirectAttributes, @PathVariable(name = "id") Integer id, Model model){
        String message = "Le patient " + patient.getNom() + " " + patient.getPrenom() + " à été modifié";
        redirectAttributes.addFlashAttribute("message",message);
        patientService.modifierPatient(patient);
        HttpSession session = request.getSession(true);
        session.setAttribute("listePatients", patientService.afficherLesPatients());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pagePatients";
    }

    @PostMapping("/administrateur/patient/supprimerPatient/{id}")
    public String supprimerPatient(HttpServletRequest request, RedirectAttributes redirectAttributes, @PathVariable(name = "id") Integer id, Model model){
        Patient unPatient = patientService.chercherPatientParId(id);
        String unNom = unPatient.getNom();
        String unPrenom = unPatient.getPrenom();
        patientService.supprimerPatient(id);
        String message = "Le patient " + unNom + " " + unPrenom + " à été supprimé";
        redirectAttributes.addFlashAttribute("message",message);
        HttpSession session = request.getSession(true);
        session.setAttribute("listePatients", patientService.afficherLesPatients());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pagePatients";
    }

    @PostMapping("/administrateur/medecin/ajouterMedecin")
    public String ajouterMedecin(HttpServletRequest request,RedirectAttributes redirectAttributes,Medecin medecin,Model model){
        String message = "Le medecin " + medecin.getNom() + " " + medecin.getPrenom() + " à été ajouté";
        medecinService.ajouterMedecin(medecin);
        redirectAttributes.addFlashAttribute("message",message);
        HttpSession session = request.getSession(true);
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        return "redirect:/enTete/admin/pageMedecin";
    }

    @PostMapping("/administrateur/medecin/modifierMedecin/{id}")
    public String modifierMedecin(@ModelAttribute("medecin") Medecin medecin, HttpServletRequest request, RedirectAttributes redirectAttributes, Model model){
        String message = "Le médecin " + medecin.getNom() + " " + medecin.getPrenom() + " à été modifié";
        redirectAttributes.addFlashAttribute("message",message);
        medecinService.modifierMedecin(medecin);
        HttpSession session = request.getSession(true);
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pageMedecin";
    }

    @PostMapping("/administrateur/medecin/supprimerMedecin/{id}")
    public String supprimerMedecin(HttpServletRequest request, RedirectAttributes redirectAttributes, @PathVariable(name = "id") Integer id, Model model){
        Medecin unMedecin = medecinService.chercherMedecinParId(id);
        String unNom = unMedecin.getNom();
        String unPrenom = unMedecin.getPrenom();
        medecinService.supprimerMedecin(id);
        String message = "Le médecin " + unNom + " " + unPrenom + " à été supprimé";
        redirectAttributes.addFlashAttribute("message",message);
        HttpSession session = request.getSession(true);
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pageMedecin";
    }

    @PostMapping("/administrateur/clinique/ajouterClinique")
    public String ajouterClinique(HttpServletRequest request,RedirectAttributes redirectAttributes,Clinique clinique,Model model){
        String message = "Le clinique " + clinique.getNom() +" à été ajouté";
        cliniqueService.ajouterClinique(clinique);
        redirectAttributes.addFlashAttribute("message",message);
        HttpSession session = request.getSession(true);
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pageClinique";
    }

    @PostMapping("/administrateur/clinique/modifierClinique/{id}")
    public String modifierClinique(Clinique clinique,HttpServletRequest request, RedirectAttributes redirectAttributes, @PathVariable(name = "id") Integer id, Model model){
        String message = "La clinique " + clinique.getNom() + " à été modifié";
        redirectAttributes.addFlashAttribute("message",message);
        cliniqueService.modifierClinique(clinique);
        HttpSession session = request.getSession(true);
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pageClinique";
    }

    @PostMapping("/administrateur/clinique/supprimerClinique/{id}")
    public String supprimerClinique(HttpServletRequest request, RedirectAttributes redirectAttributes, @PathVariable(name = "id") Integer id, Model model){
        Clinique unClinique = cliniqueService.chercherCliniqueParId(id);
        String unNom = unClinique.getNom();
        cliniqueService.supprimerClinique(id);
        String message = "La clinique " + unNom + " à été supprimé";
        redirectAttributes.addFlashAttribute("message",message);
        HttpSession session = request.getSession(true);
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
        return "redirect:/enTete/admin/pageClinique";
    }



















}
