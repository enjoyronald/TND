/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Reponse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface ReponseFacadeLocal {

    void create(Reponse reponse);

    void edit(Reponse reponse);

    void remove(Reponse reponse);

    Reponse find(Object id);

    List<Reponse> findAll();

    List<Reponse> findRange(int[] range);

    int count();
    
}
