/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.DispoMedecin;
import com.medic.service.DispoMedecinService;
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
public class DispoMedecinController extends HttpServlet {
    DispoMedecinService dispoDao = new DispoMedecinService();
    DispoMedecin uneDispo = new DispoMedecin();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        uneDispo.setIdDispoMedecin(dispoDao.trouverLeIdMaxDispoMedecin()+1);
        uneDispo.setIdMedecinDispo(Integer.parseInt(request.getParameter("idMedecinDispo")));
        uneDispo.setDateDispo(request.getParameter("date"));
        uneDispo.setHeureDispoDebut(request.getParameter("heureD"));
        uneDispo.setHeureDispoFin(request.getParameter("heureF"));
        DispoMedecin dispoExistante = dispoDao.verifierExistanceDispoMedecin(uneDispo.getIdDispoMedecin(),uneDispo.getDateDispo());
        if (dispoExistante != null){
            request.setAttribute("invalide", "Vous avez déja établi des créneaux pour cette période veuillez choisir modifier");
            request.getRequestDispatcher("Medecin.jsp").include(request, response);
        } else {
            dispoDao.ajouterDispoMedecin(uneDispo);
            request.getRequestDispatcher("Medecin.jsp").include(request, response);
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
