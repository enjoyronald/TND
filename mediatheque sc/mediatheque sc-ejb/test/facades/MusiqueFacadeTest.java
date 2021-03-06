/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Musique;
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
public class MusiqueFacadeTest {
    
    public MusiqueFacadeTest() {
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

    /**
     * Test of create method, of class MusiqueFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Musique entity = new Musique();
        entity.setAnneeProduction(2012);
        entity.setArtiste("blabla");
        entity.setTitre("musique1");
        entity.setAnneeProduction(1992);
        entity.setFormat("DVD");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MusiqueFacadeLocal instance = (MusiqueFacadeLocal)container.getContext().lookup("java:global/classes/MusiqueFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
