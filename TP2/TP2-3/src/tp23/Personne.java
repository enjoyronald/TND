/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp23;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author enjoy
 */
@Entity
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    //@Column( name = "mot_de_passe" )  si jamais le nom de colum n'est pas le même
    @Column(length = 40)
    protected String nom;

    public Personne() {
    }

    public Personne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
}
