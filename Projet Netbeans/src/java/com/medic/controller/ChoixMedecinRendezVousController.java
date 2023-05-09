/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.service.MedecinService;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hundl
 */
public class ChoixMedecinRendezVousController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        MedecinService medecinService = new MedecinService();

        String typeRecherche = request.getParameter("typeRecherche");
        if (typeRecherche != null) {
            if (typeRecherche.equals("prendreRendezVous")) {
                String medecinChoisi = request.getParameter("medecinChoisi");
                request.setAttribute("medecinChoisi", medecinChoisi);
                request.setAttribute("typeRecherche", typeRecherche);
                request.getRequestDispatcher("PriseRendezVous.jsp").forward(request, response);

            } else if (typeRecherche.equals("filtrerSpecialite")) {
                String nomSpecialite = request.getParameter("nomSpecialite");
                byte[] bytes = nomSpecialite.getBytes(StandardCharsets.ISO_8859_1);
                nomSpecialite = new String(bytes, StandardCharsets.UTF_8);
                request.setAttribute("listeMedecinRecherche", medecinService.chercherParSpecialite(nomSpecialite));
                request.getRequestDispatcher("RechercherMedecinRv.jsp").forward(request, response);

            } else if (typeRecherche.equals("filtrerGMF")) {
                int medecinGMF = Integer.parseInt(request.getParameter("medecinGMF"));
                request.setAttribute("listeMedecinRecherche", medecinService.chercherParClinique(medecinGMF));
                request.getRequestDispatcher("RechercherMedecinRv.jsp").forward(request, response);
            } else if (typeRecherche.equals("toutAfficher")) {   
                request.setAttribute("listeMedecinRecherche", medecinService.afficherLesMedecin());
                request.getRequestDispatcher("RechercherMedecinRv.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("PriseRendezVous.jsp").forward(request, response);
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
