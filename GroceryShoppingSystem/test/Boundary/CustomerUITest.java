
package Boundary;

import DTO.BasketDTO;
import DTO.ProductDTO;
import gateway.ProductGateway;
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
public class CustomerUITest {
    
    public CustomerUITest() {
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
     * Test of setStoreID method, of class CustomerUI.
     */
    @Test
    public void testSetStoreID() {
        System.out.println("setStoreID");
        int storeID = 1;
        CustomerUI instance = new CustomerUI();
        boolean result = instance.setStoreID(storeID);
        assertTrue(result);
       
    }

    /**
     * Test of retrieveStoreID method, of class CustomerUI.
     */
    @Test
    public void testRetrieveStoreID() {
        System.out.println("retrieveStoreID");
        CustomerUI instance = new CustomerUI();
        ProductGateway gate = new ProductGateway();
        int expResult = gate.findStoreID();        
        int result = instance.retrieveStoreID();
        assertEquals(expResult, result);
        
    }   

    /**
     * Test of addGrocerie method, of class CustomerUI.
     */
    @Test
    public void testAddGrocerie() {
        System.out.println("addGrocarie");
        ProductDTO p = new ProductDTO(5,"tomato",20,2.5);
        CustomerUI instance = new CustomerUI();
        boolean result = instance.addGrocerie(p);
        assertTrue(result);
        
    }

    /**
     * Test of removeGrocerie method, of class CustomerUI.
     */
    @Test
    public void testRemoveGrocerie() {
        System.out.println("removeGrocerie");
        BasketDTO p = new BasketDTO(8,"tomato",20,2.5);
        CustomerUI instance = new CustomerUI();
        boolean result = instance.removeGrocerie(p);
        assertTrue(result);
        
    }

    /**
     * Test of checkCustomerCredentials method, of class CustomerUI.
     */
    @Test
    public void testCheckCustomerCredentials() {
        System.out.println("checkCustomerCredentials");
        String customerName = "Krzychu";
        String custPassword = "123";
        CustomerUI instance = new CustomerUI();
        boolean result = instance.checkCustomerCredentials(customerName, custPassword);
        assertTrue(result);
        
    }

    /**
     * Test of clearBasket method, of class CustomerUI.
     */
    @Test
    public void testClearBasket() {
        System.out.println("clearBasket");
        CustomerUI instance = new CustomerUI();
        boolean result = instance.clearBasket();
        assertTrue(result);
       
    }

    /**
     * Test of clearAllFlags method, of class CustomerUI.
     */
    @Test
    public void testClearAllFlags() {
        System.out.println("clearAllFlags");
        CustomerUI instance = new CustomerUI();
        boolean result = instance.clearAllFlags();
        assertTrue(result);
       
    }

    /**
     * Test of registerCustomer method, of class CustomerUI.
     */
    @Test
    public void testRegisterCustomer() {
        System.out.println("registerCustomer");
        String customerName = "Krzychu";
        String custPassword1 = "123";
        CustomerUI instance = new CustomerUI();
        boolean result = instance.registerCustomer(customerName, custPassword1);
        assertTrue(result);        
    }
    
}
