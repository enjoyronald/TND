/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp22;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author enjoy
 */
@Entity
public class Employe extends Personne{
    @ManyToOne
    protected Employe superieur;
    
    public Employe(){
        superieur = null;
    }
    
    public Employe(String nom){
        super(nom);
        superieur=null;
    }
    public Employe(int id, String nom){
        super(id,nom);
        superieur=null;
    }
    public Employe(String nom, Employe superieur){
        super(nom);
        this.superieur=superieur;
    }
    
    public Employe getSuperieur(){
        return superieur;
    }
    public void setSuperieur(Employe sup){
        this.superieur=sup;
    }
}
