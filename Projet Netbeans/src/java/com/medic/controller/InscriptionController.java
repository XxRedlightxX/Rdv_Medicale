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

/**
 *
 * @author hundl
 */
public class InscriptionController extends HttpServlet {

    String typeCompte = null;

    Patient patient = null;
    PatientService patientService = new PatientService();

    Medecin medecin = null;
    MedecinService medecinService = new MedecinService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        typeCompte = request.getParameter("typeCompte");
        if (typeCompte.equals("patient")) {
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
            //drop down pour trouver son medecin de famille -----------------------------------------------------------------
            patientService.ajouterPatient(patient, patient.getIdMedecinFamille());

            request.getRequestDispatcher("connexionController?typeCompte=" + typeCompte + "&username=" + patient.getNumeroAssuranceMaladie() + "&password=" + patient.getMotDePasse()).include(request, response);

        } else if (typeCompte.equals("medecin")) {
            medecin = new Medecin();
            medecin.setNumeroProfessionel(Integer.parseInt(request.getParameter("numeroProfessionel")));
            medecin.setNom(request.getParameter("nom"));
            medecin.setPrenom(request.getParameter("prenom"));
            medecin.setSpecialite(request.getParameter("specialite"));
            medecin.setFacturation(Float.parseFloat(request.getParameter("facturation")));
            medecin.setCoordonnees(request.getParameter("coordonnees"));
            medecin.setMotDePasse(request.getParameter("password"));
            medecin.setIdCliniqueEmploi(Integer.parseInt(request.getParameter("idClinique")));

            //drop down pour trouver sa clinique -----------------------------------------------------------------
            medecinService.ajouterMedecin(medecin, medecin.getIdCliniqueEmploi());
        }
            request.getRequestDispatcher("connexionController?typeCompte=" + typeCompte + "&username=" + medecin.getNumeroProfessionel() + "&password=" + medecin.getMotDePasse()).include(request, response);

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
