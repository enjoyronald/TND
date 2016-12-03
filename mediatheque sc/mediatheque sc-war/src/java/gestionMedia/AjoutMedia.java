/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionMedia;

import enitite.Acteur;
import enitite.Film;
import enitite.Livre;
import enitite.Musique;
import facades.ActeurFacadeLocal;
import facades.FilmFacadeLocal;
import facades.LivreFacadeLocal;
import facades.MediaFacadeLocal;
import facades.MusiqueFacadeLocal;
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
public class AjoutMedia extends HttpServlet {

    @EJB
    private ActeurFacadeLocal acteurFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        String nouveau = request.getParameter("nouveau"); //si l'utilisateur à completement rentré les info d'un media
        if (nouveau == null) {
            String type = request.getParameter("type");
            switch (type) {
                case "film":
                    ajouterFilm(request, response);
                    break;
                case "musique":
                    ajouterMusique(request, response);
                    break;
                case "livre":
                    ajouterLivre(request, response);
                    break;
                default: 
                ;
            }
        }else{
            switch (nouveau) {
                case "film":
                    ajouterNewFilm(request, response);
                    break;
                case "musique":
                    ajouterNewMusique(request, response);
                    break;
                case "livre":
                    ajouterNewLivre(request, response);
                    break;
                default: 
                ;
            }
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

    private void ajouterFilm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titre = request.getParameter("titre");
        String realisateur = request.getParameter("realisateur");
        String format = request.getParameter("format");
        Film film = filmFacade.findByTitreRealisateur(titre, realisateur);
        if (film == null) {
            //la film n'existe pas, il faut la créer entierement
            request.setAttribute("authorLabel", "realisateur");
            request.setAttribute("authorName", realisateur);
            request.setAttribute("titre", titre);
            request.setAttribute("format", format);
            request.setAttribute("type", "film");
            request.getRequestDispatcher("ajouterNouveauMedia.jsp").forward(request, response);
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

    private void ajouterMusique(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String titre = request.getParameter("titre");
        String artiste = request.getParameter("artiste");
        String format = request.getParameter("format");
        Musique musique = musiqueFacade.findByTitreArtiste(titre, artiste);
        if (musique == null) {
            //la musique n'existe pas, il faut la créer entierement
            request.setAttribute("authorLabel", "artiste");
            request.setAttribute("authorName", artiste);
            request.setAttribute("titre", titre);
            request.setAttribute("format", format);
            request.setAttribute("type", "musique");
            request.getRequestDispatcher("ajouterNouveauMedia.jsp").forward(request, response);
            return;
        }
        Musique toAdd = new Musique();
        toAdd.setTitre(titre);
        toAdd.setFormat(format);
        toAdd.setAnneeProduction(musique.getAnneeProduction());
        toAdd.setEmprunt(0);
        toAdd.setMorceaux(musique.getMorceaux());
        toAdd.setArtiste(musique.getArtiste());
        musiqueFacade.create(toAdd);
        response.sendRedirect("index.jsp"); // on va créer un pop up pour dire c'est bon
    }

    private void ajouterLivre(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        Livre livre = livreFacade.findByTitreAuteur(titre, auteur);
        if (livre == null) {
            //le livre n'existe pas, il faut le créer entierement
            request.setAttribute("authorLabel", "auteur");
            request.setAttribute("authorName", auteur);
            request.setAttribute("titre", titre);
            request.setAttribute("type", "livre");
            request.getRequestDispatcher("ajouterNouveauMedia.jsp").forward(request, response);
            return;
        }
        Livre toAdd = new Livre();
        toAdd.setTitre(titre);
        toAdd.setAnneeProduction(livre.getAnneeProduction());
        toAdd.setEmprunt(0);
        toAdd.setResume(livre.getResume());
        toAdd.setAuteur(auteur);
        livreFacade.create(toAdd);
        response.sendRedirect("index.jsp"); // on va créer un pop up pour dire c'est bon
    }

    private void ajouterNewFilm(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Film film= new Film();
    film.setTitre(request.getParameter("titre"));
    film.setRealisateur(request.getParameter("realisateur"));
    film.setAnneeProduction(new Integer(request.getParameter("annee")));
    film.setEmprunt(0);
    film.setEtat(request.getParameter("etat"));
    film.setFormat(request.getParameter("format"));
    film.setResume(request.getParameter("resume"));
    String acteurs[] = request.getParameterValues("acteurs[]");
    Acteur acteur;
    for(String a : acteurs){
        acteur = new Acteur();
        acteur.setNomActeur(a);
        acteurFacade.create(acteur);
        film.getActeurCollection().add(acteur);
    }
    filmFacade.create(film);
    response.sendRedirect("index.jsp");
    }

    private void ajouterNewMusique(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Musique musique = new Musique();
        musique.setTitre(request.getParameter("titre"));
        musique.setArtiste(request.getParameter("artiste"));
        musique.setAnneeProduction(new Integer(request.getParameter("annee")));
        musique.setAnneeProduction(0);
        musique.setEtat(request.getParameter("etat"));
        musique.setFormat(request.getParameter("format"));
        musique.setMorceaux(request.getParameter("morceaux"));
        musiqueFacade.create(musique);
        response.sendRedirect("index.jsp");
    }

    private void ajouterNewLivre(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Livre livre = new Livre();
        livre.setTitre(request.getParameter("titre"));
        livre.setAnneeProduction(new Integer(request.getParameter("annee")));
        livre.setAuteur(request.getParameter("auteur"));
        livre.setEtat(request.getParameter("etat"));
        livre.setResume(request.getParameter("resume"));
        livre.setEmprunt(0);
        livreFacade.create(livre);
        response.sendRedirect("index.jsp");
    }

}
