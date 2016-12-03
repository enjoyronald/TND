/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Abonnement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author enjoy
 */
@Stateless
public class AbonnementFacade extends AbstractFacade<Abonnement> implements AbonnementFacadeLocal {

    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonnementFacade() {
        super(Abonnement.class);
    }
    
}
