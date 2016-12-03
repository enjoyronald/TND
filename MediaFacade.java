/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author enjoy
 */
@Stateless
public class MediaFacade extends AbstractFacade<Media> implements MediaFacadeLocal {

    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediaFacade() {
        super(Media.class);
    }
    
    @Override
    public boolean create(String titre, Integer annee_production,String format){
        String s = "INSERT INTO MEDIA (EMPRUNT,ETAT,TITRE,ANNEE_PRODUCTION,FORMAT)"
                + "Values (0,'NEUF','" + titre + "'," + annee_production + ",'" + format + "')";
        try{
            em.createNativeQuery(s).executeUpdate();
            em.flush();
            return true;
        }catch(Exception ex){
            return false;
        } 
    }
    
}
