/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ronald & baptiste
 */
@Entity
@Table(name = "FILM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findByMediaId", query = "SELECT f FROM Film f WHERE f.mediaId = :mediaId")
    , @NamedQuery(name = "Film.findByRealisateur", query = "SELECT f FROM Film f WHERE f.realisateur = :realisateur")
    , @NamedQuery(name = "Film.findByResume", query = "SELECT f FROM Film f WHERE f.resume = :resume")})
public class Film extends Media implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 100)
    @Column(name = "REALISATEUR")
    private String realisateur;
    @Size(max = 255)
    @Column(name = "RESUME")
    private String resume;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "FILM_ACTEUR", joinColumns = {
        @JoinColumn(name = "FILM_ID", referencedColumnName = "MEDIA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "NOM_ACTEUR", referencedColumnName = "NOM_ACTEUR")})
    private Collection<Acteur> acteurCollection;


    public Film() {
        acteurCollection = new ArrayList<Acteur>();
    }

    public Film(Integer mediaId) {
        super(mediaId);
        acteurCollection = new ArrayList<Acteur>();
    }


    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @XmlTransient
    public Collection<Acteur> getActeurCollection() {
        return acteurCollection;
    }

    public void setActeurCollection(Collection<Acteur> acteurCollection) {
        this.acteurCollection = acteurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.realisateur);
        hash = 89 * hash + Objects.hashCode(this.resume);
        hash = 89 * hash + Objects.hashCode(this.acteurCollection);
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
        final Film other = (Film) obj;
        if (!Objects.equals(this.realisateur, other.realisateur)) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        if (!Objects.equals(this.acteurCollection, other.acteurCollection)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Film{" + "realisateur=" + realisateur + ", resume=" + resume + ", acteurCollection=" + acteurCollection + '}';
    }


    
}
