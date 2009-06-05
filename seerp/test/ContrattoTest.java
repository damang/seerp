

import it.seerp.storage.ejb.Contratto;
import java.sql.Date;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ila
 */
public class ContrattoTest extends TestCase{

    private Contratto c;
    private Date d;

    public ContrattoTest(String nome) {
        super(nome);
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {

    }

    @Before
    public void setUp() {
        d = new Date(58,02,12);

        c=new Contratto("Pagata", d, 12, "pesce",
            "non la voglio pagare", 12, 12);
    }

    @After
    public void tearDown() {
         c=null;
    }

    public void testStato(){
        assertEquals("Pagata", c.getStato());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}