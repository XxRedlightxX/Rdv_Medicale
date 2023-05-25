package com.medical.controller;

import com.medical.entities.*;
import com.medical.service.AdministrateurService;
import com.medical.service.CliniqueService;
import com.medical.service.MedecinService;
import com.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ConnexionController {

    @Autowired
    PatientService patientService;

    @Autowired
    MedecinService medecinService;

    @Autowired
    AdministrateurService adminService;

    @Autowired
    CliniqueService cliniqueService;

    @RequestMapping(value="/connexion/patient",method ={RequestMethod.GET, RequestMethod.POST})
    public String connexionPatient(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "sauvegarde",required = false) String sauvegarde, Model model, HttpServletRequest request,  RedirectAttributes redirectAttributes, HttpServletResponse response){
        Patient patient = patientService.verifierExistencePatient(username,password);
        if(patient != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            session.setAttribute("nom", patient.getNom());
            session.setAttribute("prenom", patient.getPrenom());
            session.setAttribute("typeCompte", "patient");

            if (sauvegarde != null) {
                    Cookie monCookie = new Cookie("username", username);
                    Cookie passwordCookie = new Cookie("password", password);
                    passwordCookie.setMaxAge(60 * 60);
                    monCookie.setMaxAge(60 * 60);
                    response.addCookie(monCookie);
                    response.addCookie(passwordCookie);
            }
            model.addAttribute("PatientService",patientService);
            return "Patient";
        } else {
            if (!username.trim().equals("")) {
                redirectAttributes.addFlashAttribute("message","Le username ou mot de passe est invalide");
            }
            return "redirect:/enTete/connexion/patient";
        }
    }

    @RequestMapping(value="/connexion/medecin",method ={RequestMethod.GET, RequestMethod.POST})
    public String connexionMedecin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "sauvegarde",required = false) String sauvegarde, Model model, HttpServletRequest request,  RedirectAttributes redirectAttributes, HttpServletResponse response){
        Medecin medecin = medecinService.verifierExistenceMedecin2(username,password);
        DispoMedecin dispoMedecin = new DispoMedecin();
        if(medecin != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            session.setAttribute("nom", medecin.getNom());
            session.setAttribute("prenom", medecin.getPrenom());
            session.setAttribute("typeCompte", "medecin");

            if (sauvegarde != null) {
                    Cookie monCookie = new Cookie("username", username);
                    Cookie passwordCookie = new Cookie("password", password);
                    passwordCookie.setMaxAge(60 * 60);
                    monCookie.setMaxAge(60 * 60);
                    response.addCookie(monCookie);
                    response.addCookie(passwordCookie);
            }
            model.addAttribute("dispoMedecin",dispoMedecin);
            model.addAttribute("MedecinService",medecinService);
            return "Medecin";
        } else {
            if (!username.trim().equals("")) {
                redirectAttributes.addFlashAttribute("message","Le username ou mot de passe est invalide");
            }
            return "redirect:/enTete/connexion/medecin";
        }
    }

    @PostMapping("/connexion/administrateur")
    public String connexionAdmin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "sauvegarde",required = false) String sauvegarde, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes, HttpServletResponse response){
        Administrateur admin = adminService.verifierExistenceAdmin(username,password);
        if (admin != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            session.setAttribute("nom", admin.getNom_utilisateur());
            session.setAttribute("prenom", "ADMIN");
            session.setAttribute("typeCompte", "admin");

            if (sauvegarde != null) {
                    Cookie monCookie = new Cookie("username", username);
                    Cookie passwordCookie = new Cookie("password", password);
                    passwordCookie.setMaxAge(60 * 60);
                    monCookie.setMaxAge(60 * 60);
                    response.addCookie(monCookie);
                    response.addCookie(passwordCookie);
            }
            session.setAttribute("listePatients", patientService.afficherLesPatients());
            session.setAttribute("listeMedecins", medecinService.afficherLesMedecins());
            session.setAttribute("listeCliniques", cliniqueService.afficherLesCliniques());
            model.addAttribute("medcinService",medecinService);

            return "pageAdminPatients";
        } else {
            if (!username.trim().equals("")) {
                redirectAttributes.addFlashAttribute("message","Le username ou mot de passe est invalide");
            }
            return "redirect:/enTete/connexion/administrateur";
        }
    }







}
