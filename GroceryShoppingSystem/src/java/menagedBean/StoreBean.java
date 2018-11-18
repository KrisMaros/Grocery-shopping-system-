
package menagedBean;

import Boundary.CustomerUI;
import DTO.StoreDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "store")
@RequestScoped

public class StoreBean implements Serializable
{
    private CustomerUI custUI = new CustomerUI();
    
    public ArrayList<StoreDTO> getStoreDetails()
    {
        ArrayList<StoreDTO> storesDetails = custUI.getStoreDetails();
        return storesDetails;
    }
}
