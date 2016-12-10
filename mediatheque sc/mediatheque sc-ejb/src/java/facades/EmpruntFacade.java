/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Emprunt;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author enjoy
 */
@Stateless
public class EmpruntFacade extends AbstractFacade<Emprunt> implements EmpruntFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public EmpruntFacade() {
        super(Emprunt.class);
    }
    
    public Emprunt findByAllInfo(String userName,Integer mediaId,Date dateDebut,Date dateFin){
        java.sql.Date sqlDateDebut = new java.sql.Date(dateDebut.getTime());
        java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());
        String sql ="Select emprunt_id From EMPRUNT  "
                + "  WHERE user_name='"+userName+"' "
                + "  and media_id="+mediaId+" "
                + "  and date_debut='"+sqlDateDebut+"' "
                + "  and date_fin='"+sqlDateFin+"'";
        
        int id=(int) em.createNativeQuery(sql).getSingleResult();
        return this.find(id);
    }
}
