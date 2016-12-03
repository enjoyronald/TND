/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Acteur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author enjoy
 */
@Stateless
public class ActeurFacade extends AbstractFacade<Acteur> implements ActeurFacadeLocal {

    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActeurFacade() {
        super(Acteur.class);
    }
    
    @Override
    public void create(Acteur acteur){
        Query query = em.createNamedQuery("Acteur.findByNomActeur");
        query.setParameter("nomActeur", acteur.getNomActeur());
        try{
            Acteur a = (Acteur)query.getSingleResult(); // l'acteur existe déjà on ne le crée pas
        }catch(Exception ex){
            getEntityManager().persist(acteur);
        }
    }
    
}
