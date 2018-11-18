package menagedBean;

import Boundary.AdministratorUI;
import Boundary.CustomerUI;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "registration")
@RequestScoped
public class RegistrationBean implements Serializable
{
    private String adminName;
    private String customerName;
    private String custPassword1;
    private String custPassword2;
    private String adminPassword1;
    private String adminPassword2;
    private CustomerUI customerUI = new CustomerUI();
     private AdministratorUI adminUI = new AdministratorUI();

    public RegistrationBean()
    {
    }
    
    public String registerCustomer() throws NoSuchAlgorithmException
    {
        boolean dataOK = false;

        if (custPassword1.equals(custPassword2))
        {            
                byte[] hash = MessageDigest.getInstance("SHA-256")
                              .digest(custPassword1.getBytes(StandardCharsets.UTF_8));

                custPassword1 = Base64.getEncoder().encodeToString(hash);
                
                dataOK = customerUI.registerCustomer(customerName, custPassword1); 
        }        
        if (dataOK)
        {
            return "index";
        }
        else
        {           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Passwords are not the same"));            
            return null;
        }
    }
    
    public String registerAdministrator() throws NoSuchAlgorithmException 
    {
        boolean dataOK = false;
        
        if(adminPassword1.equals(adminPassword2))
        {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                          .digest(adminPassword1.getBytes(StandardCharsets.UTF_8));

            adminPassword1 = Base64.getEncoder().encodeToString(hash);
            
            dataOK = adminUI.registerAdministrator(adminName, adminPassword1);
        }
        if (dataOK)
        {
            return "index";
        }
        else
        {           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Passwords are not the same"));            
            return null;
        }
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustPassword1() {
        return custPassword1;
    }

    public void setCustPassword1(String custPassword1) {
        this.custPassword1 = custPassword1;
    }

    public String getCustPassword2() {
        return custPassword2;
    }

    public void setCustPassword2(String custPassword2) {
        this.custPassword2 = custPassword2;
    }

    public String getAdminPassword1() {
        return adminPassword1;
    }

    public void setAdminPassword1(String adminPassword1) {
        this.adminPassword1 = adminPassword1;
    }

    public String getAdminPassword2() {
        return adminPassword2;
    }

    public void setAdminPassword2(String adminPassword2) {
        this.adminPassword2 = adminPassword2;
    } 

}
