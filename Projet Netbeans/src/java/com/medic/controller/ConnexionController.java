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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hundl
 */
public class ConnexionController extends HttpServlet {
    String typeCompte = null;

    Patient patient = null;
    PatientService patientService = new PatientService();
    
    Medecin medecin = null;
    MedecinService medecinService = new MedecinService();
    
    Administrateur admin = null;
    AdministrateurService adminService = new AdministrateurService();
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sauvegarde = request.getParameter("sauvegarde");
        boolean connexion = false;

        typeCompte = request.getParameter("typeCompte");
        switch (typeCompte) {
            case "patient":
                patient = patientService.verifierExistencePatient(username, password);
                if (patient != null) {
                    connexion = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", patient.getNom());
                    session.setAttribute("prenom", patient.getPrenom());
                    session.setAttribute("typeCompte", typeCompte);
                    
                    if (sauvegarde != null) {
                        if (sauvegarde.equals("yes")) {
                            Cookie monCookie = new Cookie("username", username);
                            Cookie passwordCookie = new Cookie("password", password);
                            passwordCookie.setMaxAge(60 * 60);
                            monCookie.setMaxAge(60 * 60);
                            response.addCookie(monCookie);
                            response.addCookie(passwordCookie);
                        }
                    }
                    request.getRequestDispatcher("Patient.jsp").forward(request, response);
                }   if (!connexion) {
                    ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
                    
                    if (!username.trim().equals("")) {
                        request.setAttribute("invalide", "Le username ou mot de passe est invalide");
                    }
                    
                    request.getRequestDispatcher("Connexion_patient.jsp").include(request, response);
                    
                    
                }   break;
            case "medecin":
                medecin = medecinService.verifierExistenceMedecin(username, password);
                if (medecin != null) {
                    connexion = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", medecin.getNom());
                    session.setAttribute("prenom", medecin.getPrenom());
                    session.setAttribute("typeCompte", typeCompte);
                    
                    if (sauvegarde != null) {
                        if (sauvegarde.equals("yes")) {
                            Cookie monCookie = new Cookie("username", username);
                            Cookie passwordCookie = new Cookie("password", password);
                            passwordCookie.setMaxAge(60 * 60);
                            monCookie.setMaxAge(60 * 60);
                            response.addCookie(monCookie);
                            response.addCookie(passwordCookie);
                        }
                    }
                    request.getRequestDispatcher("Medecin.jsp").forward(request, response);
                }   if (!connexion) {
                    ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
                    
                    if (!username.trim().equals("")) {
                        request.setAttribute("invalide", "Le username ou mot de passe est invalide");
                    }
                    
                    request.getRequestDispatcher("Connexion_medecin.jsp").include(request, response);
                    
                    
                }   break;
            case "admin":
                admin = adminService.verifierExistenceAdmin(username, password);
                if (admin != null) {
                    connexion = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", admin.getUsername());
                    session.setAttribute("prenom", "ADMIN");
                    session.setAttribute("typeCompte", typeCompte);
                    
                    if (sauvegarde != null) {
                        if (sauvegarde.equals("yes")) {
                            Cookie monCookie = new Cookie("username", username);
                            Cookie passwordCookie = new Cookie("password", password);
                            passwordCookie.setMaxAge(60 * 60);
                            monCookie.setMaxAge(60 * 60);
                            response.addCookie(monCookie);
                            response.addCookie(passwordCookie);
                        }
                    }
                    request.getRequestDispatcher("pageAdminPatients.jsp").forward(request, response);
                }   if (!connexion) {
                    ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
                    
                    if (!username.trim().equals("")) {
                        request.setAttribute("invalide", "Le username ou mot de passe est invalide");
                    }
                    
                    request.getRequestDispatcher("Connexion_admin.jsp").include(request, response);
                    
                    
                }   break;
            default:
                break;
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
