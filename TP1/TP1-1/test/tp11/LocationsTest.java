/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp11;

import tp11.Periode;
import tp11.Locations;
import tp11.Genre;
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
public class LocationsTest {
    
    public LocationsTest() {
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
     * Test of createLocation method, of class Locations.
     */
    @Test
    public void testCreateLocation() {
        System.out.println("createLocation");
        String lieu = "";
        int tarif = 0;
        Genre genre = null;
        Locations instance = new Locations();
        boolean expResult = false;
        boolean result = instance.createLocation(lieu, tarif, genre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readLocation method, of class Locations.
     */
    @Test
    public void testReadLocation() {
        System.out.println("readLocation");
        String lieu = "";
        Locations instance = new Locations();
        instance.readLocation(lieu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLocation method, of class Locations.
     */
    @Test
    public void testUpdateLocation() {
        System.out.println("updateLocation");
        String lieu = "";
        Object o = null;
        Locations instance = new Locations();
        instance.updateLocation(lieu, o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLocation method, of class Locations.
     */
    @Test
    public void testDeleteLocation_String() {
        System.out.println("deleteLocation");
        String lieu = "";
        Locations instance = new Locations();
        instance.deleteLocation(lieu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLocation method, of class Locations.
     */
    @Test
    public void testDeleteLocation_String_Periode() {
        System.out.println("deleteLocation");
        String lieu = "";
        Periode p = null;
        Locations instance = new Locations();
        instance.deleteLocation(lieu, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
