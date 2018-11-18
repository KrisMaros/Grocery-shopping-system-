
package gateway;

import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductGateway 
{  
      
    public ArrayList<ProductDTO> findListOfProducts()
    {
        ArrayList<ProductDTO> productsDetails = new ArrayList<>();
        try
        {
            Connection conn = DBConnection.getConnection();
            if(findStoreID()==1)
            {                
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Grocerie1");
                ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                    ProductDTO pro = new ProductDTO(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("Quantity"), rs.getDouble("Price"));
                    productsDetails.add(pro);
                }
                stmt.close();
            }
            else if(findStoreID()==2)
            {                
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Grocerie2");
                ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                    ProductDTO pro = new ProductDTO(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("Quantity"), rs.getDouble("Price"));
                    productsDetails.add(pro);
                }
                stmt.close();
            }
            else if(findStoreID()==3)
            {
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Grocerie3");
                ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                    ProductDTO pro = new ProductDTO(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("Quantity"), rs.getDouble("Price"));
                    productsDetails.add(pro);
                }
                stmt.close();
            }
            
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return productsDetails;
    } 
      
    public boolean insert(int storeID) 
    {   
        boolean insertOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Flags (storeflag) VALUES (?)");
            if(storeID!=0)
            {
              stmt.setInt(1,storeID);
              int rows = stmt.executeUpdate();
              insertOK = rows == 1;
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return insertOK;        
    }
    
    public int findStoreID()
    {
        int number=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Flags");
            ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                   number = rs.getInt("Storeflag");                    
                }            
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }        
        return number; 
    }
    public boolean findAdmin()
    {
        boolean adminLog = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Adminflag");
            ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                   adminLog = rs.getBoolean("adminlog");                    
                }            
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }        
        return adminLog; 
    }
    
    public boolean editProductDetails(String productName, int quantity, double price)
    {   
        boolean editOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            if(findStoreID()==1)
            {                
                PreparedStatement stmt = conn.prepareStatement("UPDATE Grocerie1 SET ProductName =?, Quantity =?, Price =? WHERE ProductID =? ");
                
                stmt.setString(1,productName);
                stmt.setInt(2,quantity);
                stmt.setDouble(3,price);
                stmt.setInt(4,findProductID());
                int rows = stmt.executeUpdate();
                editOK = rows == 1;
                
                stmt.close();
            }
            else if(findStoreID()==2)
            {                
                PreparedStatement stmt = conn.prepareStatement("UPDATE Grocerie2 SET ProductName =?, Quantity =?, Price =? WHERE ProductID =? ");
                
                stmt.setString(1,productName);
                stmt.setInt(2,quantity);
                stmt.setDouble(3,price);
                stmt.setInt(4,findProductID());
                int rows = stmt.executeUpdate();
                editOK = rows == 1;
                
                stmt.close();
            }
            else if(findStoreID()==3)
            {                
                PreparedStatement stmt = conn.prepareStatement("UPDATE Grocerie3 SET ProductName =?, Quantity =?, Price =? WHERE ProductID =? ");
                
                stmt.setString(1,productName);
                stmt.setInt(2,quantity);
                stmt.setDouble(3,price);
                stmt.setInt(4,findProductID());
                int rows = stmt.executeUpdate();
                editOK = rows == 1;
                
                stmt.close();
            }
            
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return editOK;
    }
    
    public boolean insertProductID(int productID) 
    {   
        boolean insertOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ProductIdFlag (proIdFlag) VALUES (?)");
            if(productID!=0)
            {
              stmt.setInt(1,productID);
              int rows = stmt.executeUpdate();
              insertOK = rows == 1;
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return insertOK;        
    }
    
    public int findProductID()
    {
        int number=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ProductIdFlag");
            ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                   number = rs.getInt("proIdFlag");                    
                }            
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }        
        return number; 
    }
    
    public boolean insertNewGroceries(String productName, int quantity, double price) 
    {   
        boolean insertOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            if(findStoreID()==1)
            {
              PreparedStatement stmt = conn.prepareStatement("INSERT INTO Grocerie1 (productName, quantity, price) VALUES (?,?,?)"); 
            
              stmt.setString(1,productName);
              stmt.setInt(2,quantity);
              stmt.setDouble(3,price);              
              int rows = stmt.executeUpdate();
              insertOK = rows == 1;
            
              stmt.close();
            }
            else if(findStoreID()==2)
            {
              PreparedStatement stmt = conn.prepareStatement("INSERT INTO Grocerie2 (productName, quantity, price) VALUES (?,?,?)"); 
            
              stmt.setString(1,productName);
              stmt.setInt(2,quantity);
              stmt.setDouble(3,price);              
              int rows = stmt.executeUpdate();
              insertOK = rows == 1;
            
              stmt.close();
            }
            else if(findStoreID()==3)
            {
              PreparedStatement stmt = conn.prepareStatement("INSERT INTO Grocerie3 (productName, quantity, price) VALUES (?,?,?)"); 
            
              stmt.setString(1,productName);
              stmt.setInt(2,quantity);
              stmt.setDouble(3,price);              
              int rows = stmt.executeUpdate();
              insertOK = rows == 1;
            
              stmt.close();
            }            
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return insertOK;        
    }
    
    public boolean deleteGrocery(int productID)      
    {  
            boolean deleteOK = false;
            try
            {
                Connection conn = DBConnection.getConnection();
                if(findStoreID()==1)
                {
                   PreparedStatement stmt = conn.prepareStatement("DELETE FROM Grocerie1 WHERE ProductID = ? ");                   

                   stmt.setInt(1, productID);                    
                   int rows = stmt.executeUpdate();
                   deleteOK = rows == 1;
                    stmt.close(); 
                }
                else if(findStoreID()==2)
                {
                   PreparedStatement stmt = conn.prepareStatement("DELETE FROM Grocerie2 WHERE ProductID = ? ");                   

                   stmt.setInt(1, productID);                    
                   int rows = stmt.executeUpdate();
                   deleteOK = rows == 1;
                   stmt.close(); 
                }
                else if(findStoreID()==3)
                {
                   PreparedStatement stmt = conn.prepareStatement("DELETE FROM Grocerie3 WHERE ProductID = ? ");                   

                   stmt.setInt(1, productID);                    
                   int rows = stmt.executeUpdate();
                   deleteOK = rows == 1;
                   stmt.close(); 
                }
                    
                conn.close();
            }
            
            catch (SQLException sqle)
            {
                System.out.println(sqle);
            }
            return deleteOK;
    } 
      
}
