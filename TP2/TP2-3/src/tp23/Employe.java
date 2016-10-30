/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp23;

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
    @ManyToOne
    protected Departement departement;
    
    public Employe(){
        super();
        superieur = null;
        departement = null;
    }

    public Employe(String nom, Employe superieur, Departement departement){
        super(nom);
        this.superieur=superieur;
        this.departement = departement;
    }
    
    public Employe getSuperieur(){
        return superieur;
    }
    public void setSuperieur(Employe sup){
        this.superieur=sup;
    }
    public Departement getDepartement(){
        return departement;
    }
    public void setDepartement(Departement departement){
        this.departement=departement;
    }
}
