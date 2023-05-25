package com.medical.controller;

import com.medical.entities.Medecin;
import com.medical.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;
    @GetMapping("/contact")
    public String pageAccueil (){
        return "email_form";
    }

    @PostMapping("/email/save")
    public String envoyerEmail(Medecin medecin, RedirectAttributes redirectAttributes,
                               @RequestParam("destinataire") String destinataire,
                               @RequestParam("objet") String objet,
                               @RequestParam("contenu") String contenu,
                               @RequestParam("fileImage") MultipartFile multipartFile) throws MessagingException {
        // multipartFile.getOriginalFilename();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());


        emailService.sendMailWithAttachment(destinataire, objet, contenu, fileName);
        redirectAttributes.addFlashAttribute("message", "Le message a été envoyé avec succès à " + destinataire);


        return "redirect:/Patient";

    }
}
