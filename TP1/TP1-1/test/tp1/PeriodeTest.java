/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.text.ParseException;
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
        Periode instance = new Periode("10/01/2001", "10/05/2015");
        boolean expResult = false;
        boolean result = instance.valide(a, d);
        if (expResult != result)// TODO review the generated test code and remove the default call to fail.
        {
            fail("probleme avec :");
        }
    }

    /**
     * Test of chevauchement method, of class Periode.
     */
    @Test
    public void testChevauchement() throws ParseException {
        System.out.println("chevauchement");
        Periode p = new Periode("10/01/1985", "10/05/1990");
        Periode instance = new Periode("10/01/1980", "10/05/2015");
        boolean expResult = true;
        boolean result = instance.chevauchement(p);
        if (expResult != result) {
            fail("pb avec.");
        }
    }

    /**
     * Test of equals method, of class Periode.
     */
    @Test
    public void testEquals() throws ParseException {
        System.out.println("equals");
        Periode periode = new Periode("10/01/2001", "10/05/2015");
        Periode instance = new Periode("10/01/2000", "10/05/2015");
        boolean expResult = false;
        boolean result = instance.equals(periode);
        if (expResult != result) {
            fail("pb avec .");
        }
    }
}
