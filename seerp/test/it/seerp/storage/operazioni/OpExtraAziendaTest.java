
package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpExtraAzienda;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.ExtraAzienda;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author LuNy
 */
public class OpExtraAziendaTest extends TestCase {

    private ExtraAzienda e;
    private Boolean v;
    private Integer id = 0;
    private ArrayList<Appuntamento> app;
    private ArrayList<Contratto> contr;
    ArrayList<ExtraAzienda> ex;

    public OpExtraAziendaTest(String name) {
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

        e = new ExtraAzienda(id, "marros", "123456", "Salerno", "ruolo", "sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v, "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323");

    }

    @After
    public void tearDown() {
        e = null;
        System.gc();
    }

    /**
     * Test of elencaExtraAzienda method, of class OpExtraAzienda.
     */
    @Test
    public void testElencaExtraAzienda() throws Exception {
        System.out.println("elencaExtraAzienda");
        ArrayList<ExtraAzienda> ex = new ArrayList<ExtraAzienda>();
        OpExtraAzienda instance = new OpExtraAzienda();
        ArrayList<ExtraAzienda> expResult = ex;
        ArrayList<ExtraAzienda> result = instance.elencaExtraAzienda();

        Iterator<ExtraAzienda> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            ExtraAzienda temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
            
        }

        assertEquals(expResult, result);
        
    }

    /**
     * Test of ricercaExtraAzienda method, of class OpExtraAzienda.
     */
   /* @Test
    public void testRicercaExtraAzienda() throws Exception {
        System.out.println("ricercaExtraAzienda");
        String cognome = "Rossi";
        String ruolo = "ruolo";
        OpExtraAzienda instance = new OpExtraAzienda();
        ArrayList<ExtraAzienda> expResult = ex;
        ArrayList<ExtraAzienda> result = instance.ricercaExtraAzienda(cognome, ruolo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of elimina method, of class OpExtraAzienda.
     */
    @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpExtraAzienda instance = new OpExtraAzienda();
        instance.elimina(e);
        
    }

    /**
     * Test of inserisci method, of class OpExtraAzienda.
     */
   /* @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
        
        OpExtraAzienda instance = new OpExtraAzienda();

        assertEquals(id,e.getIdUtente());
        assertEquals("marros",e.getUsername());
        assertEquals("123456",e.getPassword());
        assertEquals("Salerno",e.getCitta());
        assertEquals("ruolo",e.getRuolo());
        assertEquals("sa", e.getProvincia());
        assertEquals("089345678",e.getTelefono());
        assertEquals("84100",e.getCap());
        assertEquals("rossi@email.it",e.getEmail());
        assertEquals("ruolo",e.getRuolo());
        assertEquals("note",e.getNote());
        assertEquals(v, e.getVisible());
        assertEquals("Rossi",e.getCognome());
        assertEquals("Mario",e.getNome());
        assertEquals("x y z.srl",e.getRagioneSociale());
        assertEquals("12345678901C",e.getPIva());
        assertEquals("089232323",e.getFax());

        instance.inserisci(e);
        
    }

    /**
     * Test of modifica method, of class OpExtraAzienda.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        
        OpExtraAzienda instance = new OpExtraAzienda();
        ExtraAzienda expResult = null;

        assertEquals(id,e.getIdUtente());
        assertEquals("marros",e.getUsername());
        assertEquals("123456",e.getPassword());
        assertEquals("Salerno",e.getCitta());
        assertEquals("ruolo",e.getRuolo());
        assertEquals("sa", e.getProvincia());
        assertEquals("089345678",e.getTelefono());
        assertEquals("84100",e.getCap());
        assertEquals("rossi@email.it",e.getEmail());
        assertEquals("ruolo",e.getRuolo());
        assertEquals("note",e.getNote());
        assertEquals(v, e.getVisible());
        assertEquals("Rossi",e.getCognome());
        assertEquals("Mario",e.getNome());
        assertEquals("x y z.srl",e.getRagioneSociale());
        assertEquals("12345678901C",e.getPIva());
        assertEquals("089232323",e.getFax());

        ExtraAzienda result = instance.modifica(e);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaDati method, of class OpExtraAzienda.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
       
        OpExtraAzienda instance = new OpExtraAzienda();
        ExtraAzienda expResult = e;
        ExtraAzienda result = instance.visualizzaDati(id);
        assertEquals(expResult, result);
        
    }
}