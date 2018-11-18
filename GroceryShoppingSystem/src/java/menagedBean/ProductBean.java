
package menagedBean;

import Boundary.AdministratorUI;
import Boundary.CustomerUI;
import DTO.ProductDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "product")
@RequestScoped

public class ProductBean implements Serializable
{
     private CustomerUI customerUI = new CustomerUI();
     private AdministratorUI adminUI = new AdministratorUI();
     private int proID;
     private String productName;
     private int quantity;
     private double price;
     
     
     public ArrayList<ProductDTO> getListOfGroceries()
     {
        ArrayList<ProductDTO> productsDetails = customerUI.getProductDetails();
        return productsDetails;
     }
     
     public String setStoreID(int storeID)
     {
         customerUI.setStoreID(storeID);
         if(getAdminFlag()==true)
         {
             return "productsEditable";
         }
         return "products";
     }
     
     public int retrieveStoreID()
     {
        return customerUI.retrieveStoreID();         
     }    
     
     public boolean getAdminFlag()
     {
        return adminUI.getAdminFlag();         
     }
     
     public String editProductDetails(String productName, int quantity, double price)
     {
         adminUI.editProductDetails(productName, quantity, price);
         return "productsEditable";
     }
     
     public String setProductIdFlag(int ID)
     {
          adminUI.setProductID(ID);
          return "editGroceries";
     }
     
     public int getProductID()
     {
         return adminUI.getProductID();
     }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setProductID(int proID) {
        this.proID = proID;
    }
     
     public String addNewGroceries(String productName, int quantity, double price)
     {
         adminUI.addNewGroceries(productName, quantity, price);
         
         return "productsEditable";
     }
     
     public String deleteGrocery(int productID)
     {
         adminUI.deleteGrocery(productID);
         return "productsEditable";
     }
     
     
}
