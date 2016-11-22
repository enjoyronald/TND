/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface AbonneeFacadeLocal {

    void create(Abonnee abonnee);

    void edit(Abonnee abonnee);

    void remove(Abonnee abonnee);

    Abonnee find(Object id);

    List<Abonnee> findAll();

    List<Abonnee> findRange(int[] range);

    int count();
    
}
