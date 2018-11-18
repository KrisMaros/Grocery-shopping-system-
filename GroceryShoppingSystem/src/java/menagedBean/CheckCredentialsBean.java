package menagedBean;

import Boundary.AdministratorUI;
import Boundary.CustomerUI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "checkCredentials")
@SessionScoped
public class CheckCredentialsBean implements Serializable
{

    private String adminName;
    private String customerName;
    private String custPassword;
    private String adminPassword;
    private boolean credentialsOK = false;
    private boolean adminCredentialsOK = false;
    
    private CustomerUI customerUI = new CustomerUI();
     private AdministratorUI adminUI = new AdministratorUI();

    public CheckCredentialsBean() {
    }

    public String checkCustomerCredentials(String customerName, String custPassword)
    {        
        credentialsOK = customerUI.checkCustomerCredentials(customerName, custPassword);
        
        if (credentialsOK)
        {
            return "stores";
        }
        else
        {
            clearCredentials();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer login or password not correct"));
            return null;
        } 
    }
    
    public String checkAdminCredentials(String adminName, String adminPassword)
    {
        adminCredentialsOK = adminUI.checkAdminCredentials(adminName, adminPassword);
        setAdminFlag(adminCredentialsOK);
        
        if (adminCredentialsOK)
        {
            return "stores";
        }
        else
        {
            clearCredentials();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrator login or password not correct"));
            return null;
        }  
    }
    
    public boolean clearBasket()
    {
        return customerUI.clearBasket();
    }
    
    public boolean clearAllFlags()
    {
        return customerUI.clearAllFlags();
    }
    
    public void setAdminFlag(boolean adminCredentialsOK)
    {
        adminUI.setAdminFlag(adminCredentialsOK);
    }
     
    private void clearCredentials()
    {
        this.customerName = "";
        this.adminName = "";
        this.custPassword = "";
        this.adminPassword = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public boolean credentialsAreOK()
    {
        return credentialsOK;
    } 
    
    public boolean adminCredentialsAreOK()
    {
        return adminCredentialsOK;
    }

    public String logOff()
    {
        clearAllFlags();
        clearBasket();        
        clearCredentials();
        return "index";
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

    public String getCustPassword() {
        return custPassword;
    }   

    public String getAdminPassword() {
        return adminPassword;
    }   

    public boolean isCredentialsOK() {
        return credentialsOK;
    }

    public void setCredentialsOK(boolean credentialsOK) {
        this.credentialsOK = credentialsOK;
    }    

    public void setCustPassword(String password)
    {
        try
        {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                          .digest(password.getBytes(StandardCharsets.UTF_8));

            this.custPassword = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException ex)
        {
            this.custPassword = "";
            Logger.getLogger(CheckCredentialsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setAdminPassword(String password)
    {
        try
        {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                          .digest(password.getBytes(StandardCharsets.UTF_8));

            this.adminPassword = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException ex)
        {
            this.adminPassword = "";
            Logger.getLogger(CheckCredentialsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
