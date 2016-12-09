/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtres;

import enitite.Admin;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author enjoy
 */
public class ConnexionFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public ConnexionFilter() {
    }    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
       String uridemande = ((HttpServletRequest)request).getRequestURI().toString();
        //si l'URI demande est /admin/login alors laisser passer
        if (uridemande.equals("/mediatheque_sc-war/connexion.jsp")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = ((HttpServletRequest) request).getSession();
            try {
                Admin admin = (Admin) session.getAttribute("admin");
                if (admin == null) {
                    String urldemande = ((HttpServletRequest) request).getRequestURL().toString();
                    ((HttpServletRequest) request).getSession().setAttribute("url", urldemande);
                    ((HttpServletRequest)request).setAttribute("message", "vous devez vous connecter");
                    ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/connexion.jsp");
                    return;
                }
            } catch (NullPointerException e) {//La duplication du code de la condition dans l'exception est pour contourner le problème du NullPointerException qui se lance au début
                String urldemande = ((HttpServletRequest) request).getRequestURL().toString();
                ((HttpServletRequest) request).getSession().setAttribute("url", urldemande);
                ((HttpServletRequest)request).setAttribute("message", "vous devez vous connecter");
                ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/connexion.jsp");
                return;
            }

            chain.doFilter(request, response);

        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
}
