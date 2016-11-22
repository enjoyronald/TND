/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "ACTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acteur.findAll", query = "SELECT a FROM Acteur a")
    , @NamedQuery(name = "Acteur.findByActeurId", query = "SELECT a FROM Acteur a WHERE a.acteurId = :acteurId")
    , @NamedQuery(name = "Acteur.findByNom", query = "SELECT a FROM Acteur a WHERE a.nom = :nom")})
public class Acteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACTEUR_ID")
    private Integer acteurId;
    @Size(max = 100)
    @Column(name = "NOM")
    private String nom;
    @JoinTable(name = "FILM_ACTEUR", joinColumns = {
        @JoinColumn(name = "ACTEUR_ID", referencedColumnName = "ACTEUR_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FILM_ID", referencedColumnName = "MEDIA_ID")})
    @ManyToMany
    private Collection<Film> filmCollection;

    public Acteur() {
    }

    public Acteur(Integer acteurId) {
        this.acteurId = acteurId;
    }

    public Integer getActeurId() {
        return acteurId;
    }

    public void setActeurId(Integer acteurId) {
        this.acteurId = acteurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Film> getFilmCollection() {
        return filmCollection;
    }

    public void setFilmCollection(Collection<Film> filmCollection) {
        this.filmCollection = filmCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acteurId != null ? acteurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acteur)) {
            return false;
        }
        Acteur other = (Acteur) object;
        if ((this.acteurId == null && other.acteurId != null) || (this.acteurId != null && !this.acteurId.equals(other.acteurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Acteur[ acteurId=" + acteurId + " ]";
    }
    
}
