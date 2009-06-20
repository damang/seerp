package it.seerp.storage.ejb;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TOMMASO
 */
public class AgendaTest {

    public AgendaTest() {
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
     * Test of equals method, of class Agenda.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Agenda instance = new Agenda();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Agenda.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Agenda instance = new Agenda();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListEventi method, of class Agenda.
     */
    @Test
    public void testGetListEventi() {
        System.out.println("getListEventi");
        Agenda instance = new Agenda();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.getListEventi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListEventi method, of class Agenda.
     */
    @Test
    public void testSetListEventi() {
        System.out.println("setListEventi");
        ArrayList<Evento> listEventi = null;
        Agenda instance = new Agenda();
        instance.setListEventi(listEventi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtente method, of class Agenda.
     */
    @Test
    public void testGetUtente() {
        System.out.println("getUtente");
        Agenda instance = new Agenda();
        Utente expResult = null;
        Utente result = instance.getUtente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtente method, of class Agenda.
     */
    @Test
    public void testSetUtente() {
        System.out.println("setUtente");
        Utente utente = null;
        Agenda instance = new Agenda();
        instance.setUtente(utente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgenda method, of class Agenda.
     */
    @Test
    public void testGetAgenda() {
        System.out.println("getAgenda");
        Agenda instance = new Agenda();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.getAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgenda method, of class Agenda.
     */
    @Test
    public void testSetAgenda() {
        System.out.println("setAgenda");
        ArrayList<Evento> agenda = null;
        Agenda instance = new Agenda();
        instance.setAgenda(agenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdAgenda method, of class Agenda.
     */
    @Test
    public void testGetIdAgenda() {
        System.out.println("getIdAgenda");
        Agenda instance = new Agenda();
        Integer expResult = null;
        Integer result = instance.getIdAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdAgenda method, of class Agenda.
     */
    @Test
    public void testSetIdAgenda() {
        System.out.println("setIdAgenda");
        Integer idAgenda = null;
        Agenda instance = new Agenda();
        instance.setIdAgenda(idAgenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEvento method, of class Agenda.
     */
    @Test
    public void testRemoveEvento() {
        System.out.println("removeEvento");
        Evento c = null;
        Agenda instance = new Agenda();
        instance.removeEvento(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEvento method, of class Agenda.
     */
    @Test
    public void testAddEvento() {
        System.out.println("addEvento");
        Evento c = null;
        Agenda instance = new Agenda();
        instance.addEvento(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}