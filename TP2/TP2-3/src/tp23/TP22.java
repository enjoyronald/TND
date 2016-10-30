package tp23;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enjoy
 */
public class TP22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2-1PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Employe sup = new Employe("boss");
        Employe emp = new Employe("employe", sup);
        Personne pierre = new Personne("Pierre");
        
        et.begin();
        em.persist(sup);
        em.persist(emp);
        em.persist(pierre);
        et.commit();

    }

}
