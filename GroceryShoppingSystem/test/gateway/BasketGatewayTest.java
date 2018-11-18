
package gateway;


import DTO.BasketDTO;
import DTO.ProductDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BasketGatewayTest {
    
    public BasketGatewayTest() {
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
     * Test of update method, of class BasketGateway.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ProductDTO p = new ProductDTO(1,"tomato",20,2.5);
        BasketGateway instance = new BasketGateway();
        boolean result = instance.update(p);
        assertTrue(result);        
        
    }

    /**
     * Test of delete method, of class BasketGateway.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BasketDTO p = new BasketDTO(1,"tomato",20,2.5);
        BasketGateway instance = new BasketGateway();
        boolean result = instance.delete(p);
        assertTrue(result);
        
        
    }
    
}
