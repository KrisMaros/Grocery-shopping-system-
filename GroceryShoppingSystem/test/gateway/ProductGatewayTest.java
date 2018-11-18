
package gateway;

import Boundary.AdministratorUI;
import Boundary.CustomerUI;
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
public class ProductGatewayTest {
    
    public ProductGatewayTest() {
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
     * Test of insert method, of class ProductGateway.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int storeID = 2;
        ProductGateway instance = new ProductGateway();
        boolean result = instance.insert(storeID);
        assertTrue(result);  
    }

    /**
     * Test of findStoreID method, of class ProductGateway.
     */
    @Test
    public void testFindStore() {
        System.out.println("findStore");
        ProductGateway instance = new ProductGateway();
        CustomerUI UI = new CustomerUI();
        int expResult = UI.retrieveStoreID();
        int result = instance.findStoreID();
        assertEquals(expResult, result);    
    }

    /**
     * Test of findAdmin method, of class ProductGateway.
     */
    @Test
    public void testFindAdmin() {
        System.out.println("findAdmin");
        ProductGateway instance = new ProductGateway();
        boolean result = instance.findAdmin();
        assertTrue(result);      
    }

    /**
     * Test of editProductDetails method, of class ProductGateway.
     */
    @Test
    public void testEditProductDetails() {
        System.out.println("editProductDetails");        
        ProductGateway instance = new ProductGateway();
        boolean result = instance.editProductDetails("tomato", 0, 0.0);
        assertTrue(result);        
    }

    /**
     * Test of insertProductID method, of class ProductGateway.
     */
    @Test
    public void testInsertProductID() {
        System.out.println("insertProductID");
        int productID = 1;
        ProductGateway instance = new ProductGateway();
        boolean result = instance.insertProductID(productID);
        assertTrue(result);       
    }

    /**
     * Test of findProductID method, of class ProductGateway.
     */
    @Test
    public void testFindProductID() {
        System.out.println("findProductID");
        ProductGateway instance = new ProductGateway();
        AdministratorUI UI = new AdministratorUI();
        int expResult = UI.getProductID();
        int result = instance.findProductID();
        assertEquals(expResult, result);       
    }

    /**
     * Test of insertNewGroceries method, of class ProductGateway.
     */
    @Test
    public void testInsertNewGroceries() {
        System.out.println("insertNewGroceries");
        String productName = "tomato";
        int quantity = 0;
        double price = 0.0;
        ProductGateway instance = new ProductGateway();
        boolean result = instance.insertNewGroceries(productName, quantity, price);
        assertTrue(result);        
    }

    /**
     * Test of deleteGrocery method, of class ProductGateway.
     */
    @Test
    public void testDeleteGrocerie() {
        System.out.println("deleteGrocerie");
        int productID = 11;
        ProductGateway instance = new ProductGateway();
        boolean result = instance.deleteGrocery(productID);
        assertTrue(result);
       
    }
    
}
