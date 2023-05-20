package com.medical.controller;

import com.medical.entities.Medecin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DeconnexionController {

    @GetMapping("/deconnexion")
    public String deconnexion(HttpServletRequest request, RedirectAttributes redirectAttributes,  Medecin medecin, Model model){
            HttpSession session = request.getSession(false);
            String nom = (String) session.getAttribute("nom");
            String prenom = (String) session.getAttribute("prenom");
            String typeCompte = (String) session.getAttribute("typeCompte");
            session.invalidate();

            if (nom != null) {

                //  out.println("<center><b><font color=red>" + "Fin de session de " + nom + "</font><b></center>");
                switch (typeCompte) {
                    case "medecin":
                        nom = "Deconnexion réussie pour Dr."+prenom+" "+nom;
                        break;
                    case "admin":
                        nom = "Deconnexion réussie pour l'administrateur "+nom;
                        break;
                    default:
                        nom = "Deconnexion réussie pour le patient "+prenom+" "+nom;
                        break;
                }
            }
        redirectAttributes.addFlashAttribute("deconnexion", nom);
        return "redirect:/";
    }

}
