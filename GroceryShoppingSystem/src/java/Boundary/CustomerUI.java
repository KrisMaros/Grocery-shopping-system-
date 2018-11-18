
package Boundary;

import DTO.BasketDTO;
import DTO.ProductDTO;
import DTO.StoreDTO;
import gateway.BasketGateway;
import gateway.CheckCredentialsGateway;
import gateway.ProductGateway;
import gateway.RegistrationGateway;
import gateway.StoreGateway;
import java.util.ArrayList;


public class CustomerUI 
{
    private final StoreGateway storeGate = new StoreGateway();
    private final ProductGateway productGate = new ProductGateway();
    private final BasketGateway basketGate = new BasketGateway();
    private final CheckCredentialsGateway credGate = new CheckCredentialsGateway();
    private final RegistrationGateway regGate = new RegistrationGateway();    
    
    
    public ArrayList<StoreDTO> getStoreDetails()
    {
        return storeGate.findStoreDetails();
    }
    
    public ArrayList<ProductDTO> getProductDetails()
    {
       return productGate.findListOfProducts();
    }
    
    public boolean setStoreID(int storeID)
    {
       return productGate.insert(storeID);
    }
    
    public int retrieveStoreID()
    {
        return productGate.findStoreID();
    }   
    
    public ArrayList<BasketDTO> getBasketContent()
    {
       return basketGate.findBasket();
    }
    
    public boolean addGrocerie(ProductDTO p)
    {
        return basketGate.update(p);
    }
    
    public boolean removeGrocerie(BasketDTO b)
    {
       return basketGate.delete(b);
    }

    public boolean checkCustomerCredentials(String customerName, String custPassword)
    {
        return credGate.checkCustomerCredentials(customerName, custPassword);
    }
    
    public boolean clearBasket()
    {
        return credGate.clearBasket();
    }
    
    public boolean clearAllFlags()
    {
        return credGate.clearAllFlags();
    }
    
    public boolean registerCustomer(String customerName, String custPassword1 )
    {
        return regGate.registerCustomer(customerName, custPassword1);
    }
}
