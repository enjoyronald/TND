/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Acteur;
import enitite.Film;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author enjoy
 */
public class FilmFacadeTest {
    
    public FilmFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of create method, of class FilmFacade.
     */
    @Test
    public void testCreate() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FilmFacadeLocal instance = (FilmFacadeLocal) container.getContext().lookup("java:global/classes/FilmFacade");
        ActeurFacadeLocal instanceA = (ActeurFacadeLocal)container.getContext().lookup("java:global/classes/ActeurFacade");
        System.out.println("create");
        Film entity = new Film();
        entity.setAnneeProduction(2009);
        entity.setRealisateur("James Cameroon 5");
        entity.setTitre("film james 5");
        entity.setEtat("NEUF");
        entity.setFormat("dvd");
        entity.setResume("Je resume le film de james 5");
        
        //Collection<Acteur> acteurs = new ArrayList();
        Acteur a = new Acteur("acteur1");
        //instanceA.create(a);
        //acteurs.add(a);
        //a.getFilmCollection().add(entity);
        entity.getActeurCollection().add(a);

        instance.create(entity);
        System.out.println(" l'objet acteur "+a.toString());

        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
