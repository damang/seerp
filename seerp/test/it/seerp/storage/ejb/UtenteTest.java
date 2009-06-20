

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
    private Utente u;
    private Boolean v;
    private Integer id;

    public UtenteTest() {
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
     * Test of getCap method, of class Utente.
     */
    @Test
    public void testGetCap() {
        System.out.println("getCap");

        String expResult = "84100";
        String result = u.getCap();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCap method, of class Utente.
     */
    @Test
    public void testSetCap() {
        System.out.println("setCap");
        String cap = "84100";

        u.setCap(cap);
        assertEquals("84100", u.getCap());
    }

    /**
     * Test of getTipo method, of class Utente.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");

        String expResult = "ruolo";
        String result = u.getTipo();
        assertEquals(expResult, result);

    }

    /**
     * Test of setVisible method, of class Utente.
     */
    @Test
    public void testSetVisible() {
        System.out.println("setVisible");

        u.setVisible(true);

    }

    /**
     * Test of getVisible method, of class Utente.
     */
    @Test
    public void testGetVisible() {
        System.out.println("getVisible");

        Boolean expResult = true;
        Boolean result = u.getVisible();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNote method, of class Utente.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");

        String expResult = "note";
        String result = u.getNote();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNote method, of class Utente.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "note";

        u.setNote(note);

    }

    /**
     * Test of getCitta method, of class Utente.
     */
    @Test
    public void testGetCitta() {
        System.out.println("getCitta");

        String expResult = "Salerno";
        String result = u.getCitta();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEmail method, of class Utente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");

        String expResult = "rossi@email.it";
        String result = u.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of getIdUtente method, of class Utente.
     */
    @Test
    public void testGetIdUtente() {
        System.out.println("getIdUtente");

        Integer expResult = id;
        Integer result = u.getIdUtente();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPassword method, of class Utente.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");

        String expResult = "123456";
        String result = u.getPassword();
        assertEquals(expResult, result);

    }

    /**
     * Test of getProvincia method, of class Utente.
     */
    @Test
    public void testGetProvincia() {
        System.out.println("getProvincia");

        String expResult = "Sa";
        String result = u.getProvincia();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTelefono method, of class Utente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");

        String expResult = "089345678";
        String result = u.getTelefono();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUsername method, of class Utente.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");

        String expResult = "marros";
        String result = u.getUsername();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTipo method, of class Utente.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "tipo";

        u.setTipo(tipo);
        assertEquals("tipo",u.getTipo());
    }

    /**
     * Test of setCitta method, of class Utente.
     */
    @Test
    public void testSetCitta() {
        System.out.println("setCitta");
        String citta = "Salerno";

        u.setCitta(citta);
        assertEquals("Salerno",u.getCitta());
    }

    /**
     * Test of setEmail method, of class Utente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "rossi@email.it";

        u.setEmail(email);
        assertEquals("rossi@email.it",u.getEmail());
    }

    /**
     * Test of setIdUtente method, of class Utente.
     */
    @Test
    public void testSetIdUtente() {
        System.out.println("setIdUtente");

        u.setIdUtente(id);
        assertEquals(id,u.getIdUtente());

    }

    /**
     * Test of setPassword method, of class Utente.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "123456";

        u.setPassword(password);
        assertEquals("123456",u.getPassword());

    }

    /**
     * Test of setProvincia method, of class Utente.
     */
    @Test
    public void testSetProvincia() {
        System.out.println("setProvincia");
        String provincia = "Sa";

        u.setProvincia(provincia);
        assertEquals("Sa",u.getProvincia());
    }

    /**
     * Test of setTelefono method, of class Utente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "089345678";

        u.setTelefono(telefono);
        assertEquals("089345678",u.getTelefono());
    }

    /**
     * Test of setUsername method, of class Utente.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Rossi";

        u.setUsername(username);
        assertEquals("Rossi",u.getUsername());
    }

    /**
     * Test of equals method, of class Utente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;

        boolean expResult = true;
        boolean result = u.equals(obj);
        assertEquals(expResult, result);

    }


}