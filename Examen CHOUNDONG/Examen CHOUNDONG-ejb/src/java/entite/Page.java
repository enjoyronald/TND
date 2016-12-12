/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "PAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p")
    , @NamedQuery(name = "Page.findByNom", query = "SELECT p FROM Page p WHERE p.nom = :nom")
    , @NamedQuery(name = "Page.findByNbvisite", query = "SELECT p FROM Page p WHERE p.nbvisite = :nbvisite")})
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM")
    private String nom;
    @Column(name = "NBVISITE")
    private Integer nbvisite;

    public Page() {
    }

    public Page(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbvisite() {
        return nbvisite;
    }

    public void setNbvisite(Integer nbvisite) {
        this.nbvisite = nbvisite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Page[ nom=" + nom + " ]";
    }
    
}
