
package Boundary;


import gateway.CheckCredentialsGateway;
import gateway.ProductGateway;
import gateway.RegistrationGateway;


public class AdministratorUI 
{
    private ProductGateway productGate = new ProductGateway();
    private CheckCredentialsGateway credGate = new CheckCredentialsGateway();
    private RegistrationGateway regGate = new RegistrationGateway();
    
    public boolean editProductDetails(String productName, int quantity, double price)
    {
       return productGate.editProductDetails(productName, quantity, price);
    }
    
    public boolean setProductID(int productID)
    {
         return productGate.insertProductID(productID);
    }
    
    public int getProductID()
    {
        return productGate.findProductID();
    }
    
    public boolean addNewGroceries(String productName, int quantity, double price)
    {
        return productGate.insertNewGroceries(productName, quantity, price);
    }
    
    public boolean deleteGrocery(int productID)
    {
        return productGate.deleteGrocery(productID);
    }
    
    public boolean checkAdminCredentials(String adminName, String adminPassword)
    {
        return credGate.checkAdminCredentials(adminName, adminPassword);
    }
    
    public boolean setAdminFlag(boolean adminCredentialsOK)
    {
        return credGate.setAdminFlag(adminCredentialsOK);
    }
    
    public boolean registerAdministrator(String adminName, String adminPassword1 )
    {
        return regGate.registerAdministrator(adminName, adminPassword1);
    }
    
     public boolean getAdminFlag()
    {
        return productGate.findAdmin();
    }
    
}
