package com.medical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMailWithAttachment(String to, String subject, String body,String fileToAttach) throws MessagingException {

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("expediteur@gmail.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);
        File saveFile = new File(fileToAttach);
        System.out.println("saveFile ds: " + saveFile.getAbsolutePath());
        FileSystemResource fileSystemResource=
                new FileSystemResource(new File(fileToAttach));
        try {
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
                    fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.printf("Le message avec pièce jointe a été envoyé avec succès à " +to);

    }
}
