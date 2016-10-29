/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp12;

import tp12.Periode;
import tp12.Genre;
import tp12.Location;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tp12.Genre;
import tp12.Location;
import tp12.Periode;
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
     * @throws java.text.ParseException
     */
    @Test
    public void testAjouterReservation() throws ParseException {
        System.out.println("ajouterReservation");
        Periode p = new Periode("10/01/1985", "10/05/1990");
        Location instance = new Location("Paris", 100, Genre.STUDIO);
        boolean expResult = true;
        boolean result = instance.ajouterReservation(p);
        if (result != expResult) {
            fail("probleme ajout reservation");
        }
    }

    /**
     * Test of annulerReservation method, of class Location.
     * @throws java.text.ParseException
     */
    @Test
    public void testAnnulerReservation() throws ParseException {
        System.out.println("annulerReservation");
        Periode p = new Periode("10/01/1985", "10/05/1990");
        Location instance = new Location("Paris", 100, Genre.STUDIO);
        instance.ajouterReservation(p);
        boolean expResult = false;
        boolean result = instance.annulerReservation(new Periode("10/01/1980", "10/05/1990"));
        if (result != expResult) {
            fail("probleme suppression reservation");
        }
    }

}
