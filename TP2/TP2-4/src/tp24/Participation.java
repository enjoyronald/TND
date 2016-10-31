/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp24;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "PARTICIPATION",
        uniqueConstraints = @UniqueConstraint(columnNames = {"EMPLOYE_ID", "PROJET_ID"}))
public class Participation implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    final private Employe employe;
    @ManyToOne
    final private Projet projet;
    private String fonction;

    public Participation() {
        employe=null;
        projet=null;
        fonction=null;
    }
    
    public Participation(Employe employe,Projet projet, String fonction){
        this.employe= employe;
        this.projet=projet;
        this.fonction=fonction;
    }
    public Employe getEmploye(){
        return employe;
    }
    public Projet getProjet(){
        return projet;
    }
    public String getFonction(){
        return fonction;
    }
    public void setFonction(String fonction){
        this.fonction = fonction;
    }
}
