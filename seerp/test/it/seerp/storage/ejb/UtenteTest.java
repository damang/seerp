

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
public class UtenteTest extends TestCase{
    private Utente uSet;
    private Utente uGet;
    private Boolean v;
    private Integer id;

    public UtenteTest(String name) {
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

        uSet = new Utente(id, "marros" , "123456" , "Salerno" ,
                  "sa" , "089345678" ,"84100", "rossi@email.it" ,
                  "ruolo" , "note" , v );

        uGet = new Utente(id, "marros" , "123456" , "Salerno" ,
                  "sa" , "089345678" ,"84100", "rossi@email.it" ,
                  "ruolo" , "note" , v );
    }

    @After
    @Override
    public void tearDown() {
        uGet=null;
        System.gc();
    }

    /**
     * Test of getCap method, of class Utente.
     */
    @Test
    public void testGetCap() {
        System.out.println("getCap");

        String expResult = "84100";
        String result = uGet.getCap();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCap method, of class Utente.
     */
    @Test
    public void testSetCap() {
        System.out.println("setCap");
        String cap = "84100";

        uSet.setCap(cap);
        assertEquals("84100", uGet.getCap());
    }

    /**
     * Test of getTipo method, of class Utente.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");

        String expResult = "ruolo";
        String result = uGet.getTipo();
        assertEquals(expResult, result);

    }

    /**
     * Test of setVisible method, of class Utente.
     */
    @Test
    public void testSetVisible() {
        System.out.println("setVisible");
        Boolean visible = v;
        uSet.setVisible(visible);
        assertEquals(v, uSet.getVisible());

    }

    /**
     * Test of getVisible method, of class Utente.
     */
    @Test
    public void testGetVisible() {
        System.out.println("getVisible");

        Boolean expResult = v;
        Boolean result = uGet.getVisible();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNote method, of class Utente.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");

        String expResult = "note";
        String result = uGet.getNote();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNote method, of class Utente.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "note";

        uSet.setNote(note);
        assertEquals(note, uSet.getNote());

    }

    /**
     * Test of getCitta method, of class Utente.
     */
    @Test
    public void testGetCitta() {
        System.out.println("getCitta");

        String expResult = "Salerno";
        String result = uGet.getCitta();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEmail method, of class Utente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");

        String expResult = "rossi@email.it";
        String result = uGet.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of getIdUtente method, of class Utente.
     */
    @Test
    public void testGetIdUtente() {
        System.out.println("getIdUtente");

        Integer expResult = id;
        Integer result = uGet.getIdUtente();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPassword method, of class Utente.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");

        String expResult = "123456";
        String result = uGet.getPassword();
        assertEquals(expResult, result);

    }

    /**
     * Test of getProvincia method, of class Utente.
     */
    @Test
    public void testGetProvincia() {
        System.out.println("getProvincia");

        String expResult = "sa";
        String result = uGet.getProvincia();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTelefono method, of class Utente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");

        String expResult = "089345678";
        String result = uGet.getTelefono();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUsername method, of class Utente.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");

        String expResult = "marros";
        String result = uGet.getUsername();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTipo method, of class Utente.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "tipo";

        uSet.setTipo(tipo);
        assertEquals("tipo",uSet.getTipo());
    }

    /**
     * Test of setCitta method, of class Utente.
     */
    @Test
    public void testSetCitta() {
        System.out.println("setCitta");
        String citta = "Salerno";

        uSet.setCitta(citta);
        assertEquals("Salerno",uSet.getCitta());
    }

    /**
     * Test of setEmail method, of class Utente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "rossi@email.it";

        uSet.setEmail(email);
        assertEquals("rossi@email.it",uSet.getEmail());
    }

    /**
     * Test of setIdUtente method, of class Utente.
     */
    @Test
    public void testSetIdUtente() {
        System.out.println("setIdUtente");

        uSet.setIdUtente(id);
        assertEquals(id,uSet.getIdUtente());

    }

    /**
     * Test of setPassword method, of class Utente.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "123456";

        uSet.setPassword(password);
        assertEquals("123456",uSet.getPassword());

    }

    /**
     * Test of setProvincia method, of class Utente.
     */
    @Test
    public void testSetProvincia() {
        System.out.println("setProvincia");
        String provincia = "Sa";

        uSet.setProvincia(provincia);
        assertEquals("Sa",uSet.getProvincia());
    }

    /**
     * Test of setTelefono method, of class Utente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "089345678";

        uSet.setTelefono(telefono);
        assertEquals("089345678",uSet.getTelefono());
    }

    /**
     * Test of setUsername method, of class Utente.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Rossi";

        uSet.setUsername(username);
        assertEquals("Rossi",uSet.getUsername());
    }

    /**
     * Test of equals method, of class Utente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;

        boolean expResult = false;
        boolean result = uGet.equals(obj);
        assertEquals(expResult, result);

    }


}