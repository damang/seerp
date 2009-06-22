package it.seerp.storage.ejb;

import java.util.GregorianCalendar;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe che testa i metodi della classe Evento
 * @author Tommaso Cattolico
 */
public class EventoTest extends TestCase {

    private Agenda agd;
    private Evento eveGet;
    private Evento eveSet;
    private GregorianCalendar data;
    private GregorianCalendar ora;
    private Integer id;

    public EventoTest(String name) {
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
        id = new Integer(15);
        agd = new Agenda();
        data = new GregorianCalendar(2009, 7, 23);
        ora = new GregorianCalendar(2009, 7, 23, 13, 40);
        eveGet = new Evento("aula p13", "riunione", "InternationalSchool", "conferenza salvaguardia ambientale", data, ora, 15, true, agd);
        eveSet = new Evento("aula p13", "riunione", "InternationalSchool", "conferenza salvaguardia ambientale", data, ora, 15, true, agd);
    }

    @After
    @Override
    public void tearDown() {
        eveGet = null;
        eveSet = null;
        System.gc();
    }

    /**
     * Test of equals method, of class Evento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = eveGet.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNotifica method, of class Evento.
     */
    @Test
    public void testGetNotifica() {
        System.out.println("getNotifica");
        Boolean expResult = true;
        Boolean result = eveGet.getNotifica();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgenda method, of class Evento.
     */
    @Test
    public void testGetAgenda() {
        System.out.println("getAgenda");
        Agenda expResult = agd;
        Agenda result = eveGet.getAgenda();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNotifica method, of class Evento.
     */
    @Test
    public void testSetNotifica() {
        System.out.println("setNotifica");
        Boolean notifica = false;
        eveSet.setNotifica(notifica);
        assertEquals(notifica, eveSet.getNotifica());
    }

    /**
     * Test of setAgenda method, of class Evento.
     */
    @Test
    public void testSetAgenda() {
        System.out.println("setAgenda");
        Agenda a = new Agenda();
        eveSet.setAgenda(a);
        assertEquals(a, eveSet.getAgenda());
    }

    /**
     * Test of getNote method, of class Evento.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        String expResult = "conferenza salvaguardia ambientale";
        String result = eveGet.getNote();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNote method, of class Evento.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "nessuna nota";
        eveSet.setNote(note);
        assertEquals(note, eveSet.getNote());
    }

    /**
     * Test of getIdEvento method, of class Evento.
     */
    @Test
    public void testGetIdEvento() {
        System.out.println("getIdEvento");
        int expResult = 15;
        int result = eveGet.getIdEvento();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdEvento method, of class Evento.
     */
    @Test
    public void testSetIdEvento() {
        System.out.println("setIdEvento");
        int idEvento = 12;
        eveSet.setIdEvento(idEvento);
        assertEquals(idEvento, eveSet.getIdEvento());
    }

    /**
     * Test of getData method, of class Evento.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        GregorianCalendar expResult = new GregorianCalendar(2009, 7, 23);
        GregorianCalendar result = eveGet.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class Evento.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        GregorianCalendar dataT = new GregorianCalendar();
        eveSet.setData(dataT);
        assertEquals(dataT, eveSet.getData());
    }

    /**
     * Test of getLuogo method, of class Evento.
     */
    @Test
    public void testGetLuogo() {
        System.out.println("getLuogo");
        String expResult = "aula p13";
        String result = eveGet.getLuogo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLuogo method, of class Evento.
     */
    @Test
    public void testSetLuogo() {
        System.out.println("setLuogo");
        String luogo = "Sesa lab";
        eveSet.setLuogo(luogo);
        assertEquals(luogo, eveSet.getLuogo());
    }

    /**
     * Test of getNome method, of class Evento.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "InternationalSchool";
        String result = eveGet.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Evento.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nomeEvento = "Appuntamento";
        eveSet.setNome(nomeEvento);
        assertEquals(nomeEvento, eveSet.getNome());
    }

    /**
     * Test of getOra method, of class Evento.
     */
    @Test
    public void testGetOra() {
        System.out.println("getOra");
        GregorianCalendar expResult = new GregorianCalendar(2009, 7, 23, 13, 40);
        GregorianCalendar result = eveGet.getOra();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOra method, of class Evento.
     */
    @Test
    public void testSetOra() {
        System.out.println("setOra");
        GregorianCalendar oraT = new GregorianCalendar();
        eveSet.setOra(oraT);
        assertEquals(oraT, eveSet.getOra());
    }

    /**
     * Test of getTema method, of class Evento.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        String expResult = "riunione";
        String result = eveGet.getTema();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTema method, of class Evento.
     */
    @Test
    public void testSetTema() {
        System.out.println("setTema");
        String tema = "appuntamenti";
        eveSet.setTema(tema);
        assertEquals(tema, eveSet.getTema());
    }
}