/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author enjoy
 */
@Stateless
public class PizzaFacade extends AbstractFacade<Pizza> implements PizzaFacadeLocal {

    @PersistenceContext(unitName = "TP_PIZZA_2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PizzaFacade() {
        super(Pizza.class);
    }
    
}
