package filter;

import menagedBean.RegistrationBean;
import menagedBean.CheckCredentialsBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "CheckLoggedIn", urlPatterns =
{
    "/*"
})
public class CheckLoggedIn implements Filter
{

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    @Inject
    CheckCredentialsBean checkCredentials;
    @Inject
    RegistrationBean registration;

    public CheckLoggedIn()
    {
    }

    /*
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/faces/index.xhtml";
        String loginCustomerURI = request.getContextPath() + "/faces/loginCustomer.xhtml";
        String registerCustomerURI = request.getContextPath() + "/faces/registerCustomer.xhtml";
        String loginAdminURI = request.getContextPath() + "/faces/loginAdmin.xhtml";
        String registerAdminURI = request.getContextPath() + "/faces/registerAdmin.xhtml";
        
//         String productsEditableURI = request.getContextPath() + "/faces/productsEditable.xhtml";
//         String editGrocariesURI = request.getContextPath() + "/faces/editGrocaries.xhtml";
        
        boolean adminLoggedIn = checkCredentials.adminCredentialsAreOK();
        boolean loggedIn = checkCredentials.credentialsAreOK();
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean loginCustomerRequest = request.getRequestURI().equals(loginCustomerURI);
        boolean registerCustomerRequest = request.getRequestURI().equals(registerCustomerURI);
        boolean loginAdminRequest = request.getRequestURI().equals(loginAdminURI);
        boolean registerAdminRequest = request.getRequestURI().equals(registerAdminURI);
        
//        boolean productsEditableRequest = request.getRequestURI().equals(productsEditableURI);
//        boolean editGrocariesRequest = request.getRequestURI().equals(editGrocariesURI);
        

        if (loggedIn ||adminLoggedIn|| loginCustomerRequest|| registerCustomerRequest||loginAdminRequest
            ||registerAdminRequest||loginRequest)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(loginURI);
        }
    }

    /*
     * Destroy method for this filter
     */
    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }

    /*
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);
    }

}
