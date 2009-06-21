/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author LuNy
 */
public class ClienteTest extends TestCase {

    private Cliente c;
    private Boolean v;
    private Integer id;

    public ClienteTest(String name) {

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

        c = new Cliente(id, "marros", "123456", "Salerno", "ruolo","sa", "089345678", "84100", "rossi@email.it", "ruolo", "note", v , "Rossi", "Mario", "x y z.srl", "12345678901C", "089232323" );
                  
    }

    @After
    public void tearDown() {

        c=null;
        System.gc();
    }
    

}