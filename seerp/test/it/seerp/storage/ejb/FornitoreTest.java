
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
public class FornitoreTest extends TestCase{
     private Fornitore fGet;
     private Fornitore fSet;
     private Integer id;
     private Boolean v;
     private Integer idf;

    public FornitoreTest(String name) {
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
        Integer idf = 12;

        fGet = new Fornitore (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323");
        fSet = new Fornitore (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323");


    }

    @After
    public void tearDown() {
        fGet = null;
        System.gc();
    }

    /**
     * Test of getIdFornitore method, of class Fornitore.
     */
    @Test
    public void testGetIdFornitore() {
        System.out.println("getIdFornitore");
        
        Integer expResult = 12;
        Integer result = fGet.getIdFornitore();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIdFornitore method, of class Fornitore.
     */
    @Test
    public void testSetIdFornitore() {
        System.out.println("setIdFornitore");
        Integer idFornitore = 12;
        
        fSet.setIdFornitore(idFornitore);
        assertEquals(idFornitore, fSet.getIdFornitore());
    }

    /**
     * Test of equals method, of class Fornitore.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        
        boolean expResult = true;
        boolean result = fGet.equals(obj);
        assertEquals(expResult, result);
        
    }

}