/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@XmlRootElement(name = "periode")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "arrivee",
    "depart"
})
public class Periode {
    @XmlElement(required = true)
    protected Date arrivee;
    @XmlElement(required = true)
    protected Date depart;
    static protected SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
    
    public Periode(){
        
    }
    public Periode(String a, String d) throws ParseException{
        boolean testval = valide(a,d);
        if(testval){
            arrivee= sDF.parse(a);
            depart= sDF.parse(d);
        }else{
            // on va retourner une exception
        }
    }
    
    boolean valide(String a, String d) throws ParseException{
        Date da = sDF.parse(a);
        Date dd = sDF.parse(d);
        return dd.after(da);
    }
    
    boolean chevauchement(Periode p){
        if(this.getDepart().before(p.getArrivee())  
                || this.getArrivee().after(p.getDepart())){
            return false;
        }
        return true;
    }
    @Override
    public boolean equals(Object periode){
        if(periode instanceof Periode){
            Periode p=(Periode)periode;
            return p.getArrivee().equals(this.getArrivee()) && p.getDepart().equals(this.getDepart());
        }
        return false;
    }
    
    //getteur setteur
    Date getArrivee(){
        return arrivee;
    }
    Date getDepart(){
        return depart;
    }
    
    @Override
    public String toString(){
        return "Date arrivée : "+this.getArrivee()+"\t Date depart : "+this.getDepart();
    }
    
}
