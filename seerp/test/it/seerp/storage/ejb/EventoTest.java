/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.GregorianCalendar;
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
public class EventoTest {

    public EventoTest() {
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
     * Test of equals method, of class Evento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Evento instance = new Evento();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Evento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotifica method, of class Evento.
     */
    @Test
    public void testGetNotifica() {
        System.out.println("getNotifica");
        Evento instance = new Evento();
        Boolean expResult = null;
        Boolean result = instance.getNotifica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgenda method, of class Evento.
     */
    @Test
    public void testGetAgenda() {
        System.out.println("getAgenda");
        Evento instance = new Evento();
        Agenda expResult = null;
        Agenda result = instance.getAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotifica method, of class Evento.
     */
    @Test
    public void testSetNotifica() {
        System.out.println("setNotifica");
        Boolean notifica = null;
        Evento instance = new Evento();
        instance.setNotifica(notifica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgenda method, of class Evento.
     */
    @Test
    public void testSetAgenda() {
        System.out.println("setAgenda");
        Agenda a = null;
        Evento instance = new Evento();
        instance.setAgenda(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNote method, of class Evento.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getNote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNote method, of class Evento.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "";
        Evento instance = new Evento();
        instance.setNote(note);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEvento method, of class Evento.
     */
    @Test
    public void testGetIdEvento() {
        System.out.println("getIdEvento");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.getIdEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEvento method, of class Evento.
     */
    @Test
    public void testSetIdEvento() {
        System.out.println("setIdEvento");
        int idEvento = 0;
        Evento instance = new Evento();
        instance.setIdEvento(idEvento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Evento.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Evento instance = new Evento();
        GregorianCalendar expResult = null;
        GregorianCalendar result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Evento.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        GregorianCalendar data = null;
        Evento instance = new Evento();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLuogo method, of class Evento.
     */
    @Test
    public void testGetLuogo() {
        System.out.println("getLuogo");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getLuogo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLuogo method, of class Evento.
     */
    @Test
    public void testSetLuogo() {
        System.out.println("setLuogo");
        String luogo = "";
        Evento instance = new Evento();
        instance.setLuogo(luogo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Evento.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Evento.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nomeEvento = "";
        Evento instance = new Evento();
        instance.setNome(nomeEvento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOra method, of class Evento.
     */
    @Test
    public void testGetOra() {
        System.out.println("getOra");
        Evento instance = new Evento();
        GregorianCalendar expResult = null;
        GregorianCalendar result = instance.getOra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOra method, of class Evento.
     */
    @Test
    public void testSetOra() {
        System.out.println("setOra");
        GregorianCalendar ora = null;
        Evento instance = new Evento();
        instance.setOra(ora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTema method, of class Evento.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getTema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTema method, of class Evento.
     */
    @Test
    public void testSetTema() {
        System.out.println("setTema");
        String tema = "";
        Evento instance = new Evento();
        instance.setTema(tema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}