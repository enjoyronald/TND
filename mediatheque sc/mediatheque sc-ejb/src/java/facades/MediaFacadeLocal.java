/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Media;
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
    
}
