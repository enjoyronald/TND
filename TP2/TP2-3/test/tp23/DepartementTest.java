/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp23;

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
public class DepartementTest {

    public DepartementTest() {
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
    public void TestAjoutSuppressionEmploye(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2-1PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Departement d1 = new  Departement("dep1", "france");
        Departement d2 = new  Departement("dep2", "italie");
        
        Employe c1= new Employe("chef1",null,d1);
        Employe c2= new Employe("chef2",c1,d2);
        Employe c3= new Employe("chef3",null,d2);
        Employe e1 = new Employe("emp1",null,d1);
        Employe e2 = new Employe("emp2",c1,d2);
        Employe e3 = new Employe("emp3",c1,d2);
        Employe e4 = new Employe("emp4",null,d1);
        Employe e5 = new Employe("emp5",c3,d2);
        Employe e6 = new Employe("emp6",c2,d1);
        Employe e7 = new Employe("emp7",c2,d1);
    
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
        et.commit();
        
        em.close();
    }
    @Test
    public void TestDepartement() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2-1PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        String nom = "paris";
        String lieu = "france";
        Departement d1 = new Departement(nom, lieu);
        // test ecriture
        et.begin();
        em.persist(d1);
        et.commit();

        //test lecture NE PAS OUBLIER LES ' '
        String squery = "Select s from Departement s where s.nom='" + nom + "' AND s.lieu='" + lieu + "'";
        Query query = em.createQuery(squery);
        Departement d2 = (Departement) query.getSingleResult();
        if (!d1.getNom().equals(d2.getNom()) || !d1.getLieu().equals(d2.getLieu())) {
            fail("Problème insertion");
        }

        //Test modification
        nom = "lyon";
        et.begin();
        d1.setNom(nom);
        et.commit();
        //test lecture NE PAS OUBLIER LES ' '
        squery = "Select s from Departement s where s.nom='" + nom + "' AND s.lieu='" + lieu + "'";
        query = em.createQuery(squery);
        d2 = (Departement) query.getSingleResult();
        if (!d1.getNom().equals(d2.getNom()) || !d1.getLieu().equals(d2.getLieu())) {
            fail("Problème modification");
        }
        
        //Test suppression
        et.begin();
        em.remove(d2);
        et.commit();
        squery = "Select s from Departement s where s.nom='" + nom + "' AND s.lieu='" + lieu + "'";
        query = em.createQuery(squery);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            fail("Problème modification");
        }
        em.close();
    }

}
