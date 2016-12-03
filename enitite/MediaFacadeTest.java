/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
public class MediaFacadeTest {
    
    public MediaFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        Path to = Paths.get("build" + File.separator + "test" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "glassfish-resources.xml");
        Path from = Paths.get("build" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "META-INF" + File.separator + "glassfish-resources.xml");
        Files.createDirectories(to.getParent());
        BufferedWriter out = Files.newBufferedWriter(to, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        out.write("");
        out.close();
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        //addScopeGlassfish(to);

        to = Paths.get("build" + File.separator + "test" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "persistence.xml");
        from = Paths.get("build" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "persistence.xml");
        // on s'assure que le repertoire existe 
        Files.createDirectories(to.getParent());
        //on cree le fichier
        out = Files.newBufferedWriter(to, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        out.write("");
        out.close();
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        // add scope java:app to persistance
        //addScoptePersistence(to);
    }

    
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MediaFacadeLocal instance = (MediaFacadeLocal)container.getContext().lookup("java:global/classes/MediaFacade");
        List<Media> expResult = null;
        List<Media> result = instance.findAll();
        container.close();
        
    }

    @Test
    public void testCreate_3args() throws Exception {
        System.out.println("create");
        String titre = "harry potter";
        Integer annee_production = 2010;
        String format = "dvd";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MediaFacadeLocal instance = (MediaFacadeLocal)container.getContext().lookup("java:global/classes/MediaFacade");
        boolean test = instance.create(titre, annee_production, format);
        System.out.println("Valeur retourn par test : "+test);
        /*
        MediaFacade instance2 = new MediaFacade();
        EntityManager em = instance2.getEntityManager();
        EntityTransaction et = em.getTransaction();
        Media media = new Media();
        media.setEtat("NEUF");
        media.setTitre("media1");
        media.setAnneeProduction(2012);
        media.setFormat("DVD");
        
        et.begin();
        em.persist(media);
        et.commit();
        */
        container.close();
    }

    
}
