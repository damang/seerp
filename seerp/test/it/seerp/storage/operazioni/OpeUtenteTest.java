/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpeUtente;
import it.seerp.storage.ejb.Utente;
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
public class OpeUtenteTest extends TestCase{

    private Utente u;
    private Boolean v=true;
   private Integer id = 0;
    private ArrayList<Utente> ut;

    public OpeUtenteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        u = new Utente(id, "marros" , "123456" , "Salerno" ,
                  "sa" , "089345678" ,"84100", "rossi@email.it" ,
                  "ruolo" , "note" , v );

    }

    @After
    public void tearDown() {
        u=null;
        System.gc();
    }

    /**
     * Test of visualizzaElenco method, of class OpeUtente.
     */
    @Test
    public void testVisualizzaElenco() throws Exception {
        System.out.println("visualizzaElenco");
        ArrayList<Utente> ut = new ArrayList<Utente>();
        OpeUtente instance = new OpeUtente();
        ArrayList<Utente> expResult = ut;
        ArrayList<Utente> result = instance.visualizzaElenco();
        
        Iterator<Utente> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            Utente temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
            
        }

       
        
    }

    /**
     * Test of modifica method, of class OpeUtente.
     */
    @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        
        OpeUtente instance = new OpeUtente();
        Utente expResult = u;
        
        assertEquals(id,u.getIdUtente());
        assertEquals("marros",u.getUsername());
        assertEquals("123456",u.getPassword());
        assertEquals("Salerno",u.getCitta());
        
        assertEquals("sa", u.getProvincia());
        assertEquals("089345678",u.getTelefono());
        assertEquals("84100",u.getCap());
        assertEquals("rossi@email.it",u.getEmail());
        assertEquals("ruolo",u.getTipo());
        assertEquals("note",u.getNote());
        assertEquals(v, u.getVisible());

        Utente result = instance.modifica(u);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of inserimento method, of class OpeUtente.
     */
    @Test
    public void testInserimento() throws Exception {
        System.out.println("inserimento");
        
        OpeUtente instance = new OpeUtente();

        assertEquals(id,u.getIdUtente());
        assertEquals("marros",u.getUsername());
        assertEquals("123456",u.getPassword());
        assertEquals("Salerno",u.getCitta());

        assertEquals("sa", u.getProvincia());
        assertEquals("089345678",u.getTelefono());
        assertEquals("84100",u.getCap());
        assertEquals("rossi@email.it",u.getEmail());
        assertEquals("ruolo",u.getTipo());
        assertEquals("note",u.getNote());
        assertEquals(v, u.getVisible());

        instance.inserimento(u);

        
    }

    /**
     * Test of visualizza method, of class OpeUtente.
     */
    @Test
    public void testVisualizza() throws Exception {
        System.out.println("visualizza");
      
        OpeUtente instance = new OpeUtente();
        Utente expResult = null;
        Utente result = instance.visualizza(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ricerca method, of class OpeUtente.
     */
   /* @Test
    public void testRicerca() throws Exception {
        System.out.println("ricerca");
        OpeUtente instance = new OpeUtente();
        ArrayList<Utente> expResult = ut;
        ArrayList<Utente> result = instance.ricerca();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of eliminaLogica method, of class OpeUtente.
     */
    @Test
    public void testEliminaLogica() throws Exception {
        System.out.println("eliminaLogica");
        
        OpeUtente instance = new OpeUtente();
        instance.eliminaLogica(u);
        
        
    }

    /**
     * Test of elimina method, of class OpeUtente.
     */
  /*   @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpeUtente instance = new OpeUtente();
        instance.elimina(u);
       
    }
*/
}