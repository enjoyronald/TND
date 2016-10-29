/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import gestionRequettes.RequetteManager;
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

    Esclave(Socket accept, Serveur serveur) {
        this.cs = accept;
        this.serveur = serveur;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = null;
            Writer output = null;
            input = new BufferedReader(new InputStreamReader(cs.getInputStream(), "8859_1"), 10024); // flux en lecture
            output = new OutputStreamWriter(cs.getOutputStream(), "8859_1"); // flux en écriture
            RequetteManager reqMan = new RequetteManager(input, output, serveur.getLocManager());
        } catch (IOException ex) {
            Logger.getLogger(Esclave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
