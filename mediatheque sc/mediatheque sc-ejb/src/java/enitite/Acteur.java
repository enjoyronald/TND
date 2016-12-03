/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Acteur.findByNomActeur", query = "SELECT a FROM Acteur a WHERE a.nomActeur = :nomActeur")})
public class Acteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM_ACTEUR")
    private String nomActeur;
    @JoinTable(name = "FILM_ACTEUR", joinColumns = {
        @JoinColumn(name = "NOM_ACTEUR", referencedColumnName = "NOM_ACTEUR")}, inverseJoinColumns = {
        @JoinColumn(name = "FILM_ID", referencedColumnName = "MEDIA_ID")})
    @ManyToMany
    private Collection<Film> filmCollection;

    public Acteur() {
        filmCollection = new ArrayList<Film>();
    }

    public Acteur(String nomActeur) {
        this.nomActeur = nomActeur;
        filmCollection = new ArrayList<Film>();
    }

    public String getNomActeur() {
        return nomActeur;
    }

    public void setNomActeur(String nomActeur) {
        this.nomActeur = nomActeur;
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
        hash += (nomActeur != null ? nomActeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acteur)) {
            return false;
        }
        Acteur other = (Acteur) object;
        if ((this.nomActeur == null && other.nomActeur != null) || (this.nomActeur != null && !this.nomActeur.equals(other.nomActeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acteur{" + "nomActeur=" + nomActeur + ", filmCollection=" + filmCollection + '}';
    }


    
}
