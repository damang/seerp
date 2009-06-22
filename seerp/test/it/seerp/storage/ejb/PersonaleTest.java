

package it.seerp.storage.ejb;

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
public class PersonaleTest extends TestCase{

    private Personale pGet;
    private Personale pSet;
    private Integer id;
    private Ruolo r;
    private Boolean v;


    public PersonaleTest(String name) {
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

        pGet = new Personale(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",v, r);
        pSet = new Personale(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",v, r);
    }

    @After
    public void tearDown() {

        pGet=null;
        System.gc();
    }

    /**
     * Test of getRuolo method, of class Personale.
     */
    @Test
    public void testGetRuolo() {
        System.out.println("getRuolo");
        
        Ruolo expResult = r;
        Ruolo result = pGet.getRuolo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRuolo method, of class Personale.
     */
    @Test
    public void testSetRuolo() {
        System.out.println("setRuolo");
        Ruolo ruolo = null;
        
        pSet.setRuolo(ruolo);
        assertEquals(ruolo, pSet.getRuolo());
      }

    /**
     * Test of setCodiceFiscale method, of class Personale.
     */
    @Test
    public void testSetCodiceFiscale() {
        System.out.println("setCodiceFiscale");
        String codiceFiscale = "RSSMRO45B21H703C";
        
        pSet.setCodiceFiscale(codiceFiscale);
        assertEquals(codiceFiscale, pSet.getCodiceFiscale());
        
    }

    /**
     * Test of setCognome method, of class Personale.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "Rossi";
        
        pSet.setCognome(cognome);
        assertEquals(cognome, pSet.getCognome());
        
    }

    /**
     * Test of setNome method, of class Personale.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Mario";
        
        pSet.setNome(nome);
        assertEquals(nome, pSet.getNome());
        }

    /**
     * Test of setTipo method, of class Personale.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "tipo";
       
        pSet.setTipo(tipo);
        assertEquals(tipo, pSet.getTipo());
      }

    /**
     * Test of getCodiceFiscale method, of class Personale.
     */
    @Test
    public void testGetCodiceFiscale() {
        System.out.println("getCodiceFiscale");
        
        String expResult = "RSSMRO45B21H703C";
        String result = pGet.getCodiceFiscale();
        assertEquals(expResult, result);
      }

    /**
     * Test of getCognome method, of class Personale.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
       
        String expResult = "Rossi";
        String result = pGet.getCognome();
        assertEquals(expResult, result);
         }

    /**
     * Test of getNome method, of class Personale.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        
        String expResult = "Mario";
        String result = pGet.getNome();
        assertEquals(expResult, result);
        }

    /**
     * Test of getTipo method, of class Personale.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        
        String expResult = null;
        String result = pGet.getTipo();
        assertEquals(expResult, result);
         }

    /**
     * Test of equals method, of class Personale.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        
        boolean expResult = false;
        boolean result = pGet.equals(obj);
        assertEquals(expResult, result);
       
    }

}