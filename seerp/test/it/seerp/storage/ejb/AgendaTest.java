package it.seerp.storage.ejb;

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
 * Classe Test per l'Agenda
 * @author Tommaso Cattolico
 */
public class AgendaTest extends TestCase {

    private Agenda agdGet;
    private Agenda agdSet;
    private Utente user;
    private ArrayList<Evento> list;
    private ArrayList<Evento> listSet;
    private Evento eve;

    public AgendaTest(String name) {
        super(name);
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
        eve = new Evento();
        user = new Utente();
        list = new ArrayList<Evento>();
        listSet = new ArrayList<Evento>();
        agdGet = new Agenda(12, user);
        agdSet = new Agenda(12, user);
        agdGet.addEvento(eve);
        list.add(eve);
        listSet.add(new Evento("napoli", "convegno", "IT Tecnologie", "N/D", new GregorianCalendar(), new GregorianCalendar(), 21, true));
    }

    @After
    @Override
    public void tearDown() {
        agdGet = null;
        agdSet = null;
        System.gc();
    }

    /**
     * Test of equals method, of class Agenda.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = agdGet.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListEventi method, of class Agenda.
     */
    @Test
    public void testGetListEventi() {
        System.out.println("getListEventi");
        ArrayList<Evento> expResult = list;
        ArrayList<Evento> result = agdGet.getListEventi();
        Iterator<Evento> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Evento temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
    }

    /**
     * Test of setListEventi method, of class Agenda.
     */
    @Test
    public void testSetListEventi() {
        System.out.println("setListEventi");
        ArrayList<Evento> expResult = listSet;
        agdSet.setListEventi(expResult);
        Iterator<Evento> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Evento temp = it.next();
            assertEquals(temp, agdSet.getListEventi().get(i));
            i++;
        }
    }

    /**
     * Test of getUtente method, of class Agenda.
     */
    @Test
    public void testGetUtente() {
        System.out.println("getUtente");
        Utente expResult = user;
        Utente result = agdGet.getUtente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUtente method, of class Agenda.
     */
    @Test
    public void testSetUtente() {
        System.out.println("setUtente");
        Utente utente = null;
        agdSet.setUtente(utente);
        assertEquals(utente, agdSet.getUtente());
    }

    /**
     * Test of getIdAgenda method, of class Agenda.
     */
    @Test
    public void testGetIdAgenda() {
        System.out.println("getIdAgenda");
        Integer expResult = 12;
        Integer result = agdGet.getIdAgenda();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdAgenda method, of class Agenda.
     */
    @Test
    public void testSetIdAgenda() {
        System.out.println("setIdAgenda");
        Integer idAgenda = 34;
        agdSet.setIdAgenda(idAgenda);
        assertEquals(idAgenda, agdSet.getIdAgenda());
    }

    /**
     * Test of removeEvento method, of class Agenda.
     */
    @Test
    public void testRemoveEvento() {
        System.out.println("removeEvento");
        int size = agdGet.getListEventi().size();
        agdGet.removeEvento(eve);
        assertEquals(size - 1, agdGet.getListEventi().size());
    }

    /**
     * Test of addEvento method, of class Agenda.
     */
    @Test
    public void testAddEvento() {
        System.out.println("addEvento");
        int size = agdSet.getListEventi().size();
        agdSet.addEvento(eve);
        assertEquals(size + 1, agdSet.getListEventi().size());
        assertEquals(agdSet.getListEventi().get(0), list.get(0));
    }
}