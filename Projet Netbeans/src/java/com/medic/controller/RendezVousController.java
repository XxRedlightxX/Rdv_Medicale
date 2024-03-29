/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.RendezVous;
import com.medic.service.RendezVousService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hundl
 */
public class RendezVousController extends HttpServlet {

    RendezVous unRendezVous = null;

    RendezVousService dao = new RendezVousService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idPatient = request.getParameter("idPatient");
        String idMedecin = request.getParameter("idMedecin");
        String dateRv = request.getParameter("dateRv");
        String heureRv = request.getParameter("heureRv");
        String raisonConsult = request.getParameter("raisonConsult");
        if (raisonConsult != null) {
            byte[] bytes = raisonConsult.getBytes(StandardCharsets.ISO_8859_1);
            raisonConsult = new String(bytes, StandardCharsets.UTF_8);
        }

        String descriptionConsult = request.getParameter("descriptionConsult");
        String etape1Rv = request.getParameter("etape1Rv");
        String idRendezVous = request.getParameter("idRendezVous");
        String actionRv = request.getParameter("actionRv");

        if (etape1Rv != null) {
            switch (etape1Rv) {
                case "ajouter":
                    request.setAttribute("idPatient", idPatient);
                    request.setAttribute("idMedecin", idMedecin);
                    request.setAttribute("dateRv", dateRv);
                    request.setAttribute("heureRv", heureRv);
                    request.setAttribute("raisonConsult", raisonConsult);
                    request.setAttribute("descriptionConsult", descriptionConsult);
                    request.setAttribute("typeAction", "ajouter");
                    request.getRequestDispatcher("PatientGestionRendezVous.jsp").forward(request, response);
                    break;
                case "modifier":
                    unRendezVous = dao.chercherRendezVousParId(Integer.parseInt(idRendezVous));
                    System.out.println(unRendezVous);
                    request.setAttribute("unRendezVous", unRendezVous);
                    request.setAttribute("typeAction", "modifier");
                    request.getRequestDispatcher("PatientGestionRendezVous.jsp").forward(request, response);
                    break;
                case "supprimer":
                    unRendezVous = dao.chercherRendezVousParId(Integer.parseInt(idRendezVous));
                    request.setAttribute("unRendezVous", unRendezVous);
                    request.setAttribute("typeAction", "supprimer");
                    request.getRequestDispatcher("PatientGestionRendezVous.jsp").forward(request, response);
                    break;
                case "modifier2":
                    unRendezVous = new RendezVous();
                    unRendezVous.setIdRendezVous(Integer.parseInt(idRendezVous));
                    unRendezVous.setIdPatientRv(Integer.parseInt(idPatient));
                    unRendezVous.setIdMedecinRv(Integer.parseInt(idMedecin));
                    unRendezVous.setDateRv(dateRv);
                    unRendezVous.setHeureRv(heureRv);
                    unRendezVous.setRaisonConsult(raisonConsult);
                    unRendezVous.setDescriptionConsult(descriptionConsult);
                    request.setAttribute("typeAction", "modifier");
                    request.setAttribute("unRendezVous", unRendezVous);
                    request.getRequestDispatcher("PatientGestionRendezVous.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }

        if (actionRv != null) {
            if (actionRv.equals("ajouter")) {
                unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(dao.trouverLeIdMaxRendezVous() + 1);
                unRendezVous.setIdPatientRv(Integer.parseInt(idPatient));
                unRendezVous.setIdMedecinRv(Integer.parseInt(idMedecin));
                unRendezVous.setDateRv(dateRv);
                unRendezVous.setHeureRv(heureRv);
                unRendezVous.setRaisonConsult(raisonConsult);
                unRendezVous.setDescriptionConsult(descriptionConsult);
                dao.ajouterRendezVous(unRendezVous);
                request.getRequestDispatcher("Patient.jsp").forward(request, response);
            } else if (actionRv.equals("modifier")) {
                unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(Integer.parseInt(idRendezVous));
                unRendezVous.setIdPatientRv(Integer.parseInt(idPatient));
                unRendezVous.setIdMedecinRv(Integer.parseInt(idMedecin));
                unRendezVous.setDateRv(dateRv);
                unRendezVous.setHeureRv(heureRv);
                unRendezVous.setRaisonConsult(raisonConsult);
                unRendezVous.setDescriptionConsult(descriptionConsult);
                dao.modifierRendezVous(unRendezVous);
                request.getRequestDispatcher("pagePatientRendezVous.jsp").forward(request, response);
            } else if (actionRv.equals("supprimer")) {
                dao.supprimerRendezVous(Integer.parseInt(idRendezVous));
                String message = "Le rendez-vous à été annulé";
                request.setAttribute("message", message);
                request.getRequestDispatcher("pagePatientRendezVous.jsp").forward(request, response);
            } else if (actionRv.equals("changerTemps")) {
                unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(Integer.parseInt(idRendezVous));
                unRendezVous.setIdPatientRv(Integer.parseInt(idPatient));
                unRendezVous.setIdMedecinRv(Integer.parseInt(idMedecin));
                unRendezVous.setDateRv(dateRv);
                unRendezVous.setHeureRv(heureRv);
                unRendezVous.setRaisonConsult(raisonConsult);
                unRendezVous.setDescriptionConsult(descriptionConsult);
                System.out.println(unRendezVous);
                request.setAttribute("unRendezVous", unRendezVous);
                request.getRequestDispatcher("ModifierTempsRendezVous.jsp").forward(request, response);
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
