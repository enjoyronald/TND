/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionMedia;

import enitite.Livre;
import facades.LivreFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enjoy
 */
public class AjoutLivre extends HttpServlet {

    @EJB
    private LivreFacadeLocal livreFacade;

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
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        Livre livre = livreFacade.findByTitreAuteur(titre, auteur);
        if(livre == null){
            //le livre n'existe pas, il faut le créer entierement
            return;
        }
        Livre toAdd = new Livre();
        toAdd.setTitre(titre);
        toAdd.setAnneeProduction(livre.getAnneeProduction());
        toAdd.setEmprunt(0);
        toAdd.setResume(livre.getResume());
        toAdd.setAuteur(auteur);
        livreFacade.create(toAdd);
        response.sendRedirect("/WEB-INF/secureJSP/AjoutNouveauLivre.jsp?titre="+titre+"&auteur="+auteur+""); // on va créer un pop up pour dire c'est bon
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
