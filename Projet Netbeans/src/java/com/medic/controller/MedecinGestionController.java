/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.Medecin;
import com.medic.service.MedecinService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class MedecinGestionController extends HttpServlet {
    Medecin medecin = null;
    MedecinService medecinService = new MedecinService();
     boolean retour = false;

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idMedecin = request.getParameter("idMedecin");
        String gestionAction = request.getParameter("gestionAction");
        String modifierMedecin = request.getParameter("modifierMedecin");
        
        if (idMedecin != null) {
            if(null != gestionAction) switch (gestionAction) {
                
                
                case "modifier": {
                    request.setAttribute("typeAction", gestionAction);
                    int medecinId = Integer.parseInt(request.getParameter("idMedecin"));
                    medecin = medecinService.chercherMedecinParId(medecinId);
                    //request.setAttribute("unMedecin", medecin);
                    //request.setAttribute("unMedecin", medecin);
                    request.setAttribute("unMedecin", medecin);
                    request.getRequestDispatcher("MedecinGestion.jsp").forward(request, response);
                    break;
                }
            
        
        
            }
        }
            if (modifierMedecin != null) {
                 medecin = medecinService.chercherMedecinParId(Integer.parseInt(modifierMedecin));
                  //int medecinId = Integer.parseInt(request.getParameter("idMedecin"));
                  //medecin = medecinService.chercherMedecinParId(medecinId);
           
            
                medecin.setFacturation(Float.parseFloat(request.getParameter("facturation")));
                request.setAttribute("unMedecin", medecin);
                //String message = "Le médecin " + medecin.getNom() + " " + medecin.getPrenom() + " à été modifié";
                //String message = "Le tarif du médecin " + medecin.getNom() + " " + medecin.getPrenom() + " à été modifié";
                medecinService.modifierJustMedecin(medecin);
                //request.setAttribute("message", message);
                request.getRequestDispatcher("Medecin.jsp").forward(request, response);
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
