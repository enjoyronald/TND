/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionMedia;

import enitite.Film;
import enitite.Livre;
import enitite.Musique;
import facades.FilmFacadeLocal;
import facades.LivreFacadeLocal;
import facades.MediaFacadeLocal;
import facades.MusiqueFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AfficherUnMedia extends HttpServlet {

    @EJB
    private FilmFacadeLocal filmFacade;

    @EJB
    private LivreFacadeLocal livreFacade;

    @EJB
    private MusiqueFacadeLocal musiqueFacade;

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
        String sId = request.getParameter("mediaId");
        if (sId == null) {
            // générer une erreur due au mauvai argument
            response.sendError(SC_NOT_FOUND);
            return;
        }
        int mediaId = new Integer(sId);
        Film film = filmFacade.find(mediaId);
        Musique musique = musiqueFacade.find(mediaId);
        Livre livre = livreFacade.find(mediaId);
        if (film == null && musique == null && livre == null) {
            // on redirige vers la page d'acceuil, on envoie un ressource not found
            response.sendError(SC_NOT_FOUND);
            return;
        }
        if (film != null) {
            request.setAttribute("type", "film");
            request.setAttribute("film", film); // on recupère tous les pret en cours pour l'admin
            List<Film> films = filmFacade.findAllCopyFilm(film.getTitre(), film.getRealisateur());
            request.setAttribute("copies", films);
            request.getRequestDispatcher("afficherUnMedia.jsp").forward(request, response);
            return;
        } else if (livre != null) {
            request.setAttribute("type", "livre");
            request.setAttribute("livre", livre);
            List<Livre> livres = livreFacade.findAllCopyLivre(livre.getTitre(), livre.getAuteur());
            request.setAttribute("copies", livres);
            request.getRequestDispatcher("afficherUnMedia.jsp").forward(request, response);
            return;
        } else if (musique != null) {
            request.setAttribute("type", "musique");
            request.setAttribute("musique", musique);
            List<Musique> musiques = musiqueFacade.findAllCopyMusique(musique.getTitre(), musique.getArtiste());
            request.setAttribute("copies", musiques);
            request.getRequestDispatcher("afficherUnMedia.jsp").forward(request, response);
            return;
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
