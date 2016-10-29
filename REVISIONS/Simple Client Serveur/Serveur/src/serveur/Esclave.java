/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enjoy
 */
public class Esclave implements Runnable {

    Socket cs;
    Serveur serveur;

    Esclave(Socket accept, Serveur aThis) {
        this.cs = accept;
        this.serveur = aThis;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = null;
            Writer output = null;
            input = new BufferedReader(new InputStreamReader(cs.getInputStream(), "8859_1"), 10024); // flux en lecture
            output = new OutputStreamWriter(cs.getOutputStream(), "8859_1"); // flux en écriture
            System.out.println("L'eclave se met au boulot");
            System.out.println("Demande de String au client et il repond : + "
                    + demanderStringClient("Envoi moi un String", input,output));
            System.out.println("Demande de int au client et il repond : + "
                    + demanderIntClient("Envoi moi un Int",input,output));
        } catch (IOException ex) {
            Logger.getLogger(Esclave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String demanderStringClient(String question, BufferedReader input, Writer output) {
        try {
            output.write(question+"\n");
            output.flush();
            return input.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Esclave.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int demanderIntClient(String question, BufferedReader input, Writer output) {
        while (true) {
            try {
                output.write(question+"\n");
                output.flush();
                int result = Integer.parseInt(input.readLine());
                return result;
            } catch (IOException ex) {
                Logger.getLogger(Esclave.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {

            }
        }
    }
}
