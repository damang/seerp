

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

    private Contatto co;
    private Boolean v;
    private Integer id = 1;
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
        co = new Contatto (id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "1234567890C", "089232323", 4);

    }

    @After
    public void tearDown() {
        co = null;
        System.gc();
    }

    /**
     * Test of elencaContatto method, of class OpContatto.
     */
    @Test
    public void testElencaContatto() throws Exception {
        System.out.println("elencaContatto");
        ArrayList<Contatto> con = new ArrayList<Contatto>();
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
     * Test of inserisci method, of class OpContatto.
     */
    @Test
    public void testInserisci() throws Exception {
       System.out.println("inserisci");

        OpContatto instance = new OpContatto();
        Integer id1= new Integer(0);
        Integer f = new Integer(4);
        Contatto c= new Contatto(id1,"mardet","200282", "Salerno","contatto","sa", "089330271","84100","mardet@email.it","contatto","abcferd",v,"DeTommaso","Marialuna","B&B.srl","2343234323D","089232323", f);
        instance.inserisci(c);
        assertEquals("mardet",c.getUsername());
        assertEquals("200282",c.getPassword());
        assertEquals("Salerno",c.getCitta());
        assertEquals("contatto",c.getRuolo());
        assertEquals("sa", c.getProvincia());
        assertEquals("089330271",c.getTelefono());
        assertEquals("84100",c.getCap());
        assertEquals("mardet@email.it",c.getEmail());
        assertEquals("contatto",c.getRuolo());
        assertEquals("abcferd",c.getNote());
        assertEquals(v, c.getVisible());
        assertEquals("DeTommaso",c.getCognome());
        assertEquals("Marialuna",c.getNome());
        assertEquals("B&B.srl",c.getRagioneSociale());
        assertEquals("2343234323D",c.getPIva());
        assertEquals("089232323",c.getFax());
        assertEquals(f, c.getFeedback());


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