/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recherche;

import enitite.Film;
import enitite.Livre;
import enitite.Musique;
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

/**
 *
 * @author enjoy
 */
public class Recherche extends HttpServlet {

    @EJB
    private MusiqueFacadeLocal musiqueFacade;

    @EJB
    private LivreFacadeLocal livreFacade;

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
        String search = request.getParameter("search");
        String searchType = request.getParameter("searchType");
        if (search == null || searchType == null) {
            // recherche incorrecte
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        List<Film> films;
        List<Musique> musiques;
        List<Livre> livres;
        switch (searchType) {
            case "film":
                films = filmFacade.findByTitre(search);
                request.setAttribute("type", "film");
                request.setAttribute("films", films);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            case "musique":
                musiques = musiqueFacade.findByTitre(search);
                request.setAttribute("type", "musique");
                request.setAttribute("musiques", musiques);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            case "livre":
                livres = livreFacade.findByTitre(search);
                request.setAttribute("type", "livre");
                request.setAttribute("livres", livres);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            case "realisateur":
                films = filmFacade.findByRealisateur(search);
                request.setAttribute("type", "film");
                request.setAttribute("films", films);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            case "artiste":
                musiques = musiqueFacade.findByArtiste(search);
                request.setAttribute("type", "musique");
                request.setAttribute("musiques", musiques);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            case "auteur":
                livres = livreFacade.findByAuteur(search);
                request.setAttribute("type", "livre");
                request.setAttribute("livres", livres);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            case "acteur":
                films = filmFacade.findByActeur(search);
                request.setAttribute("type", "film");
                request.setAttribute("films", films);
                request.getRequestDispatcher("rechercheResultats.jsp").forward(request, response);
                return;
            default:
                return;
        }
    }
    
    void distinctMusique(List<Musique> musiques){

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
