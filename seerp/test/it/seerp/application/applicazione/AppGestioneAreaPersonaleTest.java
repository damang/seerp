/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiUtente;
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
public class AppGestioneAreaPersonaleTest {

    public AppGestioneAreaPersonaleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of visualizzaDati method, of class AppGestioneAreaPersonale.
     */
    @Test
    public void testVisualizzaDati() {
        System.out.println("visualizzaDati");
        int id = 0;
        BeanGuiUtente beanGui = null;
        AppGestioneAreaPersonale instance = new AppGestioneAreaPersonale();
        BeanGuiUtente expResult = null;
        BeanGuiUtente result = instance.visualizzaDati(id, beanGui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaPassword method, of class AppGestioneAreaPersonale.
     */
    @Test
    public void testModificaPassword() {
        System.out.println("modificaPassword");
        BeanGuiUtente beanGui = null;
        AppGestioneAreaPersonale instance = new AppGestioneAreaPersonale();
        BeanGuiUtente expResult = null;
        BeanGuiUtente result = instance.modificaPassword(beanGui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaDatiPersonale method, of class AppGestioneAreaPersonale.
     */
    @Test
    public void testVisualizzaDatiPersonale() {
        System.out.println("visualizzaDatiPersonale");
        String id = "";
        BeanGuiPersonale beanGui = null;
        AppGestioneAreaPersonale instance = new AppGestioneAreaPersonale();
        instance.visualizzaDatiPersonale(id, beanGui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaDatiExtraAzienda method, of class AppGestioneAreaPersonale.
     */
    @Test
    public void testVisualizzaDatiExtraAzienda() {
        System.out.println("visualizzaDatiExtraAzienda");
        String id = "";
        BeanGuiExtraAzienda beanGui = null;
        AppGestioneAreaPersonale instance = new AppGestioneAreaPersonale();
        instance.visualizzaDatiExtraAzienda(id, beanGui);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}