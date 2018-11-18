
package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import menagedBean.CheckCredentialsBean;


public class CheckCredentialsGateway 
{
   public boolean checkCustomerCredentials(String customerName, String custPassword)
    {
        boolean credentialsOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Credentials WHERE Username = ?");
            stmt.setString(1, customerName);
            ResultSet rs = stmt.executeQuery();

            credentialsOK = rs.next() && rs.getString("Password").equals(custPassword);

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            Logger.getLogger(CheckCredentialsBean.class.getName()).log(Level.SEVERE, e.toString());
        }

        return credentialsOK;
    }
   
   public boolean checkAdminCredentials(String adminName, String adminPassword)
    {
        boolean adminCredentialsOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Admins WHERE Username = ?");
            stmt.setString(1, adminName);
            ResultSet rs = stmt.executeQuery();

            adminCredentialsOK = rs.next() && rs.getString("Password").equals(adminPassword);

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            Logger.getLogger(CheckCredentialsBean.class.getName()).log(Level.SEVERE, e.toString());
        }      
        
        return adminCredentialsOK;
        
    }
   
   public boolean clearBasket() 
    {  
        boolean deleteOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Basket");        
            
            int rows = stmt.executeUpdate();
            deleteOK = rows == 1;
            stmt.close();
            conn.close();          
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return deleteOK;
    }
   
   public boolean clearAllFlags() 
    {  
        boolean deleteOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM ProductIdFlag");        
            PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Flags");
            PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM AdminFlag");
            
            int rows1 = stmt1.executeUpdate();            
            int rows2 = stmt2.executeUpdate();
            int rows3 = stmt3.executeUpdate();
            stmt1.close();
            stmt2.close();
            stmt3.close();
            conn.close();
            if(rows1==1){
                deleteOK = true;
            }
            else if(rows2==1){
                deleteOK = true;
            }
            else if(rows3==1){
                deleteOK = true;
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return deleteOK;
    }
   
   public boolean setAdminFlag(boolean adminCredentialsOK) 
    {   
        boolean flagOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Adminflag (adminlog) VALUES (?)");            
            stmt.setBoolean(1,adminCredentialsOK);
            int rows = stmt.executeUpdate();
            flagOK = rows == 1;
            
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return flagOK;        
    }
}
