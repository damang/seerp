

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
public class ContattoTest extends TestCase{
    private Contatto cGet;
    private Contatto cSet;
    private Boolean v;
    private Integer id;
    

    public ContattoTest(String name) {
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
         Integer f = 4;
         cGet = new Contatto (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323", 4);
         cSet = new Contatto (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323", 4);

    }

    @After
    @Override
    public void tearDown() {
        cGet = null;
        System.gc();
    }

    /**
     * Test of getFeedback method, of class Contatto.
     */
    @Test
    public void testGetFeedback() {
        System.out.println("getFeedback");
        
        Integer expResult = 4;
        Integer result = cGet.getFeedback();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFeedback method, of class Contatto.
     */
    @Test
    public void testSetFeedback() {
        System.out.println("setFeedback");
        Integer feedback = 4;
        
        cSet.setFeedback(feedback);
        assertEquals(feedback, cSet.getFeedback());
    }

    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        
        boolean expResult = false;
        boolean result = cGet.equals(obj);
        assertEquals(expResult, result);
       
    }

}