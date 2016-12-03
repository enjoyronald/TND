/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Livre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author enjoy
 */
@Stateless
public class LivreFacade extends AbstractFacade<Livre> implements LivreFacadeLocal {

    @PersistenceContext(unitName = "mediatheque_sc-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivreFacade() {
        super(Livre.class);
    }
    
   public Livre findByTitreAuteur(String titre, String auteur){
       String jpql = "SELECT livre From Livre livre WHERE livre.titre='"+titre+"' and livre.auteur ='"+auteur+"'";
       Query query=em.createQuery(jpql);
       try{
           List<Livre> livres = query.getResultList();
           if(livres.isEmpty()){
               return null;
           }
           return livres.get(0);
       }catch(Exception ex){
           return null;
       }
   }
    
}
