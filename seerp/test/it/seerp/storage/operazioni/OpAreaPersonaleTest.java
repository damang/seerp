/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpAreaPersonale;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Utente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuNy
 */
public class OpAreaPersonaleTest {

    public OpAreaPersonaleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of visualizzaDatiPersonale method, of class OpAreaPersonale.
     */
    @Test
    public void testVisualizzaDatiPersonale() throws Exception {
        System.out.println("visualizzaDatiPersonale");
        String usr = "";
        OpAreaPersonale instance = new OpAreaPersonale();
        Personale expResult = null;
        Personale result = instance.visualizzaDatiPersonale(usr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaDatiExtraAzienda method, of class OpAreaPersonale.
     */
    @Test
    public void testVisualizzaDatiExtraAzienda() throws Exception {
        System.out.println("visualizzaDatiExtraAzienda");
        String usr = "";
        OpAreaPersonale instance = new OpAreaPersonale();
        ExtraAzienda expResult = null;
        ExtraAzienda result = instance.visualizzaDatiExtraAzienda(usr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaPassword method, of class OpAreaPersonale.
     */
    @Test
    public void testModificaPassword() throws Exception {
        System.out.println("modificaPassword");
        Utente u = null;
        OpAreaPersonale instance = new OpAreaPersonale();
        Utente expResult = null;
        Utente result = instance.modificaPassword(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}