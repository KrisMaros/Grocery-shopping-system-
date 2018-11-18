
package gateway;
import DTO.StoreDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreGateway 
{
      
    public ArrayList<StoreDTO> findStoreDetails()
    {
        ArrayList<StoreDTO> storesDetails = new ArrayList<>();
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Store");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                StoreDTO sto = new StoreDTO(rs.getInt("StoreID"), rs.getString("Addressline1"), rs.getString("Addressline2"), rs.getString("Postcode"));
                storesDetails.add(sto);
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return storesDetails;
    } 
}
