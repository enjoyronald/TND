/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionClient;

import entite.CommandeFacadeLocal;
import entite.Pizza;
import entite.PizzaFacadeLocal;
import entite.Stock;
import entite.StockFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 *
 * @author enjoy
 */
public class Commande_Pizza extends HttpServlet {

    @EJB
    private StockFacadeLocal stockFacade;

    @EJB
    private PizzaFacadeLocal pizzaFacade;

    @EJB
    private CommandeFacadeLocal commandeFacade;

    //private static final Logger LOG = Logger.getLogger(Commande_Pizza.class.getName());
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Commande Pizza" + Commande_Pizza.class + "</title>");

            out.println("</head>");
            out.println("<body>");
            List lStock = stockFacade.findAll();
            for (Iterator it = lStock.iterator(); it.hasNext();) {
                Pizza elem = ((Stock) it.next()).getPizzaId();
                out.println("Type : <b>" + elem.getPizzaId() + " </b> ");
                out.println("Prix : " + elem.getPrix() + "<br/>");
            }

            out.println("<h1>Choisissez votre pizza : </h1>");
            String type = request.getParameter("type");
            if (type != null) {
                Pizza pizza = pizzaFacade.find(type);
                if (pizza != null) { // le nom n'est pas reférencé
                    try {
                        int quantite = new Integer(request.getParameter("quantite"));
                        String email = new String(request.getParameter("email"));
                        Stock spizza = stockFacade.findByPizzaId(type);
                        if(spizza.getQuantite() >= quantite){// la quantitée est disponible
                            int total = quantite * pizza.getPrix();
                            out.println("On ajoute une commande dont le prix total est :" + total + "<br/>");
                            stockFacade.update(type, spizza.getQuantite() - quantite);
                            commandeFacade.create(type, quantite, total, email);
                            //mise a jour de la quantite
                            out.println("Commande effectuée");
                        }else{
                            out.println("Pas suffisament de pizza en stock");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    out.println("pizza non trouvée--------");
                }
            } else {
                out.println("<form method='POST'>");
                out.println("Type: <input type='text' name='type'><br/>");
                out.println("Quantité: <input type='text' name='quantite'><br/>");
                out.println("Email: <input type='text' name='email'><br/>");
                out.println("<input type='submit'><br/>");
                out.println("</form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
