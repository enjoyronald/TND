/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Musique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface MusiqueFacadeLocal {

    void create(Musique musique);

    void edit(Musique musique);

    void remove(Musique musique);

    Musique find(Object id);

    List<Musique> findAll();

    List<Musique> findRange(int[] range);

    int count();
    
    public Musique findByTitreArtiste(String titre, String artiste);
    
    public List<Musique> findDistinctMusique();
    
}
