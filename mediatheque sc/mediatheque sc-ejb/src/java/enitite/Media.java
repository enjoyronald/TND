/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ronald & baptiste
 */
@Entity
@Table(name = "MEDIA")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m")
    , @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Media.findByEmprunt", query = "SELECT m FROM Media m WHERE m.emprunt = :emprunt")
    , @NamedQuery(name = "Media.findByDateDebut", query = "SELECT m FROM Media m WHERE m.dateDebut = :dateDebut")
    , @NamedQuery(name = "Media.findByDateFin", query = "SELECT m FROM Media m WHERE m.dateFin = :dateFin")
    , @NamedQuery(name = "Media.findByEtat", query = "SELECT m FROM Media m WHERE m.etat = :etat")
    , @NamedQuery(name = "Media.findByTitre", query = "SELECT m FROM Media m WHERE m.titre = :titre")
    , @NamedQuery(name = "Media.findByAnneeProduction", query = "SELECT m FROM Media m WHERE m.anneeProduction = :anneeProduction")
    , @NamedQuery(name = "Media.findByFormat", query = "SELECT m FROM Media m WHERE m.format = :format")})
public abstract class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEDIA_ID")
    private Integer mediaId;
    @Column(name = "EMPRUNT")
    private Integer emprunt;
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Size(max = 100)
    @Column(name = "ETAT")
    private String etat;
    @Size(max = 255)
    @Column(name = "TITRE")
    private String titre;
    @Column(name = "ANNEE_PRODUCTION")
    private Integer anneeProduction;
    @Size(max = 10)
    @Column(name = "FORMAT")
    private String format;
    @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME")
    @ManyToOne
    private Abonnee userName;


    public Media() {
    }

    public Media(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Integer emprunt) {
        this.emprunt = emprunt;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getAnneeProduction() {
        return anneeProduction;
    }

    public void setAnneeProduction(Integer anneeProduction) {
        this.anneeProduction = anneeProduction;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Abonnee getUserName() {
        return userName;
    }

    public void setUserName(Abonnee userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Media[ mediaId=" + mediaId + " ]";
    }

}
