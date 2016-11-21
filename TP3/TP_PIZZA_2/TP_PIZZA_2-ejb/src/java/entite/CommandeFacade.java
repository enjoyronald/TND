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
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {

    @PersistenceContext(unitName = "TP_PIZZA_2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    /**
     *
     * @param pizzaId
     * @param quantite
     * @param total
     * @param email
     */
    @Override
    public void create(String pizzaId, int quantite, int total, String email) {
        String s = "insert into commande(pizza_id,quantite,total,email) ";
        s = s + "values ('" + pizzaId + "'," + quantite + ",";
        s = s + total + ",'" + email + "')";
        em.createNativeQuery(s).executeUpdate();
        // mise a jour de la quantité du stock de pizza
        // recuperation du stock : 
        
    }
}
