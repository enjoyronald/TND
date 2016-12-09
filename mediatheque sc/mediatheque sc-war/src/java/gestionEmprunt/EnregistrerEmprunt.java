/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionEmprunt;

import enitite.Abonnee;
import enitite.Film;
import enitite.Livre;
import enitite.Musique;
import facades.AbonneeFacadeLocal;
import facades.FilmFacadeLocal;
import facades.LivreFacadeLocal;
import facades.MusiqueFacadeLocal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enjoy
 */
public class EnregistrerEmprunt extends HttpServlet {

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
        Date dateRetour;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sDateEmprunt = simpleDateFormat.format(new Date());
            Date dateEmprunt = simpleDateFormat.parse(sDateEmprunt);
            String type = request.getParameter("type");
            String username = request.getParameter("username");
            String titre = request.getParameter("titre");
            String auteur = request.getParameter("auteur");
            String sDateR = request.getParameter("dateR");
            if (type == null || username == null || titre == null || auteur == null || sDateR == null) {
                // redirection, accesss frauduleux
                request.setAttribute("message", "tantative frauduleuse");
                request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
            }
            // test utilisateur
            Abonnee abonnee = abonneeFacade.find(username);
            if (abonnee == null) {
                request.setAttribute("message", "L'abonnee n'existe pas");
                request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                return;
            }
            switch (type) {
                case "livre":
                    Livre livre = livreFacade.findDispoByTitreAuteur(titre, auteur);
                    if (livre == null) {
                        request.setAttribute("message", "ce livre n'est plus disponible");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    dateRetour = simpleDateFormat.parse(sDateR);
                    if(dateRetour.before(dateEmprunt)){
                        request.setAttribute("message", "Date emprunt avant date retour");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    livre.setUserName(abonnee);
                    livre.setEmprunt(1);
                    livre.setDateDebut(dateEmprunt);
                    livre.setDateFin(dateRetour);
                    abonnee.getMediaCollection().add(livre);
                    livreFacade.edit(livre);
                    abonneeFacade.edit(abonnee);
                    request.setAttribute("message", "emprunt pris en compte");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
                case "film":
                    Film film = filmFacade.findDispoByTitreRealisateur(titre, auteur);
                    if (film == null) {
                        request.setAttribute("message", "ce film n'est plus disponible");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    dateRetour = simpleDateFormat.parse(sDateR);
                    if (dateRetour.before(dateEmprunt)) {
                        request.setAttribute("message", "Date emprunt avant date retour");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    film.setUserName(abonnee);
                    film.setEmprunt(1);
                    film.setDateDebut(dateEmprunt);
                    film.setDateFin(dateRetour);
                    abonnee.getMediaCollection().add(film);
                    filmFacade.edit(film);
                    abonneeFacade.edit(abonnee);
                    request.setAttribute("message", "emprunt pris en compte");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
                case "musique":
                    Musique musique = musiqueFacade.findDispoByTitreArtiste(titre, auteur);
                    if (musique == null) {
                        request.setAttribute("message", "cet album n'est plus disponible");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    dateRetour = simpleDateFormat.parse(sDateR);
                    if (dateRetour.before(dateEmprunt)) {
                        request.setAttribute("message", "Date emprunt avant date retour");
                        request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                        return;
                    }
                    musique.setUserName(abonnee);
                    musique.setEmprunt(1);
                    musique.setDateDebut(dateEmprunt);
                    musique.setDateFin(dateRetour);
                    abonnee.getMediaCollection().add(musique);
                    musiqueFacade.edit(musique);
                    abonneeFacade.edit(abonnee);
                    request.setAttribute("message", "emprunt pris en compte");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
                default:
                    request.setAttribute("message", "type de media inconnu");
                    request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
                    return;
            }
        } catch (ParseException ex) {
            request.setAttribute("message", "Format de date inconnu. Bon format: yyyy-mm-dd");
            request.getRequestDispatcher("enregistrerEmprunt.jsp").forward(request, response);
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
