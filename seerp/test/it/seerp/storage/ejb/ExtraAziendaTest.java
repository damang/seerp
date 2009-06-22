

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
public class ExtraAziendaTest extends TestCase{

    private ExtraAzienda eGet;
    private ExtraAzienda eSet;
    private Boolean v;
    private Integer id;
    private ArrayList<Appuntamento> app;
    private ArrayList<Contratto> contr;

    public ExtraAziendaTest(String name) {
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
        eGet = new ExtraAzienda(id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323");
        eSet = new ExtraAzienda(id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323");

    }

    @After
    public void tearDown() {
        eGet= null;
        System.gc();
    }

    /**
     * Test of getListContratti method, of class ExtraAzienda.
     */
    @Test
    public void testGetListContratti() {
        System.out.println("getListContratti");
        
        ArrayList<Contratto> expResult = contr;
        ArrayList<Contratto> result = eGet.getListContratti();
        assertEquals(expResult, result);
         }

    /**
     * Test of setListContratti method, of class ExtraAzienda.
     */
    @Test
    public void testSetListContratti() {
        System.out.println("setListContratti");
        ArrayList<Contratto> listContratti = contr;
        
        eSet.setListContratti(listContratti);
        assertEquals(contr, eSet.getListContratti());
    }

    /**
     * Test of getListAppuntamenti method, of class ExtraAzienda.
     */
    @Test
    public void testGetListAppuntamenti() {
        System.out.println("getListAppuntamenti");
      
        ArrayList<Appuntamento> expResult = app;
        ArrayList<Appuntamento> result = eGet.getListAppuntamenti();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setListAppuntamenti method, of class ExtraAzienda.
     */
    @Test
    public void testSetListAppuntamenti() {
        System.out.println("setListAppuntamenti");
        ArrayList<Appuntamento> listAppuntamenti = app;
       
        eSet.setListAppuntamenti(listAppuntamenti);
        assertEquals(app, eSet.getListAppuntamenti());
    }

    /**
     * Test of getCognome method, of class ExtraAzienda.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
       
        String expResult = "Rossi";
        String result = eGet.getCognome();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFax method, of class ExtraAzienda.
     */
    @Test
    public void testGetFax() {
        System.out.println("getFax");
       
        String expResult = "089232323";
        String result = eGet.getFax();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNome method, of class ExtraAzienda.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        
        String expResult = "Mario";
        String result = eGet.getNome();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPIva method, of class ExtraAzienda.
     */
    @Test
    public void testGetPIva() {
        System.out.println("getPIva");
        
        String expResult = "12345678901C";
        String result = eGet.getPIva();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRagioneSociale method, of class ExtraAzienda.
     */
    @Test
    public void testGetRagioneSociale() {
        System.out.println("getRagioneSociale");
       
        String expResult = "x y z.srl";
        String result = eGet.getRagioneSociale();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRuolo method, of class ExtraAzienda.
     */
    @Test
    public void testGetRuolo() {
        System.out.println("getRuolo");
       
        String expResult = "ruolo";
        String result = eGet.getRuolo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCognome method, of class ExtraAzienda.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "Rossi";
       
        eSet.setCognome(cognome);
        assertEquals(cognome, eSet.getCognome());
    }

    /**
     * Test of setFax method, of class ExtraAzienda.
     */
    @Test
    public void testSetFax() {
        System.out.println("setFax");
        String fax = "089345678";
       
        eSet.setFax(fax);
        assertEquals(fax, eSet.getFax());
    }

    /**
     * Test of setNome method, of class ExtraAzienda.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Mario";
       
        eSet.setNome(nome);
        assertEquals(nome, eSet.getNome());
    }

    /**
     * Test of setPIva method, of class ExtraAzienda.
     */
    @Test
    public void testSetPIva() {
        System.out.println("setPIva");
        String pIva = "12345678901C";
        
        eSet.setPIva(pIva);
        assertEquals(pIva, eSet.getPIva());
         }

    /**
     * Test of setRagioneSociale method, of class ExtraAzienda.
     */
    @Test
    public void testSetRagioneSociale() {
        System.out.println("setRagioneSociale");
        String ragioneSociale = "x yz.srl";
       
        eSet.setRagioneSociale(ragioneSociale);
        assertEquals(ragioneSociale, eSet.getRagioneSociale());
    }

    /**
     * Test of setRuolo method, of class ExtraAzienda.
     */
    @Test
    public void testSetRuolo() {
        System.out.println("setRuolo");
        String ruolo = "ruolo";
        
        eSet.setRuolo(ruolo);
        assertEquals(ruolo, eSet.getRuolo());
    }

    /**
     * Test of removeAppuntamento method, of class ExtraAzienda.
     */
    @Test
    public void testRemoveAppuntamento() {
        System.out.println("removeAppuntamento");
        Appuntamento p = null;
      
        eGet.removeAppuntamento(p);
        assertEquals(app, eGet.getListAppuntamenti());
    }

    /**
     * Test of addAppuntamento method, of class ExtraAzienda.
     */
    @Test
    public void testAddAppuntamento() {
        System.out.println("addAppuntamento");
        Appuntamento p = null;
        
        eGet.addAppuntamento(p);
        assertEquals(app, eGet.getListAppuntamenti());
    }

    /**
     * Test of removeContratto method, of class ExtraAzienda.
     */
    @Test
    public void testRemoveContratto() {
        System.out.println("removeContratto");
        Contratto c = null;
        
        eGet.removeContratto(c);
        assertEquals(contr, eGet.getListContratti()) ;
    }

    /**
     * Test of addContratto method, of class ExtraAzienda.
     */
    @Test
    public void testAddContratto() {
        System.out.println("addContratto");
        Contratto c = null;
        
        eGet.addContratto(c);
        assertEquals(contr, eGet.getListContratti());
    }

    /**
     * Test of equals method, of class ExtraAzienda.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        
        boolean expResult = false;
        boolean result = eGet.equals(obj);
        assertEquals(expResult, result);
        
    }

}