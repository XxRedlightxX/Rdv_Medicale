/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.Administrateur;
import com.medic.entities.Medecin;
import com.medic.entities.Patient;
import com.medic.service.AdministrateurService;
import com.medic.service.MedecinService;
import com.medic.service.PatientService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hundl
 */
public class AdministrateurController extends HttpServlet {

    Patient patient = null;
    PatientService patientService = new PatientService();

    Medecin medecin = null;
    MedecinService medecinService = new MedecinService();

    Administrateur admin = null;
    AdministrateurService adminService = new AdministrateurService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        String gestionAction = request.getParameter("gestionAction");
        String idPatient = request.getParameter("idPatient");

        String supprimerPatient = request.getParameter("supprimerPatient");
        String ajouterPatient = request.getParameter("ajouterPatient");
        String modifierPatient = request.getParameter("modifierPatient");

        if (idPatient != null) {
            switch (gestionAction) {
                case "ajouter": 
                    request.setAttribute("typeAction", gestionAction);
                    request.getRequestDispatcher("AdminGestionPatients.jsp").forward(request, response);
                    break;
                
                case "modifier": 
                    request.setAttribute("typeAction", gestionAction);
                    int idpatient = Integer.parseInt(request.getParameter("idPatient"));
                    patient = patientService.chercherPatientParId(idpatient);
                    request.setAttribute("unPatient", patient);
                    request.getRequestDispatcher("AdminGestionPatients.jsp").forward(request, response);
                    break;
                
                case "supprimer": 
                    request.setAttribute("typeAction", gestionAction);
                    idpatient = Integer.parseInt(request.getParameter("idPatient"));
                    patient = patientService.chercherPatientParId(idpatient);
                    request.setAttribute("unPatient", patient);
                    request.getRequestDispatcher("AdminGestionPatients.jsp").forward(request, response);
                    break;
                
                default:
                    break;
            }
        }
        if (supprimerPatient != null) {
            int idpatient = Integer.parseInt(request.getParameter("supprimerPatient"));
            patient = patientService.chercherPatientParId(idpatient);
            String unNom = patient.getNom();
            String unPrenom = patient.getPrenom();
            patientService.supprimerPatient(idpatient);

            String message = "Le patient " + unNom + " " + unPrenom + " à été supprimé";
            request.setAttribute("message", message);

            session.setAttribute("listePatients", patientService.afficherLesPatients());

            request.getRequestDispatcher("pageAdminPatients.jsp").forward(request, response);

        } else if (ajouterPatient != null) {
            patient = new Patient();
            patient.setId(patientService.trouverLeIdMaxPatient() + 1);
            patient.setNom(request.getParameter("nom"));
            patient.setPrenom(request.getParameter("prenom"));
            patient.setNumeroAssuranceMaladie(request.getParameter("assuranceMaladie"));
            patient.setNumeroSequentiel(Integer.parseInt(request.getParameter("numeroSeq")));
            patient.setDateNaissance(request.getParameter("dateNaissance"));
            patient.setSexe(request.getParameter("sexe"));
            patient.setMotDePasse(request.getParameter("password"));
            patient.setIdMedecinFamille(Integer.parseInt(request.getParameter("idMedecinFamille")));
            String message = "Le patient " + patient.getNom() + " " + patient.getPrenom() + " à été ajouté";
            //drop down pour trouver son medecin de famille -----------------------------------------------------------------
            patientService.ajouterPatient(patient, patient.getIdMedecinFamille());
            request.setAttribute("message", message);

            session.setAttribute("listePatients", patientService.afficherLesPatients());

            request.getRequestDispatcher("pageAdminPatients.jsp").forward(request, response);

        } else if (modifierPatient != null) {
            patient = new Patient();
            patient.setId(Integer.parseInt(request.getParameter("modifierPatient")));
            patient.setNom(request.getParameter("nom"));
            patient.setPrenom(request.getParameter("prenom"));
            patient.setNumeroAssuranceMaladie(request.getParameter("assuranceMaladie"));
            patient.setNumeroSequentiel(Integer.parseInt(request.getParameter("numeroSeq")));
            patient.setDateNaissance(request.getParameter("dateNaissance"));
            patient.setSexe(request.getParameter("sexe"));
            patient.setMotDePasse(request.getParameter("password"));
            patient.setIdMedecinFamille(Integer.parseInt(request.getParameter("idMedecinFamille")));

            String message = "Le patient " + patient.getNom() + " " + patient.getPrenom() + " à été modifié";
            //drop down pour trouver son medecin de famille -----------------------------------------------------------------
            patientService.modifierPatient(patient, Integer.parseInt(request.getParameter("idMedecinFamille")), Integer.parseInt(request.getParameter("modifierPatient")));
            request.setAttribute("message", message);

            session.setAttribute("listePatients", patientService.afficherLesPatients());

            request.getRequestDispatcher("pageAdminPatients.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
