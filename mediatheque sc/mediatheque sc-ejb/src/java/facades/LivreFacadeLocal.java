/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Livre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface LivreFacadeLocal {

    void create(Livre livre);

    void edit(Livre livre);

    void remove(Livre livre);

    Livre find(Object id);

    List<Livre> findAll();

    List<Livre> findRange(int[] range);

    int count();
    
    public Livre findByTitreAuteur(String titre, String auteur);
    
     public List<Livre> findDistinctLivre();
     
     public Livre findDispoByTitreAuteur(String titre, String auteur);
    
}
