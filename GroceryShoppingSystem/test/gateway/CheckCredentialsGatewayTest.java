
package gateway;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krzychu-x
 */
public class CheckCredentialsGatewayTest {
    
    public CheckCredentialsGatewayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkCustomerCredentials method, of class CheckCredentialsGateway.
     */
    @Test
    public void testCheckCustomerCredentials() {
        System.out.println("checkCustomerCredentials");
        String customerName = "Krzychu";
        String custPassword = "123";
        CheckCredentialsGateway instance = new CheckCredentialsGateway();
        boolean result = instance.checkCustomerCredentials(customerName, custPassword);
        assertTrue(result);
        
    }

    /**
     * Test of checkAdminCredentials method, of class CheckCredentialsGateway.
     */
    @Test
    public void testCheckAdminCredentials() {
        System.out.println("checkAdminCredentials");
        String adminName = "Krzychu";
        String adminPassword = "123";
        CheckCredentialsGateway instance = new CheckCredentialsGateway();
        boolean result = instance.checkAdminCredentials(adminName, adminPassword);
        assertTrue(result);
        
    }

    /**
     * Test of clearBasket method, of class CheckCredentialsGateway.
     */
    @Test
    public void testClearBasket() {
        System.out.println("clearBasket");
        CheckCredentialsGateway instance = new CheckCredentialsGateway();
        boolean result = instance.clearBasket();
        assertTrue(result);
        
    }

    /**
     * Test of clearAllFlags method, of class CheckCredentialsGateway.
     */
    @Test
    public void testClearAllFlags() {
        System.out.println("clearAllFlags");
        CheckCredentialsGateway instance = new CheckCredentialsGateway();
        boolean result = instance.clearAllFlags();
        assertTrue(result);
        
    }

    /**
     * Test of setAdminFlag method, of class CheckCredentialsGateway.
     */
    @Test
    public void testSetAdminFlag() {
        System.out.println("setAdminFlag");
        boolean adminCredentialsOK = true;
        CheckCredentialsGateway instance = new CheckCredentialsGateway();
        boolean result = instance.setAdminFlag(adminCredentialsOK);
        assertTrue(result);
        
    }
    
}
