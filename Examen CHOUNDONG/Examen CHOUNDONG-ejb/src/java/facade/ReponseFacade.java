/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Reponse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author enjoy
 */
@Stateless
public class ReponseFacade extends AbstractFacade<Reponse> implements ReponseFacadeLocal {

    @PersistenceContext(unitName = "Examen_CHOUNDONG-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReponseFacade() {
        super(Reponse.class);
    }
    
}
