/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Livre;
import enitite.Musique;
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
public class MusiqueFacade extends AbstractFacade<Musique> implements MusiqueFacadeLocal {

    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusiqueFacade() {
        super(Musique.class);
    }

    @Override
    public Musique findByTitreArtiste(String titre, String artiste) {
        String jpql = "SELECT musique From Musique musique WHERE musique.titre='" + titre + "' and musique.artiste ='" + artiste + "'";
        Query query = em.createQuery(jpql);
        try {
            List<Musique> musiques = query.getResultList();
            if (musiques.isEmpty()) {
                return null;
            }
            return musiques.get(0);
        } catch (Exception ex) {
            return null;
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Musique> findDistinctMusique() {
        //String jpql = "SELECT film From Film film,(SELECT DISTINCT(film.titre,film.realisateur) film.mediaId from Film film) film2 "
        //       + " WHERE film.mediaId = film2.mediaId";
        String sql = "SELECT DISTINCT artiste,titre \n"
                + "    FROM MUSIQUE as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE artiste is not null "
                + "";

        String jpql = "SELECT livre From Livre livre";
        // on va envoyer une map film, count

        Query query = em.createNativeQuery(sql);
        String artiste = "";
        String titre = "";

        List<Object[]> autTitre = query.getResultList();
        List<Musique> musiques = new ArrayList<>();
        if (autTitre == null) {
            return null; // il y a pas de livre dans la bd
        }
        for (Object o[] : autTitre) {
            artiste = (String) o[0];
            titre = (String) o[1];
            musiques.add(findByTitreArtiste(titre, artiste));

        }
        return musiques;

    }
}
