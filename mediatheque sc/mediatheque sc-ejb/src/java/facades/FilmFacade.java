/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Film;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author enjoy
 */
@Stateless
public class FilmFacade extends AbstractFacade<Film> implements FilmFacadeLocal {

    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmFacade() {
        super(Film.class);
    }

    @Override
    public Film findByTitreRealisateur(String titre, String realisateur) {
        String sql = "SELECT film.";
        String jpql = "SELECT film From Film film WHERE film.titre='" + titre + "' and film.realisateur ='" + realisateur + "'";
        Query query = em.createQuery(jpql);
        try {
            List<Film> films = query.getResultList();
            if (films.isEmpty()) {
                return null;
            }
            return films.get(0);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Film> findDistinctFilm() {
        //String jpql = "SELECT film From Film film,(SELECT DISTINCT(film.titre,film.realisateur) film.mediaId from Film film) film2 "
        //       + " WHERE film.mediaId = film2.mediaId";
        String sql = "SELECT DISTINCT realisateur,titre \n"
                + "    FROM FILM as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE realisateur is not null "
                + "";

        String jpql = "SELECT film From Film film";
        // on va envoyer une map film, count

        Query query = em.createNativeQuery(sql);
        String realisateur= "";
        String titre ="";
        
        List<Object []> reaTitre = query.getResultList();
        List<Film> films = new ArrayList<>();
        if(reaTitre == null){
            return null; // il y a pas de film dans la bd
        }
        for (Object o[] : reaTitre){
            realisateur = (String) o[0];
            titre = (String) o[1];
            films.add(findByTitreRealisateur(titre, realisateur));
            
        }
        return films;

    }

    

}
