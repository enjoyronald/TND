/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionQuestion;

import entite.Categorie;
import entite.Question;
import facade.CategorieFacadeLocal;
import facade.QuestionFacadeLocal;
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
public class AjoutQuestion extends HttpServlet {


    @EJB
    private QuestionFacadeLocal questionFacade;

    @EJB
    private CategorieFacadeLocal categorieFacade;

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
        String nom = request.getParameter("nom");
        String cat = request.getParameter("sCategories");
        String reponse = request.getParameter("reponse");
        if(nom == null || cat == null || reponse == null){
            request.setAttribute("message", "erreur transmission question");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        Question question = new Question();
        question.setNom(nom);
        
        Categorie categorie = categorieFacade.find(cat);
        if(categorie == null){
            request.setAttribute("message", "erreur transmission question");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        question.setCategorie(categorie);
        question.setReponse(reponse);
        //question.setReponse(rep);
        questionFacade.create(question);
        request.setAttribute("message", "question "+nom+" bien crée avec sa reponse");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
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
