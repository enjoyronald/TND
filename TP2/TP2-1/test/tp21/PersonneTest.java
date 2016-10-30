/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp21;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
public class PersonneTest {

    public PersonneTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPersonne() {
        // TODO review the generated test code and remove the default call to fail.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2-1PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Personne pierre = new Personne("Pierre");

        et.begin();
        em.persist(pierre);
        et.commit();

        // créaton d'une requette 
        String textquery = "Select s FROM Personne s where s.nom =:nom";
        Query query = em.createQuery(textquery);
        query.setParameter("nom", "Pierre");
        List<Personne> qResult = query.getResultList();
        boolean expResult = true;
        boolean result = false;
        for (Personne p : qResult) {
            if (p.getNom().equals("Pierre")) {
                result = true;
            }
        }
        if (result != expResult) {
            fail(" erreur enregistrement Pierre");
        }
        // test changement nom
        et.begin();
        pierre.setNom("Changement");
        et.commit();
        textquery = "Select s FROM Personne s where s.nom =:nom";
        query = em.createQuery(textquery);
        query.setParameter("nom", "Changement");
        qResult = query.getResultList();
        expResult = true;
        result = false;
        Personne p2 = null;
        for (Personne p : qResult) {
            if (p.getNom().equals("Changement")) {
                result = true;
                p2=p;
            }
        }
        if (result != expResult) {
            fail(" erreur enregistrement Pierre");
        }
        
        //test suppression
        et.begin();
        em.remove(p2);
        et.commit();
    }

}
