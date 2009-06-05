/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author Ila
 */
public class ServizioTest {

    public ServizioTest() {
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
     * Test of getListContratti method, of class Servizio.
     */
    @Test
    public void testGetListContratti() {
        System.out.println("getListContratti");
        Servizio instance = new Servizio();
        ArrayList<Contratto> expResult = null;
        ArrayList<Contratto> result = instance.getListContratti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListServizio method, of class Servizio.
     */
    @Test
    public void testSetListServizio() {
        System.out.println("setListServizio");
        ArrayList<Contratto> listServizio = null;
        Servizio instance = new Servizio();
        instance.setListServizio(listServizio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNote method, of class Servizio.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        Servizio instance = new Servizio();
        String expResult = "";
        String result = instance.getNote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNote method, of class Servizio.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "";
        Servizio instance = new Servizio();
        instance.setNote(note);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdServizio method, of class Servizio.
     */
    @Test
    public void testGetIdServizio() {
        System.out.println("getIdServizio");
        Servizio instance = new Servizio();
        Integer expResult = null;
        Integer result = instance.getIdServizio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdServizio method, of class Servizio.
     */
    @Test
    public void testSetIdServizio() {
        System.out.println("setIdServizio");
        Integer idServizio = null;
        Servizio instance = new Servizio();
        instance.setIdServizio(idServizio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescrizione method, of class Servizio.
     */
    @Test
    public void testGetDescrizione() {
        System.out.println("getDescrizione");
        Servizio instance = new Servizio();
        String expResult = "";
        String result = instance.getDescrizione();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescrizione method, of class Servizio.
     */
    @Test
    public void testSetDescrizione() {
        System.out.println("setDescrizione");
        String descrizione = "";
        Servizio instance = new Servizio();
        instance.setDescrizione(descrizione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisponibilita method, of class Servizio.
     */
    @Test
    public void testGetDisponibilita() {
        System.out.println("getDisponibilita");
        Servizio instance = new Servizio();
        Boolean expResult = null;
        Boolean result = instance.getDisponibilita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisponibilita method, of class Servizio.
     */
    @Test
    public void testSetDisponibilita() {
        System.out.println("setDisponibilita");
        Boolean disponibilita = null;
        Servizio instance = new Servizio();
        instance.setDisponibilita(disponibilita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIva method, of class Servizio.
     */
    @Test
    public void testGetIva() {
        System.out.println("getIva");
        Servizio instance = new Servizio();
        Integer expResult = null;
        Integer result = instance.getIva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIva method, of class Servizio.
     */
    @Test
    public void testSetIva() {
        System.out.println("setIva");
        Integer iva = null;
        Servizio instance = new Servizio();
        instance.setIva(iva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrezzo method, of class Servizio.
     */
    @Test
    public void testGetPrezzo() {
        System.out.println("getPrezzo");
        Servizio instance = new Servizio();
        Double expResult = null;
        Double result = instance.getPrezzo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrezzo method, of class Servizio.
     */
    @Test
    public void testSetPrezzo() {
        System.out.println("setPrezzo");
        Double prezzo = null;
        Servizio instance = new Servizio();
        instance.setPrezzo(prezzo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantita method, of class Servizio.
     */
    @Test
    public void testGetQuantita() {
        System.out.println("getQuantita");
        Servizio instance = new Servizio();
        Integer expResult = null;
        Integer result = instance.getQuantita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantita method, of class Servizio.
     */
    @Test
    public void testSetQuantita() {
        System.out.println("setQuantita");
        Integer quantita = null;
        Servizio instance = new Servizio();
        instance.setQuantita(quantita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Servizio.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Servizio instance = new Servizio();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Servizio.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Servizio instance = new Servizio();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeContratto method, of class Servizio.
     */
    @Test
    public void testRemoveContratto() {
        System.out.println("removeContratto");
        Contratto c = null;
        Servizio instance = new Servizio();
        instance.removeContratto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addContratto method, of class Servizio.
     */
    @Test
    public void testAddContratto() {
        System.out.println("addContratto");
        Contratto c = null;
        Servizio instance = new Servizio();
        instance.addContratto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}