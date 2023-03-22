/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.Patient;
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

    Patient patient = null;
    String typeCompte = null;
    PatientService service = new PatientService();
    Boolean connexion = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sauvegarde = request.getParameter("sauvegarde");

        typeCompte = request.getParameter("typeCompte");
        if (typeCompte.contains("patient")) {
            patient = service.verifierExistencePatient(username, password);
            
            if (patient != null) {
                connexion = true;
                HttpSession session = request.getSession(true);
                session.setAttribute("nom", patient.getNom());
                session.setAttribute("prenom", patient.getPrenom());
                session.setAttribute("typeCompte",typeCompte);

                if (sauvegarde != null) {
                    if (sauvegarde.equals("yes")) {
                        Cookie monCookie = new Cookie("username", username);
                        Cookie passwordCookie = new Cookie("password", password);
                        System.out.println("ajouter des cookies");
                        passwordCookie.setMaxAge(60 * 60);
                        monCookie.setMaxAge(60 * 60);
                        response.addCookie(monCookie);
                        response.addCookie(passwordCookie);
                    }
                }
                request.getRequestDispatcher("Patient.jsp").forward(request, response);
            }
            
            if (!connexion) {
         ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
            
                request.setAttribute("invalide", "Le username ou mot de passe est invalide");
            
            
            request.getRequestDispatcher("Connexion_patient.jsp").include(request, response);
           
        }
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
