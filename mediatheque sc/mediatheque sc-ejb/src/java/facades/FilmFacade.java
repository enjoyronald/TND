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
        String jpql = "SELECT film From Film film WHERE upper(film.titre)=upper('" + titre + "') and upper(film.realisateur) =upper('" + realisateur + "')";
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

    @Override
    public Film findDispoByTitreRealisateur(String titre, String realisateur) {
        String sql = "SELECT film.";
        String jpql = "SELECT film From Film film WHERE upper(film.titre)=upper('" + titre + "') and upper(film.realisateur) =upper('" + realisateur + "')";
        Query query = em.createQuery(jpql);
        try {
            List<Film> films = query.getResultList();
            if (films.isEmpty()) {
                return null;
            }
            for (Film film : films) {
                if (film.getEmprunt() == 0) {
                    return film;
                }
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Film> findAllCopyFilm(String titre, String realisateur) {
        String jpql = "SELECT film From Film film WHERE upper(film.titre)=upper('" + titre + "') and upper(film.realisateur) =upper('" + realisateur + "')";
        Query query = em.createQuery(jpql);
        try {
            return query.getResultList();
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
        String realisateur = "";
        String titre = "";

        List<Object[]> reaTitre = query.getResultList();
        List<Film> films = new ArrayList<>();
        if (reaTitre == null) {
            return null; // il y a pas de film dans la bd
        }
        for (Object o[] : reaTitre) {
            realisateur = (String) o[0];
            titre = (String) o[1];
            films.add(findByTitreRealisateur(titre, realisateur));

        }
        return films;
    }

    @Override
    public List<Film> findByTitre(String titre) {
        String sql = "SELECT DISTINCT realisateur,titre \n"
                + "    FROM FILM as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE upper(titre)=upper('"+titre+"') "
                + "";

        Query query = em.createNativeQuery(sql);
        String realisateur = "";

        List<Object[]> reaTitre = query.getResultList();
        List<Film> films = new ArrayList<>();
        if (reaTitre == null) {
            return null; // il y a pas de film dans la bd
        }
        for (Object o[] : reaTitre) {
            realisateur = (String) o[0];
            titre = (String) o[1];
            films.add(findByTitreRealisateur(titre, realisateur));

        }
        return films;
    }
    
    @Override
    public List<Film> findByRealisateur(String realisateur) {
        String sql = "SELECT DISTINCT realisateur,titre \n"
                + "    FROM FILM as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE upper(realisateur) = upper('"+realisateur+"') "
                + "";

        Query query = em.createNativeQuery(sql);
        String titre = "";

        List<Object[]> reaTitre = query.getResultList();
        List<Film> films = new ArrayList<>();
        if (reaTitre == null) {
            return null; // il y a pas de film dans la bd
        }
        for (Object o[] : reaTitre) {
            realisateur = (String) o[0];
            titre = (String) o[1];
            films.add(findByTitreRealisateur(titre, realisateur));

        }
        return films;
    }
    
    public List<Film> findByActeur(String acteur) {
        String sql = "SELECT DISTINCT realisateur,titre "
                + "    FROM FILM as f,MEDIA as m,FILM_ACTEUR as fa,Acteur as a "
                + "    WHERE f.media_id= m.media_id"
                + "    and fa.film_id = f.media_id"
                + "    and fa.nom_acteur=a.nom_acteur"
                + "    and upper(a.nom_acteur) = upper('" + acteur + "') "
                + "";
        Query query = em.createNativeQuery(sql);
        String realisateur = "";
        String titre = "";

        List<Object[]> reaTitre = query.getResultList();
        List<Film> films = new ArrayList<>();
        if (reaTitre == null) {
            return null; // il y a pas de film dans la bd
        }
        for (Object o[] : reaTitre) {
            realisateur = (String) o[0];
            titre = (String) o[1];
            films.add(findByTitreRealisateur(titre, realisateur));

        }
        return films;
    }
    /*
    String sql ="select film_id as mediaId from FILM_ACTEUR"
                + " where nom_acteur ='"+acteur+"'";
        Query query = em.createNativeQuery(sql);
        
        List<Integer> lMediaId= query.getResultList();
        List<Film> films = new ArrayList<>();
        if(lMediaId == null){
            return null;
        }
        for(int mediaId : lMediaId){
            films.add(this.find(mediaId));
        }
        return films;
    */
}
