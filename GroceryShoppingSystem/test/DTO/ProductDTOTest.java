
package DTO;

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
public class ProductDTOTest {
    
    public ProductDTOTest() {
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
     * Test of getProductID method, of class ProductDTO.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        int expResult = 1;
        int result = instance.getProductID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setProductID method, of class ProductDTO.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");        
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        int expResult = 2;
        instance.setProductID(2);
        assertEquals(expResult, instance.getProductID());
        
    }

    /**
     * Test of getProductName method, of class ProductDTO.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        String expResult = "orange";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setProductName method, of class ProductDTO.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        String expResult = "apple";
        instance.setProductName("apple");
        assertEquals(expResult, instance.getProductName());
       
    }

    /**
     * Test of getQuantity method, of class ProductDTO.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        int expResult = 15;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setQuantity method, of class ProductDTO.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        int expResult = 20;
        instance.setQuantity(20);
        assertEquals(expResult, instance.getQuantity());
    }

    /**
     * Test of getPrice method, of class ProductDTO.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        double expResult = 1.8;
        double result = instance.getPrice();
        assertEquals(expResult, result, 1.8);
       
    }

    /**
     * Test of setPrice method, of class ProductDTO.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        
        ProductDTO instance = new ProductDTO(1,"orange",15,1.8);
        double expResult = 2.5;
        instance.setPrice(2.5);
        assertEquals(expResult, instance.getPrice(),2.5);
    }
    
}
