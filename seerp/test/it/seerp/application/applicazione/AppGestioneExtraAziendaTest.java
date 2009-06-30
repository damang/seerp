

package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiContatto;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.Fornitore;
import java.util.ArrayList;
import javax.swing.JTextField;
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
public class AppGestioneExtraAziendaTest extends TestCase{
    private Cliente cl;
    private Contatto co;
    private Fornitore f;
    private Boolean v;
    private Integer id = 0;
    private Integer id1 = 1;
    private Integer id2 = 2;
    private ArrayList<Cliente> cli;
    private ArrayList<Contatto> con;
    private ArrayList<Fornitore> forn;
    private Integer feed = 4;


    public AppGestioneExtraAziendaTest(String name) {
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
        cl = new Cliente(id, "marros", "123456", "Salerno", "cliente","sa", "089345678", "84100", "rossi@email.it", "cliente", "note", v , "Rossi", "Mario", "x y z.srl", "1234567890C", "089232323" );
        f = new Fornitore (id1, "mardet", "324156", "Salerno", "fornitore","sa", "089330271", "84100", "mardet@email.it", "fornitore", "note", v , "De Tommaso", "Marialuna", "x y z.srl", "12345678901C", "089232323");
        co = new Contatto (id2, "biagio", "123456", "Salerno", "contatto","sa", "089345678", "84100", "biagio@email.it", "contatto", "note", v , "Bianchi", "Giovanni", "x y z.srl", "1234567890C", "089232323", feed);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of inserisciContatto method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testInserisciContatto() throws Exception {
        System.out.println("inserisciContatto");

        BeanGuiContatto cont = new BeanGuiContatto();

        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        instance.inserisciContatto(cont);
        
    }

    /**
     * Test of inserisciCliente method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testInserisciCliente() throws Exception {
        System.out.println("inserisciCliente");
        BeanGuiCliente clien = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        instance.inserisciCliente(clien);
        
    }

    /**
     * Test of visualizzaDatiCliente method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testVisualizzaDatiCliente() {
        System.out.println("visualizzaDatiCliente");
        int user = 0;
        BeanGuiCliente beanGui = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        instance.visualizzaDatiCliente(user, beanGui);
       
    }

    /**
     * Test of visualizzaDatiFornitore method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testVisualizzaDatiFornitore() {
        System.out.println("visualizzaDatiFornitore");
        int user = 0;
        BeanGuiFornitore beanGui = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        instance.visualizzaDatiFornitore(user, beanGui);
       
    }

    /**
     * Test of inserisciFornitore method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testInserisciFornitore() throws Exception {
        System.out.println("inserisciFornitore");
        BeanGuiFornitore forn = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        instance.inserisciFornitore(forn);
        
    }

    /**
     * Test of modificaContatto method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testModificaContatto() throws Exception {
        System.out.println("modificaContatto");
        int id = 0;
        BeanGuiContatto cont = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        BeanGuiContatto expResult = null;
        BeanGuiContatto result = instance.modificaContatto(id, cont);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modificaCliente method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testModificaCliente() throws Exception {
        System.out.println("modificaCliente");
        int id = 0;
        BeanGuiCliente clien = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        BeanGuiCliente expResult = null;
        BeanGuiCliente result = instance.modificaCliente(id, clien);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modificaFornitore method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testModificaFornitore() throws Exception {
        System.out.println("modificaFornitore");
        int id = 0;
        BeanGuiFornitore forn = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        BeanGuiFornitore expResult = null;
        BeanGuiFornitore result = instance.modificaFornitore(id, forn);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaTabellaCliente method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testVisualizzaTabellaCliente() {
        System.out.println("visualizzaTabellaCliente");
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.visualizzaTabellaCliente();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaTabellaFornitore method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testVisualizzaTabellaFornitore() {
        System.out.println("visualizzaTabellaFornitore");
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        ArrayList<Fornitore> expResult = null;
        ArrayList<Fornitore> result = instance.visualizzaTabellaFornitore();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of eliminaExtraAziena method, of class AppGestioneExtraAzienda.
     */
    @Test
    public void testEliminaExtraAziena() {
        System.out.println("eliminaExtraAziena");
        int id = 0;
        BeanGuiExtraAzienda e = null;
        AppGestioneExtraAzienda instance = new AppGestioneExtraAzienda();
        instance.eliminaExtraAziena(id, e);
        
    }

}