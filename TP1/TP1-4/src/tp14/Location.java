/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp14;

import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author enjoy
 */
@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "lieu",
    "tarif",
    "reservations",
    "genre"
})
public class Location {
    @XmlElement(required = true)
    protected String lieu;
    @XmlElement(required = true)
    protected int tarif;
    @XmlElement(required = true)
    protected List<Periode> reservations;
    @XmlElement(required = true)
    protected Genre genre;

    public Location(){
        
    }
    public Location(String lieu, int tarif, Genre genre) {
        this.lieu = lieu;
        this.tarif = tarif;
        this.genre = genre;
        reservations = new ArrayList();
    }

    public boolean ajouterReservation(Periode p) {
        for (Periode periode : reservations) {
            if (periode.chevauchement(p)) {
                return false;
            }
        }
        reservations.add(p);
        return true;
    }

    public boolean annulerReservation(Periode p) {
        for (Periode periode : reservations) {
            if (periode.equals(p)) {
                reservations.remove(periode);
                return true;
            }
        }
        return false;
    }

    //---------------Setteur getteur 
    public String getLieu() {
        return lieu;
    }
    
    public int getTarif() {
        return tarif;
    }

    public List<Periode> getReservations() {
        return reservations;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Location){
            Location loc = (Location) o;
            return loc.getLieu().equals(this.getLieu()) 
                    && loc.getTarif()==this.getTarif()
                    && loc.getReservations().equals(this.getReservations());
        }
        return false;
    }
    @Override
    public String toString() {
        String sep = " //---------------------------//\n";
        String corp = "\t Lieu : " + lieu + "\n"
                + "\t Prix : " + tarif + "\n"
                + "\t Genre : " + genre.getName() + "\n"
                + "/-------Reservations-------/";
        for (Periode p : reservations) {
            corp += "\n" + p.toString();
        }
        return sep + corp + sep;
    }
}
