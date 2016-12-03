/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Livre;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author enjoy
 */
public class LivreFacadeTest {
    
    public LivreFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
  
    /**
     * Test of findByTitreAuteur method, of class LivreFacade.
     */
    @Test
    public void testFindByTitreAuteur() throws Exception {
        System.out.println("findByTitreAuteur");
        String titre = "titre1";
        String auteur = "auteur10";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LivreFacadeLocal instance = (LivreFacadeLocal)container.getContext().lookup("java:global/classes/LivreFacade");
        Livre livre = new Livre();
        livre.setAnneeProduction(2008);
        livre.setAuteur("auteur1");
        livre.setTitre("titre");
        livre.setResume("Resume moi livre 1");
        instance.create(livre);
        Livre result = instance.findByTitreAuteur(titre, auteur);
        if(result==null){
            System.out.println("aucun livre");
        }else{
            System.out.println(" Auteur: "+result.getAuteur()+" ");
        }
        
        container.close();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
