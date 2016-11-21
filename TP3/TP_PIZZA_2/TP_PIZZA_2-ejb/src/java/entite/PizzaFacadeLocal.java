/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface PizzaFacadeLocal {

    void create(Pizza pizza);

    void edit(Pizza pizza);

    void remove(Pizza pizza);

    Pizza find(Object id);

    List<Pizza> findAll();

    List<Pizza> findRange(int[] range);

    int count();
    
}
