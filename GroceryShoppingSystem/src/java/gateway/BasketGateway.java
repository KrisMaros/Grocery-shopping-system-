
package gateway;

import DTO.ProductDTO;
import DTO.BasketDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BasketGateway  
{
    
    private boolean lock =true;
    
    public ArrayList<BasketDTO> findBasket()
    {
        ArrayList<BasketDTO> basketView = new ArrayList<>();
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Basket");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                BasketDTO v = new BasketDTO(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("quantity"), rs.getDouble("Price"));
                basketView.add(v);
            }
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return basketView;
    } 
     
    public boolean update(ProductDTO p)      
    {  
            boolean insertOK = false;
            try
            {
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE Basket SET ProductName = ?, Quantity = ?, Price = ? WHERE ProductID = ? ");
                for(BasketDTO b : findBasket())
                {
                    if(p.getProductName().equals(b.getProductName())&& !b.getProductName().isEmpty())
                    {
                       stmt.setString(1, p.getProductName());                       
                       stmt.setInt(2, b.getQuantity()+1);                       
                       stmt.setDouble(3, b.getPrice()+p.getPrice());
                       stmt.setInt(4, p.getProductID());
                       int rows = stmt.executeUpdate();
                       insertOK = rows == 1;                       
                       lock = false;
                    }            
                }
                if(lock==true)
                {                   
                    PreparedStatement inse = conn.prepareStatement("INSERT INTO Basket ( productName, quantity, price, productID) VALUES (?, ?, ?, ?)");
                   
                    inse.setString(1, p.getProductName());
                    inse.setInt(2, 1);
                    inse.setDouble(3, p.getPrice());
                    inse.setInt(4, p.getProductID());
                    int rows = inse.executeUpdate();
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
    
    public boolean delete(BasketDTO p)      
    {  
            boolean deleteOK = false;
            try
            {
                Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE Basket SET ProductName = ?, Quantity = ?, Price = ? WHERE ProductID = ? ");
                for(BasketDTO b : findBasket())
                {
                    if(p.getProductName().equals(b.getProductName()) && !b.getProductName().isEmpty() && b.getQuantity()>1)
                    {
                       stmt.setString(1, p.getProductName());                       
                       stmt.setInt(2, b.getQuantity()-1);                       
                       stmt.setDouble(3, b.getPrice()-(p.getPrice()/p.getQuantity()));
                       stmt.setInt(4, p.getProductID());
                       int rows = stmt.executeUpdate();
                       deleteOK = rows == 1;                       
                       lock = false;
                    }            
                }
                if(lock==true)
                {                   
                    PreparedStatement inse = conn.prepareStatement("DELETE FROM Basket WHERE ProductID = ? ");                   
                    
                    inse.setInt(1, p.getProductID());                    
                    int rows = inse.executeUpdate();
                    deleteOK = rows == 1;
                }             
                stmt.close();
                conn.close();
            }
            
            catch (SQLException sqle)
            {
                System.out.println(sqle);
            }
            return deleteOK;
    } 
    
}
