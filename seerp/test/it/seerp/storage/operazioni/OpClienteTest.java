

package it.seerp.storage.operazioni;

import it.seerp.storage.Operazioni.OpCliente;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.ExtraAzienda;
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
public class OpClienteTest extends TestCase{
    private Cliente c;
    private Boolean v;
    private Integer id;
    private ArrayList<Cliente> con;
   
    


    public OpClienteTest(String name) {
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
        c = new Cliente(id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "1234567890C", "089232323" );

    }

    @After
    @Override
    public void tearDown() {
        c=null;
        System.gc();
    }

    /**
     * Test of elencaCliente method, of class OpCliente.
     */
    @Test
    public void testElencaCliente() throws Exception {
         System.out.println("elencaCliente");
         ArrayList<Cliente> con = new ArrayList<Cliente>();
        OpCliente instance = new OpCliente();
        ArrayList<Cliente> expResult = con;
        ArrayList<Cliente> result = instance.elencaCliente();

        Iterator<Cliente> it = expResult.iterator();
        int i = 0;
        while(it.hasNext()) {
            Cliente temp = it.next();
            assertEquals(temp, result.get(i));
            i++;
        }
       
    }

    /**
     * Test of ricercaCliente method, of class OpCliente.
     */
   /* @Test
    public void testRicercaCliente() throws Exception {
        System.out.println("ricercaCliente");
        String cognome = "Rossi";
        String ruolo = "ruolo";
        OpCliente instance = new OpCliente();
        ArrayList<Cliente> expResult = con;
        ArrayList<Cliente> result = instance.ricercaCliente(cognome, ruolo);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of elimina method, of class OpCliente.
     */
 /*   @Test
    public void testElimina() throws Exception {
        System.out.println("elimina");
        
        OpCliente instance = new OpCliente();
        instance.elimina(c);
       
    }

    /**
     * Test of inserisci method, of class OpCliente.
     */
    @Test
    public void testInserisci() throws Exception {
        System.out.println("inserisci");
       
        OpCliente instance = new OpCliente();

    

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
     * Test of modifica method, of class OpCliente.
     */
 /*   @Test
    public void testModifica() throws Exception {
        System.out.println("modifica");
        
        OpCliente instance = new OpCliente();
        Cliente expResult = null;

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

       ExtraAzienda result = instance.modifica(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaDati method, of class OpCliente.
     */
    @Test
    public void testVisualizzaDati() throws Exception {
        System.out.println("visualizzaDati");
        Integer id = 12;
       
        OpCliente instance = new OpCliente();
        Cliente expResult = null;
        Cliente result = instance.visualizzaDati(12);
        assertEquals(expResult, result);
        
    }

}