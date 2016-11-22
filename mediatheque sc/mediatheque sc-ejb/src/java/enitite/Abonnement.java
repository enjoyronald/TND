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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "ABONNEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abonnement.findAll", query = "SELECT a FROM Abonnement a")
    , @NamedQuery(name = "Abonnement.findByAbonnementId", query = "SELECT a FROM Abonnement a WHERE a.abonnementId = :abonnementId")
    , @NamedQuery(name = "Abonnement.findByType", query = "SELECT a FROM Abonnement a WHERE a.type = :type")
    , @NamedQuery(name = "Abonnement.findByNbrPret", query = "SELECT a FROM Abonnement a WHERE a.nbrPret = :nbrPret")
    , @NamedQuery(name = "Abonnement.findByDureParPret", query = "SELECT a FROM Abonnement a WHERE a.dureParPret = :dureParPret")
    , @NamedQuery(name = "Abonnement.findByPrixAbonnement", query = "SELECT a FROM Abonnement a WHERE a.prixAbonnement = :prixAbonnement")
    , @NamedQuery(name = "Abonnement.findByDureeAbonnement", query = "SELECT a FROM Abonnement a WHERE a.dureeAbonnement = :dureeAbonnement")})
public class Abonnement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ABONNEMENT_ID")
    private Integer abonnementId;
    @Size(max = 100)
    @Column(name = "TYPE")
    private String type;
    @Column(name = "NBR_PRET")
    private Integer nbrPret;
    @Column(name = "DURE_PAR_PRET")
    private Integer dureParPret;
    @Column(name = "PRIX_ABONNEMENT")
    private Integer prixAbonnement;
    @Column(name = "DUREE_ABONNEMENT")
    private Integer dureeAbonnement;
    @OneToMany(mappedBy = "abonnementId")
    private Collection<Abonnee> abonneeCollection;

    public Abonnement() {
    }

    public Abonnement(Integer abonnementId) {
        this.abonnementId = abonnementId;
    }

    public Integer getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(Integer abonnementId) {
        this.abonnementId = abonnementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNbrPret() {
        return nbrPret;
    }

    public void setNbrPret(Integer nbrPret) {
        this.nbrPret = nbrPret;
    }

    public Integer getDureParPret() {
        return dureParPret;
    }

    public void setDureParPret(Integer dureParPret) {
        this.dureParPret = dureParPret;
    }

    public Integer getPrixAbonnement() {
        return prixAbonnement;
    }

    public void setPrixAbonnement(Integer prixAbonnement) {
        this.prixAbonnement = prixAbonnement;
    }

    public Integer getDureeAbonnement() {
        return dureeAbonnement;
    }

    public void setDureeAbonnement(Integer dureeAbonnement) {
        this.dureeAbonnement = dureeAbonnement;
    }

    @XmlTransient
    public Collection<Abonnee> getAbonneeCollection() {
        return abonneeCollection;
    }

    public void setAbonneeCollection(Collection<Abonnee> abonneeCollection) {
        this.abonneeCollection = abonneeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abonnementId != null ? abonnementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if ((this.abonnementId == null && other.abonnementId != null) || (this.abonnementId != null && !this.abonnementId.equals(other.abonnementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Abonnement[ abonnementId=" + abonnementId + " ]";
    }
    
}
