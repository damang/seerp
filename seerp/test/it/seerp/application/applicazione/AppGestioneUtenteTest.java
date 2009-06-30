/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;
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
public class AppGestioneUtenteTest {

    public AppGestioneUtenteTest() {
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
     * Test of elenca method, of class AppGestioneUtente.
     */
    @Test
    public void testElenca() {
        System.out.println("elenca");
        ArrayList<BeanGuiUtente> listGui = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        ArrayList<BeanGuiUtente> expResult = null;
        ArrayList<BeanGuiUtente> result = instance.elenca(listGui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricerca method, of class AppGestioneUtente.
     */
    @Test
    public void testRicerca() {
        System.out.println("ricerca");
        ArrayList<BeanGuiUtente> list = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        ArrayList<BeanGuiUtente> expResult = null;
        ArrayList<BeanGuiUtente> result = instance.ricerca(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elimina method, of class AppGestioneUtente.
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        int id = 0;
        BeanGuiUtente user = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        instance.elimina(id, user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminazioneLogica method, of class AppGestioneUtente.
     */
    @Test
    public void testEliminazioneLogica() {
        System.out.println("eliminazioneLogica");
        BeanGuiUtente user = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        instance.eliminazioneLogica(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserisci method, of class AppGestioneUtente.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
        BeanGuiUtente user = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        instance.inserisci(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class AppGestioneUtente.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        int id = 0;
        BeanGuiUtente user = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        BeanGuiUtente expResult = null;
        BeanGuiUtente result = instance.modifica(id, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaDati method, of class AppGestioneUtente.
     */
    @Test
    public void testVisualizzaDati() {
        System.out.println("visualizzaDati");
        int user = 0;
        BeanGuiUtente beanGui = null;
        AppGestioneUtente instance = new AppGestioneUtente();
        BeanGuiUtente expResult = null;
        BeanGuiUtente result = instance.visualizzaDati(user, beanGui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaTabella method, of class AppGestioneUtente.
     */
    @Test
    public void testVisualizzaTabella() {
        System.out.println("visualizzaTabella");
        AppGestioneUtente instance = new AppGestioneUtente();
        ArrayList<Utente> expResult = null;
        ArrayList<Utente> result = instance.visualizzaTabella();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}