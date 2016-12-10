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
import facades.MusiqueFacadeLocal;
import java.io.IOException;
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
public class EditerMedia extends HttpServlet {

    @EJB
    private LivreFacadeLocal livreFacade;

    @EJB
    private MusiqueFacadeLocal musiqueFacade;

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
        String edit = request.getParameter("edit");
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        if (edit == null) {
            // ce n'est pas une modification. on envoie sur le formulaire d'edition
            String type = request.getParameter("type");
            switch (type) {
                case "film":
                    Film film = filmFacade.findByTitreRealisateur(titre, auteur);
                    if (film == null) {
                        //tentative d'access frauduleuse 
                        response.sendRedirect("index.jsp");
                        return;
                    }
                    request.setAttribute("authorLabel", "realisateur");
                    request.setAttribute("authorName", auteur);
                    request.setAttribute("titre", titre);
                    request.setAttribute("type", "film");
                    request.setAttribute("annee", film.getAnneeProduction());
                    request.setAttribute("film", film);
                    request.getRequestDispatcher("editerMedia.jsp").forward(request, response);
                    return;
                case "musique":
                    Musique musique = musiqueFacade.findByTitreArtiste(titre, auteur);
                    if (musique == null) {
                        //tentative d'access frauduleuse 
                        response.sendRedirect("index.jsp");
                        return;
                    }
                    request.setAttribute("authorLabel", "artiste");
                    request.setAttribute("authorName", auteur);
                    request.setAttribute("titre", titre);
                    request.setAttribute("type", "musique");
                    request.setAttribute("annee", musique.getAnneeProduction());
                    request.setAttribute("musique", musique);
                    request.getRequestDispatcher("editerMedia.jsp").forward(request, response);
                    return;
                case "livre":
                    Livre livre = livreFacade.findByTitreAuteur(titre, auteur);
                    if (livre == null) {
                        //tentative d'access frauduleuse 
                        response.sendRedirect("index.jsp");
                        return;
                    }
                    request.setAttribute("authorLabel", "auteur");
                    request.setAttribute("authorName", auteur);
                    request.setAttribute("titre", titre);
                    request.setAttribute("type", "livre");
                    request.setAttribute("annee", livre.getAnneeProduction());
                    request.setAttribute("livre", livre);
                    request.getRequestDispatcher("editerMedia.jsp").forward(request, response);
                    return;
                default:
                    //tentative d'access frauduleuse 
                    response.sendRedirect("index.jsp");
                    return;
            }
        }
        switch (edit) {
            case "film":
                editerFilm(request, response);
                return;
            case "musique":
                editerMusique(request, response);
                return;
            case "livre":
                editerLivre(request, response);
                return;
            default:
                response.sendRedirect("index.jsp");
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

    private void editerFilm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre= request.getParameter("titre");
        String realisateur= request.getParameter("realisateur");
        int annee = new Integer(request.getParameter("annee"));
        String resume = request.getParameter("resume");
        List<Film> films = filmFacade.findAllCopyFilm(titre, realisateur);
        if(films == null){
            // une erreur est survenue
            response.sendRedirect("index.jsp");
            return;
        }
        for(Film film:films){
            film.setAnneeProduction(annee);
            film.setResume(resume);
            filmFacade.edit(film);
        }
        response.sendRedirect("AfficherUnMedia?mediaId="+films.get(0).getMediaId()+"");
    }

    private void editerMusique(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String artiste = request.getParameter("artiste");
        int annee = new Integer(request.getParameter("annee"));
        String morceaux = request.getParameter("morceaux");
        List<Musique> musiques = musiqueFacade.findAllCopyMusique(titre, artiste);
        if(musiques == null){
            response.sendRedirect("index.jsp");
            return;
        }
        for(Musique musique:musiques){
            musique.setAnneeProduction(annee);
            musique.setMorceaux(morceaux);
            musiqueFacade.edit(musique);
        }
        response.sendRedirect("AfficherUnMedia?mediaId="+musiques.get(0).getMediaId()+"");
    }

    private void editerLivre(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        int annee = new Integer(request.getParameter("annee"));
        String resume = request.getParameter("resume");
        List<Livre> livres = livreFacade.findAllCopyLivre(titre, auteur);
        if (livres == null) {
            response.sendRedirect("index.jsp");
            return;
        } else {
        }
        for (Livre livre : livres) {
            livre.setAnneeProduction(annee);
            livre.setResume(resume);
            livreFacade.edit(livre);
        }
        response.sendRedirect("AfficherUnMedia?mediaId="+livres.get(0).getMediaId()+"");
    }

}
