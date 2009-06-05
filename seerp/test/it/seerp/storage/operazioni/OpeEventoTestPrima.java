

package it.seerp.storage.operazioni;

import it.seerp.storage.ejb.Evento;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
public class OpeEventoTestPrima extends TestCase{
    private Date d;
    private Time g;
    private Evento c;

    public OpeEventoTestPrima(String name) {
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
        d = new Date(108,00,12);
        g= new Time(12,00,00);

        c=new Evento("aula p13", "riunione", "InternationalSchool",
                "conferenza salvaguardia ambientale", d, g, 17, 15, true);
        //String luogo, String tema, String nome, String note, Date data, Time ora, int idEvento, int agenda, Boolean not
    }

    @After
    public void tearDown() {
        c=null;

    }

    /**
     * Test of inserimento method, of class OpeEvento.
     */
    @Test
    public void testInserimento() throws Exception {
        System.out.println("inserimento");
       
        OpeEvento instance = new OpeEvento();

        assertEquals("aula p13",c.getLuogo());
        assertEquals("riunione",c.getTema());
        assertEquals("InternationalSchool",c.getNome());
        assertEquals("conferenza salvaguardia ambientale",c.getNote());
        assertEquals(d,c.getData());
        assertEquals(g,c.getOra());
        assertEquals(17,c.getIdEvento());
        assertEquals(0,c.getNotifica());
        instance.inserimento(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifica method, of class OpeEvento.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
       
        OpeEvento instance = new OpeEvento();
        Evento expResult = null;

        assertEquals("aula 17",c.getLuogo());
        assertEquals("conferenza",c.getTema());
        assertEquals("International",c.getNome());
        assertEquals("conferenza salvaguardia mondiale",c.getNote());
        assertEquals(d,c.getData().toString());
        assertEquals(g,c.getOra().toString());
        assertEquals(20,c.getIdEvento());
        assertEquals(1,c.getNotifica());
        Evento result = instance.modifica(c);



        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizza method, of class OpeEvento.
     */
    @Test
    public void testVisualizza() throws Exception {
        System.out.println("visualizza");
        Integer id = 17;
        OpeEvento instance = new OpeEvento();
        Evento expResult = c;
        Evento result = instance.visualizza(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaElenco method, of class OpeEvento.
     */
    @Test
    public void testVisualizzaElenco() throws Exception {
        System.out.println("visualizzaElenco");
        OpeEvento instance = new OpeEvento();
        ArrayList<Evento> expResult = ;
        ArrayList<Evento> result = instance.visualizzaElenco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricercaEvento method, of class OpeEvento.
     */
    @Test
    public void testRicercaEvento() throws Exception {
        System.out.println("ricercaEvento");
        String nome = "riunione";
        OpeEvento instance = new OpeEvento();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.ricercaEvento(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricercaPerTema method, of class OpeEvento.
     */
    @Test
    public void testRicercaPerTema() throws Exception {
        System.out.println("ricercaPerTema");
        String tema = "";
        OpeEvento instance = new OpeEvento();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.ricercaPerTema(tema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricercaPerGiorno method, of class OpeEvento.
     */
    @Test
    public void testRicercaPerGiorno() throws Exception {
        System.out.println("ricercaPerGiorno");
        String data = "";
        OpeEvento instance = new OpeEvento();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.ricercaPerGiorno(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancella method, of class OpeEvento.
     */
    @Test
    public void testCancella() throws Exception {
        System.out.println("cancella");
        Evento e = null;
        OpeEvento instance = new OpeEvento();
        instance.cancella(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notificaEvento method, of class OpeEvento.
     */
    @Test
    public void testNotificaEvento() throws Exception {
        System.out.println("notificaEvento");
        Evento e = null;
        OpeEvento instance = new OpeEvento();
        instance.notificaEvento(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eventiNotificati method, of class OpeEvento.
     */
    @Test
    public void testEventiNotificati() throws Exception {
        System.out.println("eventiNotificati");
        Date data = null;
        OpeEvento instance = new OpeEvento();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.eventiNotificati(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}

}