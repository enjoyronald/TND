/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp23;

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
public class EmployeTest {
    
    public EmployeTest() {
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
    
    /**
     * 
     */
    @Test
    public void TestEmploye(){
        Employe sup = new Employe("boss");
        Employe emp = new Employe("employe",sup);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2-1PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(sup);
        em.persist(emp);
        et.commit();
        
    }
    /**
     * Test of getSuperieur method, of class Employe.
     */
    @Test
    public void testGetSuperieur() {
        System.out.println("getSuperieur");
        Employe instance = new Employe();
        Employe expResult = null;
        Employe result = instance.getSuperieur();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSuperieur method, of class Employe.
     */
    @Test
    public void testSetSuperieur() {
        System.out.println("setSuperieur");
        Employe sup = null;
        Employe instance = new Employe();
        instance.setSuperieur(sup);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
