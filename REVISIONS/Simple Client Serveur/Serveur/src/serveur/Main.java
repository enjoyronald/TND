/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

/**
 *
 * @author enjoy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Demmarage du serveur sur le port 9999");
        Thread communication = new Thread(new Serveur());
        communication.start();
    }
    
}
