

package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpDipendente;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Ruolo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import junit.framework.TestCase;

/**
 *
 * @author LuNy
 */
public class OpDipendenteTest extends TestCase {
    
    private Dipendente d;
    private Integer id = 0;
    private Boolean v;
    private Ruolo r;
    private ArrayList<Dipendente> di;
    

    public OpDipendenteTest(String name) {
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
        d = new Dipendente(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "tipo", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",r, v);
        
    }

    @After
    public void tearDown() {
        d=null;
        System.gc();
    }

    /**
     * Test of elencaDipendente method, of class OpDipendente.
     */
    @Test
    public void testElencaDipendente() throws Exception {
        System.out.println("elencaDipendente");
        ArrayList<Dipendente> di = new ArrayList<Dipendente>();
        OpDipendente instance = new OpDipendente();
        ArrayList<Dipendente> expResult = di;
        ArrayList<Dipendente> result = instance.elencaDipendente();

        Iterator<Dipendente> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            Dipendente temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
        
    }

    /**
     * Test of ricercaDipendente method, of class OpDipendente.
     */
   /* @Test
    public void testRicercaDipendente() throws Exception {
        System.out.println("ricercaDipendente");
        OpDipendente instance = new OpDipendente();
        ArrayList<Dipendente> expResult = di;
        ArrayList<Dipendente> result = instance.ricercaDipendente();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of elimina method, of class OpDipendente.
     */
    @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpDipendente instance = new OpDipendente();
        instance.elimina(d);
       
    }

    /**
     * Test of eliminazioneLogica method, of class OpDipendente.
     */
  /*  @Test
    public void testEliminazioneLogica() throws Exception {
        System.out.println("eliminazioneLogica");
        
        OpDipendente instance = new OpDipendente();
        instance.eliminazioneLogica(d);
       
    }

    /**
     * Test of inserisci method, of class OpDipendente.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
       
        OpDipendente instance = new OpDipendente();
        Integer id1= new Integer(0);
        Dipendente c= new Dipendente(id1,"ilaant","1203892", "Salerno","sa", "089567890","84100","ilaant@email.it","abcferd","dipendente","Anzivino","Ilaria","NZNLRA89B60H703C",r,v);
        instance.inserisci(c);
        assertEquals("ilaant",c.getUsername());
        assertEquals("1203892",c.getPassword());
        assertEquals("Salerno",c.getCitta());
        assertEquals("sa", c.getProvincia());
        assertEquals("089567890",c.getTelefono());
        assertEquals("84100",c.getCap());
        assertEquals("ilaantt@email.it",c.getEmail());
        assertEquals("abcferd",c.getNote());
        assertEquals("dipendente", c.getTipo());
        assertEquals("Anzivino",c.getCognome());
        assertEquals("Ilaria",c.getNome());
        assertEquals("NZNLRA89B60H703C",c.getCodiceFiscale());
        assertEquals(r,c.getRuolo());
        assertEquals(v, c.getVisible());
        
        
    }

    /**
     * Test of modifica method, of class OpDipendente.
     */
  /*  @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        Dipendente user = null;
        OpDipendente instance = new OpDipendente();
        Dipendente expResult = null;

          assertEquals(id,d.getIdUtente());
        assertEquals("marros",d.getUsername());
        assertEquals("123456",d.getPassword());
        assertEquals("Salerno",d.getCitta());
        assertEquals("sa", d.getProvincia());
        assertEquals("089345678",d.getTelefono());
        assertEquals("84100",d.getCap());
        assertEquals("rossi@email.it",d.getEmail());
        assertEquals("note",d.getNote());
        assertEquals("tipo", d.getTipo());
        assertEquals("Rossi",d.getCognome());
        assertEquals("Mario",d.getNome());
        assertEquals("RSSMRO45B21H703C",d.getCodiceFiscale());
        assertEquals(r,d.getRuolo());
        assertEquals(v, d.getVisible());

        Dipendente result = instance.modifica(user);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of visualizzaDati method, of class OpDipendente.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
      
        OpDipendente instance = new OpDipendente();
        Dipendente expResult = null;
        Dipendente result = instance.visualizzaDati(id);
        assertEquals(expResult, result);
        
    }

}