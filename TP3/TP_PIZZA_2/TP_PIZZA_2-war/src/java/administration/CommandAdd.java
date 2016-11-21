/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administration;

import entite.CommandeFacadeLocal;
import entite.Pizza;
import entite.PizzaFacadeLocal;
import entite.Stock;
import entite.StockFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enjoy
 */
public class CommandAdd extends HttpServlet {

    @EJB
    private PizzaFacadeLocal pizzaFacade;

    @EJB
    private CommandeFacadeLocal commandeFacade;

    @EJB
    private StockFacadeLocal stockFacade;

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
        String type = request.getParameter("type");
        if (type != null) {
            // le nom n'est pas reférencé
            Pizza pizza = pizzaFacade.find(type);
            try {
                int quantite = new Integer(request.getParameter("quantite"));
                String email = new String(request.getParameter("email"));
                Stock spizza = stockFacade.findByPizzaId(type);
                if (spizza.getQuantite() >= quantite) {// la quantitée est disponible
                    int total = quantite * pizza.getPrix();
                    stockFacade.update(type, spizza.getQuantite() - quantite);
                    commandeFacade.create(type, quantite, total, email);
                    //mise a jour de la quantite
                    response.sendRedirect("afficherCommandes.jsp?message=commande effectuée");
                } else {
                    response.sendRedirect("afficherCommandes.jsp?message=Pas suffisament de pizza en stock");
                }

            } catch (Exception ex) {
                response.sendRedirect("afficherCommandes.jsp?message=prolème lors de l'ajout");
                ex.printStackTrace();
            }
        } else {
            response.sendRedirect("afficherCommandes.jsp?message=prolème lors de l'ajout");
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
