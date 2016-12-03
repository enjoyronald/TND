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
@Table(name = "MUSIQUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musique.findAll", query = "SELECT m FROM Musique m")
    , @NamedQuery(name = "Musique.findByMediaId", query = "SELECT m FROM Musique m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Musique.findByArtiste", query = "SELECT m FROM Musique m WHERE m.artiste = :artiste")
    , @NamedQuery(name = "Musique.findByMorceaux", query = "SELECT m FROM Musique m WHERE m.morceaux = :morceaux")})
public class Musique extends Media implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 100)
    @Column(name = "ARTISTE")
    private String artiste;
    @Size(max = 255)
    @Column(name = "MORCEAUX")
    private String morceaux;

    public Musique() {
    }

    public Musique(Integer mediaId) {
        super(mediaId);
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getMorceaux() {
        return morceaux;
    }

    public void setMorceaux(String morceaux) {
        this.morceaux = morceaux;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.artiste);
        hash = 17 * hash + Objects.hashCode(this.morceaux);
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
        final Musique other = (Musique) obj;
        if (!Objects.equals(this.artiste, other.artiste)) {
            return false;
        }
        if (!Objects.equals(this.morceaux, other.morceaux)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Musique{" + "artiste=" + artiste + ", morceaux=" + morceaux + '}';
    }

}
