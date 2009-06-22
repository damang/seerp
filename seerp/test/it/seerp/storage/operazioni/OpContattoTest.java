

package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpContatto;
import it.seerp.storage.ejb.Contatto;
import java.util.ArrayList;
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
 * @author LuNy
 */
public class OpContattoTest extends TestCase{

    private Contatto c;
    private Boolean v;
    private Integer id;
    private ArrayList<Contatto> con;

     public OpContattoTest(String name) {
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
        Integer f = 4;
        c = new Contatto (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "1234567890C", "089232323", 4);

    }

    @After
    public void tearDown() {
        c = null;
        System.gc();
    }

    /**
     * Test of elencaContatto method, of class OpContatto.
     */
    @Test
    public void testElencaContatto() throws Exception {
        System.out.println("elencaContatto");
        OpContatto instance = new OpContatto();
        ArrayList<Contatto> expResult = con;
        ArrayList<Contatto> result = instance.elencaContatto();

        Iterator<Contatto> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            Contatto temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
    }

    /**
     * Test of ricercaContatto method, of class OpContatto.
     */
    @Test
    public void testRicercaContatto() throws Exception {
        System.out.println("ricercaContatto");
        Integer idd = 23;
        String user = "marros";
        OpContatto instance = new OpContatto();
        ArrayList<Contatto> expResult = null;
        ArrayList<Contatto> result = instance.ricercaContatto(23, user);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of elimina method, of class OpContatto.
     */
    @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpContatto instance = new OpContatto();
        instance.elimina(c);
       
    }

    /**
     * Test of inserisci method, of class OpContatto.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
        
        OpContatto instance = new OpContatto();

        assertEquals(id,c.getIdUtente());
        assertEquals("marros",c.getUsername());
        assertEquals("123456",c.getPassword());
        assertEquals("Salerno",c.getCitta());
        assertEquals("ruolo",c.getRuolo());
        assertEquals("sa", c.getProvincia());
        assertEquals("089345678",c.getTelefono());
        assertEquals("84100",c.getCap());
        assertEquals("rossi@email.it",c.getEmail());
        assertEquals("ruolo",c.getRuolo());
        assertEquals("note",c.getNote());
        assertEquals(v, c.getVisible());
        assertEquals("Rossi",c.getCognome());
        assertEquals("Mario",c.getNome());
        assertEquals("x y z.srl",c.getRagioneSociale());
        assertEquals("1234567890C",c.getPIva());
        assertEquals("089232323",c.getFax());
        instance.inserisci(c);
        
    }

    /**
     * Test of modifica method, of class OpContatto.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        Integer id2 = new Integer(0);
        Contatto co2 = new Contatto(id2, "biagio", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "bianchi@email.it", "ruolo", "note", v , "Bianchi", "Giovanni", "x y z.srl", "1134567890C", "089232323", 3);
        OpContatto instance = new OpContatto();
        Contatto expResult = null;

        assertEquals(id2,co2.getIdUtente());
        assertEquals("biagio",co2.getUsername());
        assertEquals("123456",co2.getPassword());
        assertEquals("Salerno",co2.getCitta());
        assertEquals("ruolo",co2.getRuolo());
        assertEquals("sa", co2.getProvincia());
        assertEquals("089345678",co2.getTelefono());
        assertEquals("84100",co2.getCap());
        assertEquals("bianchi@email.it",co2.getEmail());
        assertEquals("ruolo",co2.getRuolo());
        assertEquals("note",co2.getNote());
        assertEquals(v, co2.getVisible());
        assertEquals("Bianchi",co2.getCognome());
        assertEquals("Giovanni",co2.getNome());
        assertEquals("x y z.srl",co2.getRagioneSociale());
        assertEquals("1134567890C",co2.getPIva());
        assertEquals("089232323",co2.getFax());
        
        Contatto result = instance.modifica(co2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaDati method, of class OpContatto.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
        
        OpContatto instance = new OpContatto();
        Contatto expResult = null;
        Contatto result = instance.visualizzaDati(id);
        assertEquals(expResult, result);
       
    }

}