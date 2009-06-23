
package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Fornitore;
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
public class OpFornitoreTest extends TestCase {

    private Fornitore f;
    private ArrayList<Appuntamento> app;
    private ArrayList<Contratto> contr;
    private ArrayList<Fornitore> forn;
    private Boolean v;
    private Integer id = 0;
    private Integer idf;

    public OpFornitoreTest() {


    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        f = new Fornitore (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323");
    }

    @After
    public void tearDown() {
        f=null;
        System.gc();
    }

    /**
     * Test of elencaFornitore method, of class OpFornitore.
     */
    @Test
    public void testElencaFornitore() throws Exception {
        System.out.println("elencaFornitore");

        OpFornitore instance = new OpFornitore();


        ArrayList<Fornitore> expResult = forn;
        ArrayList<Fornitore> result = instance.elencaFornitore();

        Iterator<Fornitore> it = expResult.iterator();
        int i = 0;
        while (it.hasNext()) {
            Fornitore temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }


    }

    /**
     * Test of ricercaFornitore method, of class OpFornitore.
     */
/*    @Test
    public void testRicercaFornitore() throws Exception {
        System.out.println("ricercaFornitore");
        String cognome = "Rossi";
        String ruolo = "ruolo";
        OpFornitore instance = new OpFornitore();
        ArrayList<Fornitore> expResult = forn;
        ArrayList<Fornitore> result = instance.ricercaFornitore(cognome, ruolo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of elimina method, of class OpFornitore.
     */
  /*  @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpFornitore instance = new OpFornitore();
        instance.elimina(f);
        assertEquals(forn, instance.elencaFornitore());
    }

    /**
     * Test of inserisci method, of class OpFornitore.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");

        OpFornitore instance = new OpFornitore();

        assertEquals(id,f.getIdUtente());
        assertEquals("marros",f.getUsername());
        assertEquals("123456",f.getPassword());
        assertEquals("Salerno",f.getCitta());
        assertEquals("ruolo",f.getRuolo());
        assertEquals("sa", f.getProvincia());
        assertEquals("089345678",f.getTelefono());
        assertEquals("84100",f.getCap());
        assertEquals("rossi@email.it",f.getEmail());
        assertEquals("ruolo",f.getRuolo());
        assertEquals("note",f.getNote());
        assertEquals(v, f.getVisible());
        assertEquals("Rossi",f.getCognome());
        assertEquals("Mario",f.getNome());
        assertEquals("x y z.srl",f.getRagioneSociale());
        assertEquals("12345678901C",f.getPIva());
        assertEquals("089232323",f.getFax());

        instance.inserisci(f);
        
    }

    /**
     * Test of modifica method, of class OpFornitore.
     */
 /*   @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        
        OpFornitore instance = new OpFornitore();
        Fornitore expResult = null;

        assertEquals(id,f.getIdUtente());
        assertEquals("marros",f.getUsername());
        assertEquals("123456",f.getPassword());
        assertEquals("Salerno",f.getCitta());
        assertEquals("ruolo",f.getRuolo());
        assertEquals("sa", f.getProvincia());
        assertEquals("089345678",f.getTelefono());
        assertEquals("84100",f.getCap());
        assertEquals("rossi@email.it",f.getEmail());
        assertEquals("ruolo",f.getRuolo());
        assertEquals("note",f.getNote());
        assertEquals(v, f.getVisible());
        assertEquals("Rossi",f.getCognome());
        assertEquals("Mario",f.getNome());
        assertEquals("x y z.srl",f.getRagioneSociale());
        assertEquals("12345678901C",f.getPIva());
        assertEquals("089232323",f.getFax());

        Fornitore result = instance.modifica(f);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of visualizzaDati method, of class OpFornitore.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
        
        OpFornitore instance = new OpFornitore();
        Fornitore expResult = f;
        Fornitore result = instance.visualizzaDati(id);
        assertEquals(expResult, result);
       
    }

   
}