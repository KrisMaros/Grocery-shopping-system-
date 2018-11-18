
package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class RegistrationGateway 
{
    public boolean registerCustomer(String customerName, String custPassword1 )
    {
        boolean dataOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Credentials(username,password) VALUES(?,?)");                
            stmt.setString(1, customerName);
            stmt.setString(2, custPassword1);
            
            int rows = stmt.executeUpdate();
            dataOK = rows == 1;

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return dataOK;
    }     
                
     public boolean registerAdministrator(String adminName, String adminPassword1 )
    {
        boolean dataOK = false;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Admins(username,password) VALUES(?,?)");                
            stmt.setString(1, adminName);
            stmt.setString(2, adminPassword1);
            
            int rows = stmt.executeUpdate();
            dataOK = rows == 1;

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return dataOK;
    }            
}
