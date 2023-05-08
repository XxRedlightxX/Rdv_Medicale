/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.RendezVous;
import com.medic.service.RendezVousService;
import java.io.IOException;
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
        String descriptionConsult = request.getParameter("descriptionConsult");
        String etape1 = request.getParameter("etape1");
        String ajouterRv = request.getParameter("ajouterRv");
        String consulter = request.getParameter("consulter");
        
        if(etape1!=null){
            request.setAttribute("idPatient", idPatient);
            request.setAttribute("idMedecin", idMedecin);
            request.setAttribute("dateRv", dateRv);
            request.setAttribute("heureRv", heureRv);
            request.setAttribute("raisonConsult", raisonConsult);
            request.setAttribute("descriptionConsult", descriptionConsult);
            
            request.getRequestDispatcher("ConfirmationRendezVous.jsp").forward(request, response);
        }
        
        if(ajouterRv!=null){
            unRendezVous = new RendezVous();
            unRendezVous.setIdRendezVous(dao.trouverLeIdMaxRendezVous()+1);
            unRendezVous.setIdPatientRv(Integer.parseInt(idPatient));
            unRendezVous.setIdMedecinRv(Integer.parseInt(idMedecin));
            unRendezVous.setDateRv(dateRv);
            unRendezVous.setHeureRv(heureRv);
            unRendezVous.setRaisonConsult(raisonConsult);
            unRendezVous.setDescriptionConsult(descriptionConsult);
            dao.ajouterRendezVous(unRendezVous);
            System.out.println(unRendezVous);
            request.setAttribute("reeee", unRendezVous);
            request.getRequestDispatcher("Patient.jsp").forward(request, response);
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
