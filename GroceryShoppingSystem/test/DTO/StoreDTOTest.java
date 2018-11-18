
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
public class StoreDTOTest {
    
    public StoreDTOTest() {
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
     * Test of getId method, of class StoreDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class StoreDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");        
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        int expResult = 2;
        instance.setId(2);
        assertEquals(expResult, instance.getId());
        
    }

    /**
     * Test of getAddressLine1 method, of class StoreDTO.
     */
    @Test
    public void testGetAddressLine1() {
        System.out.println("getAddressLine1");
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        String expResult = "street";
        String result = instance.getAddressLine1();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAddressLine1 method, of class StoreDTO.
     */
    @Test
    public void testSetAddressLine1() {
        System.out.println("setAddressLine1");        
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        String expResult = "apple";
        instance.setAddressLine1("apple");
        assertEquals(expResult, instance.getAddressLine1());
       
    }

    /**
     * Test of getAddressLine2 method, of class StoreDTO.
     */
    @Test
    public void testGetAddressLine2() {
        System.out.println("getAddressLine2");
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        String expResult = "stoke";
        String result = instance.getAddressLine2();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAddressLine2 method, of class StoreDTO.
     */
    @Test
    public void testSetAddressLine2() {
        System.out.println("setAddressLine2");        
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        String expResult = "apple";
        instance.setAddressLine2("apple");
        assertEquals(expResult, instance.getAddressLine2());
        
    }

    /**
     * Test of getPostCode method, of class StoreDTO.
     */
    @Test
    public void testGetPostCode() {
        System.out.println("getPostCode");
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        String expResult = "postcode";
        String result = instance.getPostCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setPostCode method, of class StoreDTO.
     */
    @Test
    public void testSetPostCode() {
        System.out.println("setPostCode");        
        StoreDTO instance = new StoreDTO(1,"street","stoke","postcode");
        String expResult = "apple";
        instance.setPostCode("apple");
        assertEquals(expResult, instance.getPostCode());
        
    }
    
}
