
package Boundary;

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
public class AdministratorUITest {
    
    public AdministratorUITest() {
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
     * Test of editProductDetails method, of class AdministratorUI.
     */
    @Test
    public void testEditProductDetails() {
        System.out.println("editProductDetails");
        String productName = "tomato";
        int quantity = 0;
        double price = 0.0;
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.editProductDetails(productName, quantity, price);
        assertTrue(result);
        
    }

    /**
     * Test of setProductID method, of class AdministratorUI.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        int productID = 4;
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.setProductID(productID);
        assertTrue(result);
        
    }

    /**
     * Test of getProductID method, of class AdministratorUI.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        AdministratorUI instance = new AdministratorUI();
        ProductGateway gate = new ProductGateway();
        int expResult = gate.findProductID();
        int result = instance.getProductID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addNewGroceries method, of class AdministratorUI.
     */
    @Test
    public void testAddNewGroceries() {
        System.out.println("addNewGroceries");
        String productName = "tomato";
        int quantity = 0;
        double price = 0.0;
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.addNewGroceries(productName, quantity, price);
        assertTrue(result);
        
    }

    /**
     * Test of deleteGrocery method, of class AdministratorUI.
     */
    @Test
    public void testDeleteGrocery() {
        System.out.println("deleteGrocery");
        int productID = 8;
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.deleteGrocery(productID);
        assertTrue(result);
        
    }

    /**
     * Test of checkAdminCredentials method, of class AdministratorUI.
     */
    @Test
    public void testCheckAdminCredentials() {
        System.out.println("checkAdminCredentials");
        String adminName = "Krzychu";
        String adminPassword = "123";
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.checkAdminCredentials(adminName, adminPassword);
        assertTrue(result);
        
    }

    /**
     * Test of setAdminFlag method, of class AdministratorUI.
     */
    @Test
    public void testSetAdminFlag() {
        System.out.println("setAdminFlag");
        boolean adminCredentialsOK = true;
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.setAdminFlag(adminCredentialsOK);
        assertTrue(result);
        
    }

    /**
     * Test of registerAdministrator method, of class AdministratorUI.
     */
    @Test
    public void testRegisterAdministrator() {
        System.out.println("registerAdministrator");
        String adminName = "Krzychu";
        String adminPassword1 = "123";
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.registerAdministrator(adminName, adminPassword1);
        assertTrue(result);
        
    }

    /**
     * Test of getAdminFlag method, of class AdministratorUI.
     */
    @Test
    public void testGetAdminFlag() {
        System.out.println("getAdminFlag");
        AdministratorUI instance = new AdministratorUI();
        boolean result = instance.getAdminFlag();
        assertTrue(result);
        
    }
    
}
