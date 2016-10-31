/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp24;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author enjoy
 */
@Entity
public class Departement implements Serializable {
    @Id
    @GeneratedValue
    long id;
    String nom;
    String lieu;
    @OneToMany(mappedBy = "departement", cascade = {CascadeType.ALL})
    List<Employe> employes;
    
    public Departement(){
        employes =new ArrayList<>();
    }
    public Departement(String nom, String lieu){
        this.nom = nom;
        this.lieu=lieu;
        employes =new ArrayList<>();
    }
    
    public List<Employe> getEmployes(){
        return employes;
    }
    public void setEmployes(List<Employe> employes){
        this.employes=employes;
    }
    public void addEmploye(Employe employe){
        employes.add(employe);
    }
    public void removeEmploye(Employe employe){
        employes.remove(employe);
    }
    public String getNom(){
        return nom;
    }
    public String getLieu(){
        return lieu;
    }
    public long getId(){
        return id;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setLieu(String lieu){
        this.lieu = lieu;
    }
}
