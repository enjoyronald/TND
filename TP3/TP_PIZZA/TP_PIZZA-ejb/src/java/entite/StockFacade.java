/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author enjoy
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeLocal {

    @PersistenceContext(unitName = "TP_PIZZA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }

    /**
     *
     * @param pizzaId
     * @param quantite
     */
    @Override
    public void create(String pizzaId, int quantite) {
        String s = "insert into stock(pizza_id,quantite) ";
        s = s + "values ('" + pizzaId + "'," + quantite + ")";
        em.createNativeQuery(s).executeUpdate();
    }

    @Override
    public void update(String pizzaId, int quantite) {
        String s = "update Stock "
                + "SET quantite =" + quantite + " "
                + "WHERE pizza_id= '" + pizzaId + "'";
        em.createNativeQuery(s).executeUpdate();
    }

    @Override
    public Stock findByPizzaId(String pizzaId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        String s = "select c from Stock c ";
        s = s + " WHERE c.pizzaId.pizzaId ='" + pizzaId + "'";
        Query query = em.createQuery(s);

        return (Stock) query.getSingleResult();

    }

}
