
package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Fornitore;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author LuNy
 */
public class OpFornitoreTest extends TestCase {

    private Fornitore f;
    private ArrayList<Appuntamento> app;
    private ArrayList<Contratto> contr;
    private ArrayList<Fornitore> forn;
    private Boolean v;

    public OpFornitoreTest() {
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
     * Test of elencaFornitore method, of class OpFornitore.
     */
    @Test
    public void testElencaFornitore() throws Exception {
        System.out.println("elencaFornitore");

        OpFornitore instance = new OpFornitore();


        ArrayList<Fornitore> expResult = forn;
        ArrayList<Fornitore> result = instance.elencaFornitore();

        Iterator<Fornitore> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Fornitore temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }


    }

    /**
     * Test of ricercaFornitore method, of class OpFornitore.
     */
    @Test
    public void testRicercaFornitore() throws Exception {
        System.out.println("ricercaFornitore");
        String cognome = "";
        String ruolo = "";
        OpFornitore instance = new OpFornitore();
        ArrayList<Fornitore> expResult = null;
        ArrayList<Fornitore> result = instance.ricercaFornitore(cognome, ruolo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elimina method, of class OpFornitore.
     */
    @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        Fornitore user = null;
        OpFornitore instance = new OpFornitore();
        instance.elimina(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserisci method, of class OpFornitore.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
        Fornitore user = null;
        OpFornitore instance = new OpFornitore();
        instance.inserisci(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class OpFornitore.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        Fornitore user = null;
        OpFornitore instance = new OpFornitore();
        Fornitore expResult = null;
        Fornitore result = instance.modifica(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaDati method, of class OpFornitore.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
        Integer id = null;
        OpFornitore instance = new OpFornitore();
        Fornitore expResult = null;
        Fornitore result = instance.visualizzaDati(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}