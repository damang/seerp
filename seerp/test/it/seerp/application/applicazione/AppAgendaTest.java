/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.storage.ejb.Evento;
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
public class AppAgendaTest {

    public AppAgendaTest() {
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
     * Test of elenca method, of class AppAgenda.
     */
    @Test
    public void testElenca() {
        System.out.println("elenca");
        ArrayList<BeanGuiEvento> listGui = null;
        String usr = "";
        AppAgenda instance = new AppAgenda();
        ArrayList<BeanGuiEvento> expResult = null;
        ArrayList<BeanGuiEvento> result = instance.elenca(listGui, usr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventiNotificare method, of class AppAgenda.
     */
    @Test
    public void testGetEventiNotificare() throws Exception {
        System.out.println("getEventiNotificare");
        int id = 0;
        AppAgenda instance = new AppAgenda();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getEventiNotificare(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaDettagli method, of class AppAgenda.
     */
    @Test
    public void testVisualizzaDettagli() {
        System.out.println("visualizzaDettagli");
        int id = 0;
        BeanGuiEvento gui = null;
        AppAgenda instance = new AppAgenda();
        BeanGuiEvento expResult = null;
        BeanGuiEvento result = instance.visualizzaDettagli(id, gui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notificaEventi method, of class AppAgenda.
     */
    @Test
    public void testNotificaEventi() {
        System.out.println("notificaEventi");
        BeanGuiEvento beanGui = null;
        AppAgenda instance = new AppAgenda();
        instance.notificaEventi(beanGui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserimento method, of class AppAgenda.
     */
    @Test
    public void testInserimento() {
        System.out.println("inserimento");
        BeanGuiEvento beanGui = null;
        AppAgenda instance = new AppAgenda();
        instance.inserimento(beanGui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class AppAgenda.
     */
    @Test
    public void testModifica() {
        System.out.println("modifica");
        BeanGuiEvento beanGui = null;
        AppAgenda instance = new AppAgenda();
        BeanGuiEvento expResult = null;
        BeanGuiEvento result = instance.modifica(beanGui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricercaEvento method, of class AppAgenda.
     */
    @Test
    public void testRicercaEvento() {
        System.out.println("ricercaEvento");
        ArrayList<BeanGuiEvento> listGui = null;
        AppAgenda instance = new AppAgenda();
        ArrayList<BeanGuiEvento> expResult = null;
        ArrayList<BeanGuiEvento> result = instance.ricercaEvento(listGui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancellaEvento method, of class AppAgenda.
     */
    @Test
    public void testCancellaEvento_BeanGuiEvento() {
        System.out.println("cancellaEvento");
        BeanGuiEvento beanGui = null;
        AppAgenda instance = new AppAgenda();
        instance.cancellaEvento(beanGui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancellaEvento method, of class AppAgenda.
     */
    @Test
    public void testCancellaEvento_Evento() {
        System.out.println("cancellaEvento");
        Evento bean = null;
        AppAgenda instance = new AppAgenda();
        instance.cancellaEvento(bean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancellaEvento method, of class AppAgenda.
     */
    @Test
    public void testCancellaEvento_int() {
        System.out.println("cancellaEvento");
        int id = 0;
        AppAgenda instance = new AppAgenda();
        instance.cancellaEvento(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaTabella method, of class AppAgenda.
     */
    @Test
    public void testVisualizzaTabella_String() {
        System.out.println("visualizzaTabella");
        String user = "";
        AppAgenda instance = new AppAgenda();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.visualizzaTabella(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaTabella method, of class AppAgenda.
     */
    @Test
    public void testVisualizzaTabella_0args() {
        System.out.println("visualizzaTabella");
        AppAgenda instance = new AppAgenda();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.visualizzaTabella();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}