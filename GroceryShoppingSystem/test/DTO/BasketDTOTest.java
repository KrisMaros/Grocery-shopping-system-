
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
public class BasketDTOTest {
    
    public BasketDTOTest() {
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
     * Test of getProductID method, of class BasketDTO.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        int expResult = 2;
        int result = instance.getProductID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setProductID method, of class BasketDTO.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");        
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        int expResult = 3;
        instance.setProductID(3);
        assertEquals(expResult, instance.getProductID());
        
    }

    /**
     * Test of getProductName method, of class BasketDTO.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        String expResult = "tomato";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setProductName method, of class BasketDTO.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");        
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        String expResult = "apple";
        instance.setProductName("apple");
        assertEquals(expResult, instance.getProductName());
        
    }

    /**
     * Test of getQuantity method, of class BasketDTO.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        int expResult = 20;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setQuantity method, of class BasketDTO.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");        
        BasketDTO instance = new BasketDTO(2,"tomato",10,2.5);
        int expResult = 20;
        instance.setQuantity(20);
        assertEquals(expResult, instance.getQuantity());
        
    }

    /**
     * Test of getPrice method, of class BasketDTO.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        double expResult = 2.5;
        double result = instance.getPrice();
        assertEquals(expResult, result, 2.5);
       
    }

    /**
     * Test of setPrice method, of class BasketDTO.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");        
        BasketDTO instance = new BasketDTO(2,"tomato",20,2.5);
        double expResult = 3.2;
        instance.setPrice(3.2);
        assertEquals(expResult, instance.getPrice(),3.2);
        
    }
    
}
