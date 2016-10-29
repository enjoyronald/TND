/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.List;
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
public class LocationTest {
    
    public LocationTest() {
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
     * Test of ajouterReservation method, of class Location.
     */
    @Test
    public void testAjouterReservation() {
        System.out.println("ajouterReservation");
        Periode p = null;
        Location instance = null;
        boolean expResult = false;
        boolean result = instance.ajouterReservation(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of annulerReservation method, of class Location.
     */
    @Test
    public void testAnnulerReservation() {
        System.out.println("annulerReservation");
        Periode p = null;
        Location instance = null;
        instance.annulerReservation(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTarif method, of class Location.
     */
    @Test
    public void testSetTarif() {
        System.out.println("setTarif");
        int tarif = 0;
        Location instance = null;
        instance.setTarif(tarif);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLieu method, of class Location.
     */
    @Test
    public void testGetLieu() {
        System.out.println("getLieu");
        Location instance = null;
        String expResult = "";
        String result = instance.getLieu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservations method, of class Location.
     */
    @Test
    public void testGetReservations() {
        System.out.println("getReservations");
        Location instance = null;
        List<Periode> expResult = null;
        List<Periode> result = instance.getReservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Location.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Location instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
