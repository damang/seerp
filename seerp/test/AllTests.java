/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestSuite;
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
public class AllTests
{

public static Test suite()
{
    TestSuite suite = new TestSuite("Test for testing");

    suite.addTestSuite(ContrattoTest.class);

    return (Test) suite;
}

}