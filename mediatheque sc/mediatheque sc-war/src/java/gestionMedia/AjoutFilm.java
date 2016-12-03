/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionMedia;

import enitite.Film;
import facades.FilmFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enjoy
 */
public class AjoutFilm extends HttpServlet {

    @EJB
    private FilmFacadeLocal filmFacade;

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
        String realisateur = request.getParameter("realisateur");
        String format = request.getParameter("format");
        Film film = filmFacade.findByTitreRealisateur(titre, realisateur);
        if (film == null) {
            //la film n'existe pas, il faut la créer entierement
            response.sendRedirect("ajouterNouveauMedia.jsp?titre=" + titre + "&realisateur=" + realisateur + "&media=film" +"&format="+format); // on va créer un pop up pour dire c'est bon
            return;
        }
        Film toAdd = new Film();
        toAdd.setTitre(titre);
        toAdd.setFormat(format);
        toAdd.setAnneeProduction(film.getAnneeProduction());
        toAdd.setEmprunt(0);
        toAdd.setResume(film.getResume());
        toAdd.setRealisateur(film.getRealisateur());
        toAdd.setActeurCollection(film.getActeurCollection());
        filmFacade.create(toAdd);
        response.sendRedirect("index.jsp"); // on va créer un pop up pour dire c'est bon

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
