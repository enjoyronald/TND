/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionClient;

import enitite.Abonnee;
import enitite.Film;
import enitite.Livre;
import enitite.Media;
import enitite.Musique;
import facades.AbonneeFacadeLocal;
import facades.FilmFacadeLocal;
import facades.LivreFacadeLocal;
import facades.MusiqueFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

/**
 *
 * @author enjoy
 */
public class AfficherUnAbonnee extends HttpServlet {

    @EJB
    private MusiqueFacadeLocal musiqueFacade;

    @EJB
    private LivreFacadeLocal livreFacade;

    @EJB
    private FilmFacadeLocal filmFacade;

    @EJB
    private AbonneeFacadeLocal abonneeFacade;

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
        String abonneeId = request.getParameter("aId");
        if (abonneeId == null) {
            // générer une erreur due au mauvai argument
            response.sendError(SC_NOT_FOUND);
            return;
        }
        Abonnee abonnee = abonneeFacade.find(abonneeId);
        if (abonnee == null) {
            response.sendError(SC_NOT_FOUND);
            //response.sendRedirect("index.jsp");
            return;
        }
        List<Film> films = new ArrayList<>();
        List<Musique> musiques = new ArrayList<Musique>();
        List<Livre> livres = new ArrayList<Livre>();
        Film film;
        Livre livre;
        Musique musique;
        for (Media media : abonnee.getMediaCollection()) {
            film = filmFacade.find(media.getMediaId());
            livre = livreFacade.find(media.getMediaId());
            musique = musiqueFacade.find(media.getMediaId());
            if (film != null) {
                films.add(film);
            }
            if (livre != null) {
                livres.add(livre);
            }
            if (musique != null) {
                musiques.add(musique);
            }
        }
        request.setAttribute("abonnee", abonnee);
        request.setAttribute("films", films);
        request.setAttribute("livres", livres);
        request.setAttribute("musiques", musiques);
        request.getRequestDispatcher("afficherUnAbonnee.jsp").forward(request, response);
        return;
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
