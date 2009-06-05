

package it.seerp.storage.ejb;

import java.sql.Date;
import java.sql.Time;
import java.util.GregorianCalendar;
import junit.framework.TestCase;
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
public class EventoTest extends TestCase{
    private Evento e;
    private Date d;
    private Time g;

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
    public void setUp() {
     GregorianCalendar d = new GregorianCalendar(year, month, dayOfMonth);

        g= new Time(12,00,00);
        e=new Evento("aula p13", "riunione", "InternationalSchool",
                "conferenza salvaguardia ambientale", d, g, 17, 15, true);
        //String luogo, String tema, String nome, String note, Date data, Time ora,
        //int idEvento, int agenda, Boolean not
    }

    @After
    public void tearDown() {
        e=null;
        System.gc();
    }

    /**
     * Test of getNotifica method, of class Evento.
     */
    @Test
    public void testGetNotifica() {
        System.out.println("getNotifica");
        
        Boolean expResult = true;
        Boolean result = e.getNotifica();
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
        
        e.setNotifica(false);
        assertEquals(0, e.getNotifica());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgenda method, of class Evento.
     */
    @Test
    public void testGetAgenda() {
        System.out.println("getAgenda");
        Integer expResult = 15;
        Integer result = e.getAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgenda method, of class Evento.
     */
    @Test
    public void testSetAgenda() {
        System.out.println("setAgenda");
        Integer agenda = 20;

        e.setAgenda(20);
        assertEquals(agenda, e.getAgenda());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNote method, of class Evento.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        
        String expResult = "conferenza salvaguardia ambientale";
        String result = e.getNote();
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
        String note = "portare appunti sull'effetto serra";
        
        e.setNote(note);
        assertEquals(note, e.getNote());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEvento method, of class Evento.
     */
    @Test
    public void testGetIdEvento() {
        System.out.println("getIdEvento");
        
        int result = e.getIdEvento();
        assertEquals(17, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEvento method, of class Evento.
     */
    @Test
    public void testSetIdEvento() {
        System.out.println("setIdEvento");
        int idEvento = 02;
        
        e.setIdEvento(idEvento);
        assertEquals(02, e.getIdEvento());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Evento.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        
        Date expResult = d;
        Date result = e.getData();
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
        Date data = new Date(109,03,06);
        
        e.setData(data);
        assertEquals("2009-04-06", e.getData().toString());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLuogo method, of class Evento.
     */
    @Test
    public void testGetLuogo() {
        System.out.println("getLuogo");
        
        String expResult = "aula p13";
        String result = e.getLuogo();
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
        String luogo = "aula dottorandi";
        
        e.setLuogo(luogo);
        assertEquals("aula dottorandi", e.getLuogo());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Evento.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        
        String expResult = "International School";
        String result = e.getNome();
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
        String nomeEvento = "SecondLife";
        
        e.setNome(nomeEvento);
        assertEquals(nomeEvento, e.getNome());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOra method, of class Evento.
     */
    @Test
    public void testGetOra() {
        System.out.println("getOra");
        
        Time expResult = g;
        Time result = e.getOra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOra method, of class Evento.
     */
    @Test

    /*
        Date data = new Date(109,03,06);

        e.setData(data);
        assertEquals("2009-04-06", e.getData().toString());*/
    public void testSetOra() {
        System.out.println("setOra");
        Time ora = new Time(13,00,00);
        
        e.setOra(ora);
        assertEquals("13:00:00", e.getOra());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTema method, of class Evento.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        
        String expResult = "riunione";
        String result = e.getTema();
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
        String tema = "assemblea";
        
        e.setTema(tema);
        assertEquals(tema, e.getTema());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }













  

}