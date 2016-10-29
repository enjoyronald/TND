/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enjoy
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            Scanner clientInput = new Scanner(System.in); // ce que le client ecrit
            Writer output; // flux en écriture
            BufferedReader input; // flux en lecture
            boolean arret=true;
            
            Socket connexion = new Socket(InetAddress.getLocalHost(), 9999);
            System.out.println("connexion établie avec le serveur");
            
            output = new OutputStreamWriter(connexion.getOutputStream(), "8859_1");
            input = new BufferedReader(new InputStreamReader(connexion.getInputStream(), "8859_1"), 1024); 
            
            StringBuffer sb = new StringBuffer();
            
            while(arret){// dans ce scenario, on attend le message du serveur avant d'agir
                System.out.println(input.readLine()); // recuperation du message du serveur
                output.write(clientInput.nextLine()+"\n"); // on envoi la reponse du client
                output.flush();
            }
            connexion.close();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
