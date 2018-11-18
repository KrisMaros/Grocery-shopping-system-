
package gateway;

import DTO.StoreDTO;
import java.util.ArrayList;
import menagedBean.StoreBean;
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
public class StoreGatewayTest {
    
    public StoreGatewayTest() {
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

    
    @Test
    public void testFindStoreDetails() {
        System.out.println("findStoreDetails");
        StoreGateway instance = new StoreGateway();
        StoreBean bean = new StoreBean();
        ArrayList<StoreDTO> expResult = bean.getStoreDetails();
        ArrayList<StoreDTO> result = instance.findStoreDetails();
        assertEquals(expResult, result);     
        
    }    
}
