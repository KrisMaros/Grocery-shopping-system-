
package menagedBean;

import Boundary.CustomerUI;
import DTO.BasketDTO;
import DTO.ProductDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "basket")
@RequestScoped

public class BasketBean implements Serializable
{
     private CustomerUI custUI = new CustomerUI();
     
    public ArrayList<BasketDTO> getBasketContent()
    {
       return custUI.getBasketContent();
    }
    
    public String addGrocerieToTheBasket(ProductDTO p)
    {
        custUI.addGrocerie(p);
        return "products";
    }
    
    public String removeGrocerieFromTheBasket(BasketDTO b)
    {
       custUI.removeGrocerie(b);
       return "basket";
    }
    
    public String callBasket()
    {
        return "basket";
    }
    
    public String clearBasket()
    {
        custUI.clearBasket();
        return "stores";
    }
}
