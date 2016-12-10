/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionEmprunt;

import enitite.Abonnee;
import enitite.Emprunt;
import enitite.Film;
import enitite.Livre;
import enitite.Media;
import enitite.Musique;
import facades.AbonneeFacadeLocal;
import facades.EmpruntFacadeLocal;
import facades.FilmFacadeLocal;
import facades.LivreFacadeLocal;
import facades.MusiqueFacadeLocal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
public class RetourEmprunt extends HttpServlet {

    @EJB
    private EmpruntFacadeLocal empruntFacade;

    @EJB
    private AbonneeFacadeLocal abonneeFacade;

    @EJB
    private FilmFacadeLocal filmFacade;

    @EJB
    private MusiqueFacadeLocal musiqueFacade;

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

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sDateEmprunt = simpleDateFormat.format(new Date());
            Date dateRetour = simpleDateFormat.parse(sDateEmprunt);
            Emprunt emprunt;
            String type = request.getParameter("type");
            String username = request.getParameter("username");
            String titre = request.getParameter("titre");
            String auteur = request.getParameter("auteur");
            String etat = request.getParameter("etat");
            if (type == null || username == null || titre == null || auteur == null) {
                // redirection, accesss frauduleux
                request.setAttribute("message", "tantative frauduleuse");
                request.getRequestDispatcher("retourEmprunt.jsp").forward(request, response);
            }
            // test utilisateur
            Abonnee abonnee = abonneeFacade.find(username);
            if (abonnee == null) {
                request.setAttribute("message", "L'abonnee n'existe pas");
                request.getRequestDispatcher("retourEmprunt.jsp").forward(request, response);
                return;
            }
            Collection<Media> medias = abonnee.getMediaCollection();
            if (medias.isEmpty()) {
                request.setAttribute("message", "L'abonnee n'a aucun pret en cours");
                request.getRequestDispatcher("retourEmprunt.jsp").forward(request, response);
                return;
            }
            List<Film> films = new ArrayList<>();
            List<Musique> musiques = new ArrayList<>();
            List<Livre> livres = new ArrayList<>();
            Film film;
            Musique musique;
            Livre livre;
            for (Media m : medias) {
                if (filmFacade.find(m.getMediaId()) != null) {
                    films.add(filmFacade.find(m.getMediaId()));
                }
                if (musiqueFacade.find(m.getMediaId()) != null) {
                    musiques.add(musiqueFacade.find(m.getMediaId()));
                }
                if (livreFacade.find(m.getMediaId()) != null) {
                    livres.add(livreFacade.find(m.getMediaId()));
                }
            }
            film = new Film();
            musique = new Musique();
            livre = new Livre();
            switch (type) {
                case "film":
                    for (Film f : films) {
                        if (f.getTitre().equals(titre) && f.getRealisateur().equals(auteur) && f.getEmprunt()==1) {
                            film = f;
                            break;
                        }
                    }
                    if (film == null) {
                        //
                        request.setAttribute("message", "film non retrouvé parmi ceux de l'abonnee");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    emprunt = empruntFacade.findByAllInfo(username, film.getMediaId(), film.getDateDebut(), film.getDateFin());
                    film.setUserName(null);
                    film.setEmprunt(0);
                    film.setDateDebut(null);
                    film.setDateFin(null);
                    film.setEtat(etat);
                    emprunt.setDateRetour(dateRetour);
                    abonnee.getMediaCollection().remove((Media) film);
                    empruntFacade.edit(emprunt);
                    filmFacade.edit(film);
                    abonneeFacade.edit(abonnee);
                    request.setAttribute("message", "retour pris en compte");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
                    
                    case "musique":
                    for (Musique m : musiques) {
                        if (m.getTitre().equals(titre) && m.getArtiste().equals(auteur) && m.getEmprunt() == 1) {
                            musique = m;
                            break;
                        }
                    }
                    if (musique == null) {
                        //
                        request.setAttribute("message", "musique non retrouvé parmi ceux de l'abonnee");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    emprunt = empruntFacade.findByAllInfo(username, musique.getMediaId(), musique.getDateDebut(), musique.getDateFin());
                    musique.setUserName(null);
                    musique.setEmprunt(0);
                    musique.setDateDebut(null);
                    musique.setDateFin(null);
                    musique.setEtat(etat);
                    emprunt.setDateRetour(dateRetour);
                    abonnee.getMediaCollection().remove((Media) musique);
                    empruntFacade.edit(emprunt);
                    musiqueFacade.edit(musique);
                    abonneeFacade.edit(abonnee);
                    request.setAttribute("message", "retour pris en compte");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
                    
                    case "livre":
                    for (Livre l : livres) {
                        if (l.getTitre().equals(titre) && l.getAuteur().equals(auteur) && l.getEmprunt() == 1) {
                            livre = l;
                            break;
                        }
                    }
                    if (livre == null) {
                        request.setAttribute("message", "livre non retrouvé parmi ceux de l'abonnee");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    emprunt = empruntFacade.findByAllInfo(username, livre.getMediaId(), livre.getDateDebut(), livre.getDateFin());
                    livre.setUserName(null);
                    livre.setEmprunt(0);
                    livre.setDateDebut(null);
                    livre.setDateFin(null);
                    livre.setEtat(etat);
                    emprunt.setDateRetour(dateRetour);
                    abonnee.getMediaCollection().remove((Media) livre);
                    empruntFacade.edit(emprunt);
                    livreFacade.edit(livre);
                    abonneeFacade.edit(abonnee);
                    request.setAttribute("message", "retour pris en compte");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
                default:
                    request.setAttribute("message", "erreur inconnué");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
            }
        } catch (ParseException ex) {
            request.setAttribute("message", "Format de date inconnu. Bon format: yyyy-mm-dd");
            request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
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
