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
public interface MediaFacadeLocal {

    void create(Media media);

    void edit(Media media);

    void remove(Media media);

    Media find(Object id);

    List<Media> findAll();

    List<Media> findRange(int[] range);

    int count();
    
    /**
     *
     * @param titre
     * @param annee_production
     * @param format
     * @return true if the media is created, false if not
     */
    public boolean create(String titre, Integer annee_production,String format);
    
}
