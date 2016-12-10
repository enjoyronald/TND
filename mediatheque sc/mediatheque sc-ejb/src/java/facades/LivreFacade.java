/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Livre;
import java.util.ArrayList;
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
   
    public Livre findDispoByTitreAuteur(String titre, String auteur) {
        String jpql = "SELECT livre From Livre livre WHERE livre.titre='" + titre + "' and livre.auteur ='" + auteur + "'";
        Query query = em.createQuery(jpql);
        try {
            List<Livre> livres = query.getResultList();
            if (livres.isEmpty()) {
                return null;
            }
            for(Livre livre : livres){
                if(livre.getEmprunt() == 0){
                    return livre;
                }
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @Override
    public List<Livre> findAllCopyLivre(String titre, String auteur) {
        String jpql = "SELECT livre From Livre livre WHERE livre.titre='" + titre + "' and livre.auteur ='" + auteur + "'";
        Query query = em.createQuery(jpql);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Livre> findDistinctLivre() {
        String sql = "SELECT DISTINCT auteur,titre \n"
                + "    FROM LIVRE as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE auteur is not null "
                + "";

        Query query = em.createNativeQuery(sql);
        String auteur = "";
        String titre = "";

        List<Object[]> autTitre = query.getResultList();
        List<Livre> livres = new ArrayList<>();
        if (autTitre == null) {
            return null; // il y a pas de livre dans la bd
        }
        for (Object o[] : autTitre) {
            auteur = (String) o[0];
            titre = (String) o[1];
            livres.add(findByTitreAuteur(titre, auteur));

        }
        return livres;
    }

    @Override
    public List<Livre> findByTitre(String titre) {
        String sql = "SELECT DISTINCT auteur,titre \n"
                + "    FROM LIVRE as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE titre= '"+titre+"' "
                + "";

        Query query = em.createNativeQuery(sql);
        String auteur = "";

        List<Object[]> autTitre = query.getResultList();
        List<Livre> livres = new ArrayList<>();
        if (autTitre == null) {
            return null; // il y a pas de livre dans la bd
        }
        for (Object o[] : autTitre) {
            auteur = (String) o[0];
            titre = (String) o[1];
            livres.add(findByTitreAuteur(titre, auteur));

        }
        return livres;
    }
    
    @Override
    public List<Livre> findByAuteur(String auteur) {
        String sql = "SELECT DISTINCT auteur,titre \n"
                + "    FROM LIVRE as f NATURAL JOIN MEDIA as m\n"
                + "    WHERE auteur = '"+auteur+"' "
                + "";

        Query query = em.createNativeQuery(sql);
        String titre = "";

        List<Object[]> autTitre = query.getResultList();
        List<Livre> livres = new ArrayList<>();
        if (autTitre == null) {
            return null; // il y a pas de livre dans la bd
        }
        for (Object o[] : autTitre) {
            auteur = (String) o[0];
            titre = (String) o[1];
            livres.add(findByTitreAuteur(titre, auteur));

        }
        return livres;
    }
}
