package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpEvento;
import it.seerp.storage.ejb.Agenda;
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

    private Evento eve;
    private GregorianCalendar data;
    private GregorianCalendar ora;
    private Boolean not=true;
    private ArrayList<Evento> listEve = null;
    private Integer idEvento;
    private Integer idAgenda=65;

    public OpEventoTest(String name) {
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
      
        data = new GregorianCalendar(2009, 7, 23);
        ora = new GregorianCalendar(2009, 7, 23, 13, 40);
        eve = new Evento("aula p13", "riunione", "InternationalSchool", "conferenza salvaguardia ambientale", data, ora, idEvento, not, idAgenda);
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
        OpEvento instance = new OpEvento();
        assertEquals("aula p13", eve.getLuogo());
        assertEquals("riunione", eve.getTema());
        assertEquals("InternationalSchool", eve.getNome());
        assertEquals("conferenza salvaguardia ambientale", eve.getNote());
        assertEquals(data, eve.getData());
        assertEquals(ora, eve.getOra());
        
        assertEquals(not, eve.getNotifica());
        assertEquals(65, eve.getAgenda());
        instance.inserimento(eve);
    }

    /**
     * Test of modifica method, of class OpEvento.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        GregorianCalendar dataP = new GregorianCalendar();
        GregorianCalendar oraP = new GregorianCalendar();
        Boolean notP = false;
        OpEvento instance = new OpEvento();
        Evento expResult = new Evento("aula p16", "appuntamento", "compleanno", "N/D", dataP, oraP, 5, notP, 45);
        assertEquals("aula p16", expResult.getLuogo());
        assertEquals("appuntamento", expResult.getTema());
        assertEquals("compleanno", expResult.getNome());
        assertEquals("N/D", expResult.getNote());
        assertEquals(dataP, expResult.getData());
        assertEquals(oraP, expResult.getOra());
        assertEquals(5, expResult.getIdEvento());
        assertEquals(notP, expResult.getNotifica());
        assertEquals(45, expResult.getAgenda());
        Evento result = instance.modifica(expResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of visualizza method, of class OpEvento.
     */
    @Test
    public void testVisualizza() throws Exception {
        System.out.println("visualizza");
        
        OpEvento instance = new OpEvento();
        Evento expResult = null;
        Evento result = instance.visualizza(idEvento);
        assertEquals(expResult, result);
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
     */
    @Test
    public void testRicercaEvento() throws Exception {
        System.out.println("ricercaEvento");
        OpEvento instance = new OpEvento();
        ArrayList<Evento> expResult = listEve;
        ArrayList<Evento> result = instance.ricercaEvento();
        Iterator<Evento> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Evento temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
    }

    /**
     * Test of cancella method, of class OpEvento.
     */
    @Test
    public void testCancella() throws Exception {
        System.out.println("cancella");
        OpEvento instance = new OpEvento();
        instance.cancella(eve);
    }

    /**
     * Test of notificaEvento method, of class OpEvento.
     */
    @Test
    public void testNotificaEvento() throws Exception {
        System.out.println("notificaEvento");
        OpEvento instance = new OpEvento();
        instance.notificaEvento(eve);
    }

    /**
     * Test of eventiNotificati method, of class OpEvento.
     */
    @Test
    public void testEventiNotificati() throws Exception {
        System.out.println("eventiNotificati");
        GregorianCalendar datas = new GregorianCalendar();
        OpEvento instance = new OpEvento();
        ArrayList<Evento> expResult = listEve;
        ArrayList<Evento> result = instance.eventiNotificati(datas);
        Iterator<Evento> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Evento temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
    }
}
