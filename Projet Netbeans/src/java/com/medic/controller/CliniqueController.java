/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.medic.controller;

import com.medic.entities.Clinique;
import com.medic.service.CliniqueService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CliniqueController extends HttpServlet {

    private List<Clinique> listeClinique;
    Clinique clinique = null;
    boolean retour = false;
    CliniqueService cliniqueService = new CliniqueService();

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nomclinique = request.getParameter("nomclinique");
        String nom = request.getParameter("nom");
        String typeService = request.getParameter("typeService");
        //request.setAttribute("roles", cliniqueService.afficherLesCliniques());
        
        
        
         if ( nom != null && !nom.equals("")) {
//           if(!nom.equals("")){

            clinique = cliniqueService.chercherCliniqueParNom(nom);
            request.setAttribute("clinique", clinique);
            String listeCliniqu = " Profile de " + nom;
            request.setAttribute("listeClinique1", listeCliniqu);
            request.getRequestDispatcher("CliniqueInfo.jsp").forward(request, response);
//           }else {
//               System.out.println("Nom vide");
        }else {
            listeClinique = cliniqueService.afficherLesCliniques();
            request.setAttribute("listeClinique", listeClinique);
            request.getRequestDispatcher("CliniqueInfo.jsp").forward(request, response);
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
