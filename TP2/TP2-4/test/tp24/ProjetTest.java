/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp24;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author enjoy
 */
public class ProjetTest {

    public ProjetTest() {
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
    public void testParticipation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2-4PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Departement d1 = new Departement("dep1", "france");
        Departement d2 = new Departement("dep2", "italie");

        Employe c1 = new Employe("chef1", null, d1);
        Employe c2 = new Employe("chef2", c1, d2);
        Employe c3 = new Employe("chef3", null, d2);
        Employe e1 = new Employe("emp1", null, d1);
        Employe e2 = new Employe("emp2", c1, d2);
        Employe e3 = new Employe("emp3", c1, d2);
        Employe e4 = new Employe("emp4", null, d1);
        Employe e5 = new Employe("emp5", c3, d2);
        Employe e6 = new Employe("emp6", c2, d1);
        Employe e7 = new Employe("emp7", c2, d1);
        Projet p1 = new Projet("p1");
        Projet p2 = new Projet("p2");

        et.begin();
        em.persist(d1);
        em.persist(d2);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.persist(e5);
        em.persist(e6);
        em.persist(e7);
        em.persist(p1);
        em.persist(p2);
        et.commit();
        
        et.begin();
        p1.ajouterParticipant(e1, "f1");
        p1.ajouterParticipant(c1, "f2");
        p1.ajouterParticipant(e5, "f3");
        p1.ajouterParticipant(e7, "f4");
        p1.ajouterParticipant(e4, "f5");
        p2.ajouterParticipant(c1, "f6");
        p2.ajouterParticipant(c3, "f7");
        p2.ajouterParticipant(e6, "f8");
        p2.ajouterParticipant(c2, "ft");
        p2.ajouterParticipant(e2, "f10");
        et.commit();

        em.close();
    }
}
