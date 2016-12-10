/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "EMPRUNT")
@XmlRootElement
public class Emprunt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPRUNT_ID")
    private Integer empruntId;
    @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME")
    @ManyToOne
    private Abonnee userName;
    @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID")
    @ManyToOne
    private Media mediaId;
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "DATE_RETOUR")
    @Temporal(TemporalType.DATE)
    private Date dateRetour;

    public Emprunt() {
    }

    public Emprunt(Integer empruntId) {
        this.empruntId = empruntId;
    }

    public Integer getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(Integer empruntId) {
        this.empruntId = empruntId;
    }

    public Abonnee getUserName() {
        return userName;
    }

    public void setUserName(Abonnee userName) {
        this.userName = userName;
    }

    public Media getMediaId() {
        return mediaId;
    }

    public void setMediaId(Media mediaId) {
        this.mediaId = mediaId;
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

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.empruntId);
        hash = 19 * hash + Objects.hashCode(this.userName);
        hash = 19 * hash + Objects.hashCode(this.mediaId);
        hash = 19 * hash + Objects.hashCode(this.dateDebut);
        hash = 19 * hash + Objects.hashCode(this.dateFin);
        hash = 19 * hash + Objects.hashCode(this.dateRetour);
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
        final Emprunt other = (Emprunt) obj;
        if (!Objects.equals(this.empruntId, other.empruntId)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.mediaId, other.mediaId)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.dateRetour, other.dateRetour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "empruntId=" + empruntId + ", userName=" + userName + ", mediaId=" + mediaId + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", dateRetour=" + dateRetour + '}';
    }
    
}
