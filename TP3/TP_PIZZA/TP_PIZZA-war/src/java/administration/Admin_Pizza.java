/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administration;

import entite.Commande;
import entite.CommandeFacadeLocal;
import entite.Pizza;
import entite.PizzaFacadeLocal;
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

/**
 *
 * @author enjoy
 */
public class Admin_Pizza extends HttpServlet {

    @EJB
    private CommandeFacadeLocal commandeFacade;

    @EJB
    private StockFacadeLocal stockFacade;

    @EJB
    private PizzaFacadeLocal pizzaFacade;


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
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Administration Pizza</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Différentes commandes effectuées : </h1>");
            List lCommande = commandeFacade.findAll();
            for (Iterator it = lCommande.iterator(); it.hasNext();) {
                Commande elem = (Commande) it.next();
                out.println("Type : <b>" + elem.getPizzaId().getPizzaId() + " </b> ");
                out.println("Quantitée : <b>" + elem.getQuantite()+ " </b> ");
                out.println("Total : <b>" + elem.getTotal() + "</b>");
                out.println("Email : " + elem.getEmail()+ " <br/>");
            }
            out.println("<h1>Ajouter un nouveau type de pizza : </h1>");
            List lPizza = pizzaFacade.findAll();
            for (Iterator it = lPizza.iterator(); it.hasNext();) {
                Pizza elem = (Pizza) it.next();
                out.println("Type : <b>" + elem.getPizzaId() + " </b> ");
                out.println("Prix : " + elem.getPrix() + "<br/>");
            }
            String type = null;
            type = request.getParameter("type");
            if (type != null) {
                try {
                    int prix = 0;
                    prix = new Integer(request.getParameter("prix"));
                    int quantite = new Integer(request.getParameter("quantite"));
                    out.println("On ajoute un type de pizza<br/>");

                    Pizza e = new Pizza();
                    e.setPizzaId(type);
                    e.setPrix(prix);
                    pizzaFacade.create(e);
                    stockFacade.create(type, quantite);
                    response.sendRedirect("Admin_Pizza");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                out.println("Pizza sauvegardé");
            } else {
                out.println("<form method='POST'>");
                out.println("Type: <input type='text' name='type'><br/>");
                out.println("Prix: <input type='text' name='prix'><br/>");
                out.println("Quantité: <input type='text' name='quantite'><br/>");
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
