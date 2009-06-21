

package it.seerp.storage.ejb;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author LuNy
 */
public class ResponsabileTest extends TestCase{

    private Responsabile r;
    private Integer id;
    private Boolean v;
    private Ruolo ru;

    public ResponsabileTest() {
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

}