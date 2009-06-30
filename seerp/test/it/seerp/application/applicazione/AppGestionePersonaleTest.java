/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Responsabile;
import it.seerp.storage.ejb.Ruolo;
import java.util.ArrayList;
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
public class AppGestionePersonaleTest extends TestCase{
    private Dipendente d;
    private Responsabile r;
    private Integer id = 0;
    private Boolean v;
    private Ruolo ruolo = new Ruolo("ruolo");
    private Ruolo ru = new Ruolo("ruolo");
    private ArrayList<Dipendente> di;


    public AppGestionePersonaleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        d = new Dipendente(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "tipo", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",ruolo, v);
        r = new Responsabile(id, "marros", "123456", "Salerno", "sa", "089345678", "84100", "rossi@email.it", "note", "tipo", "Rossi", "Mario", "RSSMRO45B21H703C",ru, v);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of inserisciDipendente method, of class AppGestionePersonale.
     */
    @Test
    public void testInserisciDipendente() throws Exception {
        System.out.println("inserisciDipendente");
        BeanGuiDipendente user = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.inserisciDipendente(user);
        
    }

    /**
     * Test of inserisciResponsabile method, of class AppGestionePersonale.
     */
    @Test
    public void testInserisciResponsabile() throws Exception {
        System.out.println("inserisciResponsabile");
        BeanGuiResponsabile user = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.inserisciResponsabile(user);
        
    }

    /**
     * Test of modificaDipendente method, of class AppGestionePersonale.
     */
    @Test
    public void testModificaDipendente() throws Exception {
        System.out.println("modificaDipendente");
        int id = 0;
        BeanGuiDipendente user = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        BeanGuiDipendente expResult = null;
        BeanGuiDipendente result = instance.modificaDipendente(id, user);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of modificaAmministratore method, of class AppGestionePersonale.
     */
    @Test
    public void testModificaAmministratore() throws Exception {
        System.out.println("modificaAmministratore");
        BeanGuiAmministratore user = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        BeanGuiAmministratore expResult = null;
        BeanGuiAmministratore result = instance.modificaAmministratore(user);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modificaResponsabile method, of class AppGestionePersonale.
     */
    @Test
    public void testModificaResponsabile() throws Exception {
        System.out.println("modificaResponsabile");
        int id = 0;
        BeanGuiResponsabile user = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        BeanGuiResponsabile expResult = null;
        BeanGuiResponsabile result = instance.modificaResponsabile(id, user);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaTabellaDipendenti method, of class AppGestionePersonale.
     */
    @Test
    public void testVisualizzaTabellaDipendenti() {
        System.out.println("visualizzaTabellaDipendenti");
        AppGestionePersonale instance = new AppGestionePersonale();
        ArrayList<Dipendente> expResult = null;
        ArrayList<Dipendente> result = instance.visualizzaTabellaDipendenti();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaTabellaPersonaleRuolo method, of class AppGestionePersonale.
     */
    @Test
    public void testVisualizzaTabellaPersonaleRuolo() throws Exception {
        System.out.println("visualizzaTabellaPersonaleRuolo");
        Ruolo r = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        ArrayList<Personale> expResult = null;
        ArrayList<Personale> result = instance.visualizzaTabellaPersonaleRuolo(r);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaTabellaPersonale method, of class AppGestionePersonale.
     */
    @Test
    public void testVisualizzaTabellaPersonale() throws Exception {
        System.out.println("visualizzaTabellaPersonale");
        AppGestionePersonale instance = new AppGestionePersonale();
        ArrayList<Personale> expResult = null;
        ArrayList<Personale> result = instance.visualizzaTabellaPersonale();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of visualizzaTabellaResponsabili method, of class AppGestionePersonale.
     */
    @Test
    public void testVisualizzaTabellaResponsabili() {
        System.out.println("visualizzaTabellaResponsabili");
        AppGestionePersonale instance = new AppGestionePersonale();
        ArrayList<Responsabile> expResult = null;
        ArrayList<Responsabile> result = instance.visualizzaTabellaResponsabili();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of eliminaDipendente method, of class AppGestionePersonale.
     */
    @Test
    public void testEliminaDipendente() {
        System.out.println("eliminaDipendente");
        int id = 0;
        BeanGuiDipendente beanGui = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.eliminaDipendente(id, beanGui);
        
    }

    /**
     * Test of eliminaResponsabile method, of class AppGestionePersonale.
     */
    @Test
    public void testEliminaResponsabile() {
        System.out.println("eliminaResponsabile");
        int id = 0;
        BeanGuiResponsabile beanGui = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.eliminaResponsabile(id, beanGui);
        
    }

    /**
     * Test of eliminaFornitore method, of class AppGestionePersonale.
     */
    @Test
    public void testEliminaFornitore() {
        System.out.println("eliminaFornitore");
        int id = 0;
        BeanGuiFornitore beanGui = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.eliminaFornitore(id, beanGui);
        
    }

    /**
     * Test of visualizzaDatiResponsabile method, of class AppGestionePersonale.
     */
    @Test
    public void testVisualizzaDatiResponsabile() {
        System.out.println("visualizzaDatiResponsabile");
        int user = 0;
        BeanGuiResponsabile beanGui = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.visualizzaDatiResponsabile(user, beanGui);
       
    }

    /**
     * Test of visualizzaDatiDipendente method, of class AppGestionePersonale.
     */
    @Test
    public void testVisualizzaDatiDipendente() {
        System.out.println("visualizzaDatiDipendente");
        int user = 0;
        BeanGuiDipendente beanGui = null;
        AppGestionePersonale instance = new AppGestionePersonale();
        instance.visualizzaDatiDipendente(user, beanGui);
        
    }

}