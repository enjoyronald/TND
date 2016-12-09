/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "ABONNEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abonnee.findAll", query = "SELECT a FROM Abonnee a")
    , @NamedQuery(name = "Abonnee.findByUserName", query = "SELECT a FROM Abonnee a WHERE a.userName = :userName")
    , @NamedQuery(name = "Abonnee.findByMdp", query = "SELECT a FROM Abonnee a WHERE a.mdp = :mdp")
    , @NamedQuery(name = "Abonnee.findByNom", query = "SELECT a FROM Abonnee a WHERE a.nom = :nom")
    , @NamedQuery(name = "Abonnee.findByPrenom", query = "SELECT a FROM Abonnee a WHERE a.prenom = :prenom")
    , @NamedQuery(name = "Abonnee.findByTelephone", query = "SELECT a FROM Abonnee a WHERE a.telephone = :telephone")
    , @NamedQuery(name = "Abonnee.findByAdresse", query = "SELECT a FROM Abonnee a WHERE a.adresse = :adresse")})
public class Abonnee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 100)
    @Column(name = "MDP")
    private String mdp;
    @Size(max = 100)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 100)
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "TELEPHONE")
    private Integer telephone;
    @Size(max = 100)
    @Column(name = "ADRESSE")
    private String adresse;

    @Size(max = 100)
    @Column(name = "EMAIL")
    private String emai;

    @OneToMany(mappedBy = "userName")
    private Collection<Media> mediaCollection;

    public Abonnee() {
        mediaCollection = new ArrayList<>();
    }

    public Abonnee(String userName) {
        this.userName = userName;
        mediaCollection = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlTransient
    public Collection<Media> getMediaCollection() {
        return mediaCollection;
    }

    public void setMediaCollection(Collection<Media> mediaCollection) {
        this.mediaCollection = mediaCollection;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonnee)) {
            return false;
        }
        Abonnee other = (Abonnee) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Abonnee[ userName=" + userName + " ]";
    }
    
    public int getNombreRetard(){
        int nbre = 0;
        Date retour,today;
        for(Media media : mediaCollection){
            retour = media.getDateFin();
            today = new Date();
            if(today.after(retour)){
                nbre+=1;
            }
        }
        return nbre;
    }
    
}
