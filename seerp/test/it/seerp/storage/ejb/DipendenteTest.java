

package it.seerp.storage.ejb;

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
 * @author LuNy
 */
public class DipendenteTest extends TestCase{

    private Dipendente dSet;
    private Dipendente dGet;
    private Integer id;
    private Boolean v;
    private Ruolo r;
    private ArrayList<Appuntamento> app;
    private ArrayList<Contratto> contr;

    public DipendenteTest(String name) {
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

         dGet = new Dipendente(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",r, v);
         dSet = new Dipendente(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",r, v);

    }

    @After
    public void tearDown() {
        dGet = null;
        System.gc();
    }

    /**
     * Test of setListContratti method, of class Dipendente.
     */
    @Test
    public void testSetListContratti() {
        System.out.println("setListContratti");
        ArrayList<Contratto> listContratti = contr;
       
        dSet.setListContratti(listContratti);
        assertEquals(contr, dSet.getListContratti());
    }

    /**
     * Test of getListContratti method, of class Dipendente.
     */
    @Test
    public void testGetListContratti() {
        System.out.println("getListContratti");
        
        ArrayList<Contratto> expResult = contr;
        ArrayList<Contratto> result = dGet.getListContratti();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getListAppuntamenti method, of class Dipendente.
     */
    @Test
    public void testGetListAppuntamenti() {
        System.out.println("getListAppuntamenti");
        
        ArrayList<Appuntamento> expResult = app;
        ArrayList<Appuntamento> result = dGet.getListAppuntamenti();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setListAppuntamenti method, of class Dipendente.
     */
    @Test
    public void testSetListAppuntamenti() {
        System.out.println("setListAppuntamenti");
        ArrayList<Appuntamento> listAppuntamenti = app;
        
       dSet.setListAppuntamenti(listAppuntamenti);
       assertEquals(app, dSet.getListAppuntamenti()) ;
    }

    /**
     * Test of removeAppuntamento method, of class Dipendente.
     */
    @Test
    public void testRemoveAppuntamento() {
        System.out.println("removeAppuntamento");
        Appuntamento p = null;
        
        dGet.removeAppuntamento(p);
        assertEquals(app, dGet.getListAppuntamenti());
    }

    /**
     * Test of addAppuntamento method, of class Dipendente.
     */
    @Test
    public void testAddAppuntamento() {
        System.out.println("addAppuntamento");
        Appuntamento p = null;
        
        dGet.addAppuntamento(p);
        assertEquals(app, dGet.getListAppuntamenti());
        
    }

    /**
     * Test of removeContratto method, of class Dipendente.
     */
    @Test
    public void testRemoveContratto() {
        System.out.println("removeContratto");
        Contratto c = null;
        
        dGet.removeContratto(c);
        assertEquals(contr, dGet.getListContratti());
    }

    /**
     * Test of addContratto method, of class Dipendente.
     */
    @Test
    public void testAddContratto() {
        System.out.println("addContratto");
        Contratto c = null;
        
        dGet.addContratto(c);
        assertEquals(contr, dGet.getListContratti());
    }

}