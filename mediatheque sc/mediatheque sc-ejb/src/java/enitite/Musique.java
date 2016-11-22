/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enitite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "musique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musique.findAll", query = "SELECT m FROM Musique m")
    , @NamedQuery(name = "Musique.findByMediaId", query = "SELECT m FROM Musique m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Musique.findByArtiste", query = "SELECT m FROM Musique m WHERE m.artiste = :artiste")
    , @NamedQuery(name = "Musique.findByMorceaux", query = "SELECT m FROM Musique m WHERE m.morceaux = :morceaux")})
public class Musique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEDIA_ID")
    private Integer mediaId;
    @Size(max = 100)
    @Column(name = "ARTISTE")
    private String artiste;
    @Size(max = 255)
    @Column(name = "MORCEAUX")
    private String morceaux;
    @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Media media;

    public Musique() {
    }

    public Musique(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
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
        if (!(object instanceof Musique)) {
            return false;
        }
        Musique other = (Musique) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Musique[ mediaId=" + mediaId + " ]";
    }
    
}
