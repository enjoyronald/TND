/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Film;
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
}
