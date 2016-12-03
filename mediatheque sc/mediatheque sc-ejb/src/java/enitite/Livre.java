/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "LIVRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l")
    , @NamedQuery(name = "Livre.findByMediaId", query = "SELECT l FROM Livre l WHERE l.mediaId = :mediaId")
    , @NamedQuery(name = "Livre.findByAuteur", query = "SELECT l FROM Livre l WHERE l.auteur = :auteur")
    , @NamedQuery(name = "Livre.findByResume", query = "SELECT l FROM Livre l WHERE l.resume = :resume")})
public class Livre extends Media implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 100)
    @Column(name = "AUTEUR")
    private String auteur;
    @Size(max = 255)
    @Column(name = "RESUME")
    private String resume;


    public Livre() {
    }

    public Livre(Integer mediaId) {
        super(mediaId);
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.auteur);
        hash = 89 * hash + Objects.hashCode(this.resume);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livre other = (Livre) obj;
        if (!Objects.equals(this.auteur, other.auteur)) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        return true;
    }

    
    
}
