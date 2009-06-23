/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpResponsabile;
import it.seerp.storage.ejb.Responsabile;
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
public class OpResponsabileTest extends TestCase{
    private Responsabile r;
    private Integer id = 0;
    private Boolean v;
    private Ruolo ru = new Ruolo("ruolo");
    private ArrayList<Responsabile> resp;

    public OpResponsabileTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        r = new Responsabile(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",ru, v);

    }

    @After
    public void tearDown() {
        r=null;
        System.gc();
    }

    /**
     * Test of elencaResponsabile method, of class OpResponsabile.
     */
    @Test
    public void testElencaResponsabile() throws Exception {
        System.out.println("elencaResponsabile");
        OpResponsabile instance = new OpResponsabile();
        ArrayList<Responsabile> expResult = resp;
        ArrayList<Responsabile> result = instance.elencaResponsabile();

        Iterator<Responsabile> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            Responsabile temp = it.next();
            assertEquals(temp, result.get(i));
            i++;

        }
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ricercaResponsabile method, of class OpResponsabile.
     */
 /*   @Test
    public void testRicercaResponsabile() throws Exception {
        System.out.println("ricercaResponsabile");
        OpResponsabile instance = new OpResponsabile();
        ArrayList<Responsabile> expResult = resp;
        ArrayList<Responsabile> result = instance.ricercaResponsabile();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of elimina method, of class OpResponsabile.
     */
    @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpResponsabile instance = new OpResponsabile();
        instance.elimina(r);
        
    }

    /**
     * Test of eliminazioneLogica method, of class OpResponsabile.
     */
 /*   @Test
    public void testEliminazioneLogica() throws Exception {
        System.out.println("eliminazioneLogica");
        
        OpResponsabile instance = new OpResponsabile();
        instance.eliminazioneLogica(r);
       
    }

    /**
     * Test of inserisci method, of class OpResponsabile.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
        
        OpResponsabile instance = new OpResponsabile();

        assertEquals(id,r.getIdUtente());
        assertEquals("marros",r.getUsername());
        assertEquals("123456",r.getPassword());
        assertEquals("Salerno",r.getCitta());
        assertEquals(ru,r.getRuolo());
        assertEquals("sa", r.getProvincia());
        assertEquals("089345678",r.getTelefono());
        assertEquals("84100",r.getCap());
        assertEquals("rossi@email.it",r.getEmail());
        assertEquals(ru,r.getRuolo());
       
        assertEquals(v, r.getVisible());
        assertEquals("Rossi",r.getCognome());
        assertEquals("Mario",r.getNome());
        assertEquals(ru,r.getRuolo());

        instance.inserisci(r);
       
    }

    /**
     * Test of modifica method, of class OpResponsabile.
     */
 /*   @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        
        OpResponsabile instance = new OpResponsabile();
        Responsabile expResult = null;

        assertEquals(id,r.getIdUtente());
        assertEquals("marros",r.getUsername());
        assertEquals("123456",r.getPassword());
        assertEquals("Salerno",r.getCitta());
        assertEquals("ruolo",r.getRuolo());
        assertEquals("sa", r.getProvincia());
        assertEquals("089345678",r.getTelefono());
        assertEquals("84100",r.getCap());
        assertEquals("rossi@email.it",r.getEmail());
        assertEquals("ruolo",r.getRuolo());
        assertEquals("note",r.getNote());
        assertEquals(v, r.getVisible());
        assertEquals("Rossi",r.getCognome());
        assertEquals("Mario",r.getNome());
        assertEquals(ru,r.getRuolo());


        Responsabile result = instance.modifica(r);
        assertEquals(expResult, result);
        
    }*/

    /**
     * Test of visualizzaPersonale method, of class OpResponsabile.
     */
    @Test
    public void testVisualizzaResponsabile() throws Exception {
        System.out.println("visualizzaPersonale");
        Integer idc = 12;
        OpResponsabile instance = new OpResponsabile();
        Responsabile expResult = r;
        Responsabile result = instance.visualizzaResponsabile(idc);
        assertEquals(expResult, result);
        
    }

}