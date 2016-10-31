/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp24;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @OneToMany(mappedBy = "employe", cascade = {CascadeType.ALL})
    protected List<Participation> participations;
    
    public Employe(){
        super();
        superieur = null;
        departement = null;
        participations=null;
    }

    public Employe(String nom, Employe superieur, Departement departement){
        super(nom);
        this.superieur=superieur;
        this.departement = departement;
        departement.addEmploye(this);
        participations = new ArrayList<>();
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
    public List<Participation> getParticipations(){
        return participations;
    }
}
