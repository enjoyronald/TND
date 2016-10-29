/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.Date;
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
public class PeriodeTest {
    
    public PeriodeTest() {
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
     * Test of valide method, of class Periode.
     */
    @Test
    public void testValide() throws Exception {
        System.out.println("valide");
        String a = "23/10/1950";
        String d = "23/10/1940";
        Periode instance = null;
        boolean expResult = false;
        boolean result = instance.valide(a, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chevauchement method, of class Periode.
     */
    @Test
    public void testChevauchement() {
        System.out.println("chevauchement");
        Periode p = null;
        Periode instance = null;
        boolean expResult = false;
        boolean result = instance.chevauchement(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrivee method, of class Periode.
     */
    @Test
    public void testGetArrivee() {
        System.out.println("getArrivee");
        Periode instance = null;
        Date expResult = null;
        Date result = instance.getArrivee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepart method, of class Periode.
     */
    @Test
    public void testGetDepart() {
        System.out.println("getDepart");
        Periode instance = null;
        Date expResult = null;
        Date result = instance.getDepart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Periode.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object periode = null;
        Periode instance = null;
        boolean expResult = false;
        boolean result = instance.equals(periode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Periode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Periode instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
