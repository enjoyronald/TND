/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author enjoy
 */
public class Serveur implements Runnable {

    protected ServerSocket ss;
    protected Socket cs;
    protected static final int port = 9999;
    protected static final int poolSize = 10;
    protected ExecutorService pool = null;

    @Override
    public void run() {
        try {
            ss = new ServerSocket(port);
            pool= Executors.newFixedThreadPool(poolSize);
            while(true){
                pool.execute(new Esclave(ss.accept(),this));
            }
        } catch (IOException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
