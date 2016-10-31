/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp24;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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
public class Projet implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String libelle;
    @OneToMany(mappedBy = "projet", cascade = {CascadeType.ALL})
    protected List<Participation> participants;

    public Projet() {

    }

    public Projet(String libelle) {
        this.libelle = libelle;
        participants = new ArrayList<>();
    }

    public void ajouterParticipant(Employe emp, String fonction) {
        Participation p = new Participation(emp, this, fonction);
        Employe e;
        Projet j;
        for (Participation pa : participants) {
            e = pa.getEmploye();
            j = pa.getProjet();
            if ((e.getId() == emp.getId()) && (j.getId() == this.getId())) {
                return;
            }
        }
        participants.add(p);
        emp.getParticipations().add(p);
    }

    public List<Participation> getParticipants() {
        return participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
