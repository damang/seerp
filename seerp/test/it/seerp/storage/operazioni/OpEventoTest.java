package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpEvento;
import it.seerp.storage.ejb.Evento;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import junit.framework.TestCase;
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
public class OpEventoTest extends TestCase {

    ArrayList<Evento> listEve;

    public OpEventoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    @Override
    public void setUp() {
    }

    @After
    @Override
    public void tearDown() {
    }

    /**
     * Test of inserimento method, of class OpEvento.
     */
    @Test
    public void testInserimento() throws Exception {
        System.out.println("Inserimento");
        Evento e = null;
        OpEvento instance = new OpEvento();
        instance.inserimento(e);
    }

    /**
     * Test of modifica method, of class OpEvento.
     
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        Evento e = null;
        OpEvento instance = new OpEvento();
        Evento expResult = null;
        Evento result = instance.modifica(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizza method, of class OpEvento.
     
    @Test
    public void testVisualizza() throws Exception {
        System.out.println("visualizza");
        Integer id = null;
        OpEvento instance = new OpEvento();
        Evento expResult = null;
        Evento result = instance.visualizza(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaElenco method, of class OpEvento.
     */
    @Test
    public void testVisualizzaElenco() throws Exception {
        System.out.println("Visualizza Elenco");

        OpEvento instance = new OpEvento();

        ArrayList<Evento> expResult = listEve;
        ArrayList<Evento> result = instance.visualizzaElenco();

        Iterator<Evento> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Evento temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
    }

    /**
     * Test of ricercaEvento method, of class OpEvento.
     
    @Test
    public void testRicercaEvento() throws Exception {
        System.out.println("ricercaEvento");
        OpEvento instance = new OpEvento();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.ricercaEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancella method, of class OpEvento.
     
    @Test
    public void testCancella() throws Exception {
        System.out.println("cancella");
        Evento e = null;
        OpEvento instance = new OpEvento();
        instance.cancella(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notificaEvento method, of class OpEvento.
     
    @Test
    public void testNotificaEvento() throws Exception {
        System.out.println("notificaEvento");
        Evento e = null;
        OpEvento instance = new OpEvento();
        instance.notificaEvento(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eventiNotificati method, of class OpEvento.
     
    @Test
    public void testEventiNotificati() throws Exception {
        System.out.println("eventiNotificati");
        GregorianCalendar data = null;
        OpEvento instance = new OpEvento();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.eventiNotificati(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

}