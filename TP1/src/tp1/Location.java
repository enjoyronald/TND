/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.*;

/**
 *
 * @author enjoy
 */
public class Location {
    protected String lieu;
    protected int tarif;
    protected List<Periode> reservations;
    protected Genre genre;
    
    Location(String lieu, int tarif, Genre genre){
        this.lieu = lieu;
        this.tarif = tarif;
        this.genre = genre;
        reservations = new ArrayList();
    }
    
    public boolean ajouterReservation(Periode p){
        for(Periode periode : reservations){
            if(periode.chevauchement(p))
                return false;
        }
        reservations.add(p);
        return true;
    }
    
    public void annulerReservation(Periode p){
        for(Periode periode : reservations){
            if(periode.equals(p))
                reservations.remove(periode);
        }
    }
    
    //---------------Setteur getteur 
    public String getLieu(){
        return lieu;
    }
    public List<Periode> getReservations(){
        return reservations;
    }
    public void setTarif(int tarif){
        this.tarif = tarif;
    }
    
    @Override
    public String toString(){
        String sep = " //---------------------------//\n";
        String corp = "\t Lieu : "+lieu+"\n"
                + "\t Prix : "+tarif+"\n"
                + "\t Genre : "+genre.getName()+"\n"
                + "/-------Reservations-------/";
        for (Periode p : reservations){
            corp += "\n"+p.toString();
        }
        return sep+corp+sep;
    }
}