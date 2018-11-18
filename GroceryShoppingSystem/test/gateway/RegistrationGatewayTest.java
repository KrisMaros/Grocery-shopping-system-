
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
public class RegistrationGatewayTest {
    
    public RegistrationGatewayTest() {
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
     * Test of registerCustomer method, of class RegistrationGateway.
     */
    @Test
    public void testRegisterCustomer() {
        System.out.println("registerCustomer");
        String customerName = "Krzychu";
        String custPassword1 = "123";
        RegistrationGateway instance = new RegistrationGateway();
        boolean result = instance.registerCustomer(customerName, custPassword1);
        assertTrue(result);
        
    }

    /**
     * Test of registerAdministrator method, of class RegistrationGateway.
     */
    @Test
    public void testRegisterAdministrator() {
        System.out.println("registerAdministrator");
        String adminName = "Krzychu";
        String adminPassword1 = "123";
        RegistrationGateway instance = new RegistrationGateway();  
        boolean result = instance.registerAdministrator(adminName, adminPassword1);
        assertTrue(result);
        
    }
    
}
