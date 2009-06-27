

package it.seerp.storage.operazioni;

import it.seerp.storage.ejb.opPersonaleRuolo.OpPersonale;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Ruolo;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/**
 *
 * @author LuNy
 */
public class OpPersonaleTest extends TestCase{

    private Personale p=new Personale();
    private Integer id = 0;
    private Ruolo r= new Ruolo("dipendente");
    private Boolean v=true;
    ArrayList<Personale> pers = new ArrayList<Personale>();
   

    public OpPersonaleTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        p = new Personale(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",v, r);

    }

    @After
    public void tearDown() {
        p=null;
        System.gc();
    }

    /**
     * Test of elencaPersonale method, of class OpPersonale.
     */
    @Test
    public void testElencaPersonale() throws Exception {
        System.out.println("elencaPersonale");

        OpPersonale instance = new OpPersonale();
        ArrayList<Personale> expResult = pers;
        ArrayList<Personale> result = instance.elencaPersonale();

         Iterator<Personale> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            Personale temp = it.next();
            assertEquals(temp, result.get(i));
            i++;

        }        
    }

    /**
     * Test of elencaPersonalePerRuolo method, of class OpPersonale.
     */
    @Test
    public void testElencaPersonalePerRuolo() throws Exception {
      
        System.out.println("elencaPersonalePerRuolo");
       
        OpPersonale instance = new OpPersonale();
        ArrayList<Personale> expResult = pers;
        ArrayList<Personale> result = instance.elencaPersonalePerRuolo(r);
        assertEquals(expResult, result);
       
    }

    

    /**
     * Test of elimina method, of class OpPersonale.
     */
/*   @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpPersonale instance = new OpPersonale();
        instance.elimina(p);
        
    }

    
    /**
     * Test of inserisci method, of class OpPersonale.
     */
 /*   @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
        
        OpPersonale instance = new OpPersonale();

         assertEquals(id,p.getIdUtente());
        assertEquals("marros",p.getUsername());
        assertEquals("123456",p.getPassword());
        assertEquals("Salerno",p.getCitta());
        
        assertEquals("sa", p.getProvincia());
        assertEquals("089345678",p.getTelefono());
        assertEquals("84100",p.getCap());
        assertEquals("rossi@email.it",p.getEmail());
        assertEquals("tipo",p.getTipo());
        assertEquals("note",p.getNote());
        assertEquals(v, p.getVisible());
        assertEquals("Rossi",p.getCognome());
        assertEquals("Mario",p.getNome());
        assertEquals("tipo",p.getNote());
        assertEquals("RSSMRO45B21H703C",p.getCodiceFiscale());
        assertEquals(r,p.getRuolo());


        instance.inserisci(p);
       
    }

    /**
     * Test of modifica method, of class OpPersonale.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        
        OpPersonale instance = new OpPersonale();
        Personale expResult = p;
        Personale result = instance.modifica(p);

        assertEquals(id,p.getIdUtente());
        assertEquals("marros",p.getUsername());
        assertEquals("123456",p.getPassword());
        assertEquals("Salerno",p.getCitta());
       
        assertEquals("sa", p.getProvincia());
        assertEquals("089345678",p.getTelefono());
        assertEquals("84100",p.getCap());
        assertEquals("rossi@email.it",p.getEmail());
        //assertEquals("note",p.getTipo());
        assertEquals("tipo",p.getNote());
        assertEquals(v, p.getVisible());
        assertEquals("Rossi",p.getCognome());
        assertEquals("Mario",p.getNome());
        
        assertEquals("RSSMRO45B21H703C",p.getCodiceFiscale());
        assertEquals(r,p.getRuolo());

        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaDati method, of class OpPersonale.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
        
        OpPersonale instance = new OpPersonale();
        Personale expResult = null;
        Personale result = instance.visualizzaDati(id);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRuoloPersonale method, of class OpPersonale.
     */
    @Test
    public void testGetRuoloPersonale() throws Exception {
        System.out.println("getRuoloPersonale");
        
        OpPersonale instance = new OpPersonale();
        ArrayList<Ruolo> expResult = null;
        ArrayList<Ruolo> result = instance.getRuoloPersonale(id);
        assertEquals(expResult, result);
       
    }

}