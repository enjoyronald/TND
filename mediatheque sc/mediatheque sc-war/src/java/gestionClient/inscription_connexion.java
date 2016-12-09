/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionClient;

import enitite.Abonnee;
import enitite.Admin;
import facades.AbonneeFacadeLocal;
import facades.AdminFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author enjoy
 */
public class inscription_connexion extends HttpServlet {

    @EJB
    private AdminFacadeLocal adminFacade;

    @EJB
    private AbonneeFacadeLocal abonneeFacade;

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
        String type = request.getParameter("type");

        if (type == null || type == "") { // access frauduleux à la page
            // on redirige sur la page d'aceuil   
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            switch (type) {
                case "inscription":
                    inscription(request, response);
                    return;
                case "connexion":
                    connexion(request, response);
                    return;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
            }
        }
    }

    public void inscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String telS = request.getParameter("tel");
        Abonnee abonnee;
        if (username != null) {
            abonnee = abonneeFacade.find(username);
            if (abonnee != null) {
                // le nom d'utilisateur existe déjà
                // renvoyer sur la page d'inscription
                request.setAttribute("message", "le nom d'utilisateur existe déja");
                request.getRequestDispatcher("inscription.jsp").forward(request, response);
                return;
            }
            abonnee = new Abonnee();
            abonnee.setUserName(username);
            abonnee.setAdresse(adresse);
            abonnee.setMdp(pwd);
            abonnee.setNom(nom);
            abonnee.setPrenom(prenom);
            abonnee.setEmai(email);
            abonnee.setTelephone(new Integer(telS));
            abonneeFacade.create(abonnee);
            HttpSession session = request.getSession();
            session.setAttribute("client", abonnee);
            session.setAttribute("connected", "abonnee");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
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

    private void connexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkAdmin = request.getParameterValues("administrateur");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        if(checkAdmin == null || checkAdmin.length != 1){
            Abonnee abonnee = abonneeFacade.find(username);
            if (abonnee == null) {
                // il faut signaer que l'utilisateur n'existe pas
                request.setAttribute("message", "l'utilisateur n'existe pas");
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
                return;
            }
            if (!abonnee.getMdp().equals(pwd)) {
                // pas le on mot de passe
                request.setAttribute("message", "mot de passe incorrecte");
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("client", abonnee);
            session.setAttribute("connected", "abonnee");
            response.sendRedirect("index.jsp");
        }else{
            Admin admin = adminFacade.find(username);
            if (admin == null){
                request.setAttribute("message", "l'utilisateur n'existe pas");
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
                return;
            }
            if (!admin.getMdp().equals(pwd)) {
                // pas le on mot de passe
                request.setAttribute("message", "mot de passe incorrecte");
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("client", admin);
            session.setAttribute("connected", "admin");
            response.sendRedirect("index.jsp");
            
        }
    }

}
