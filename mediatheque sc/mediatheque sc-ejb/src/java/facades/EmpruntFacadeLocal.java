/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Emprunt;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface EmpruntFacadeLocal {
    void create(Emprunt emprunt);

    void edit(Emprunt emprunt);

    void remove(Emprunt emprunt);

    Emprunt find(Object id);

    List<Emprunt> findAll();

    List<Emprunt> findRange(int[] range);
    
    public Emprunt findByAllInfo(String userName,Integer mediaId,Date dateDebut,Date dateFin);

    int count();
}
