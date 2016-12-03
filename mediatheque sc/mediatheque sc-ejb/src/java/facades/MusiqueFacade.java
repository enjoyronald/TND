/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Livre;
import enitite.Musique;
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
}
