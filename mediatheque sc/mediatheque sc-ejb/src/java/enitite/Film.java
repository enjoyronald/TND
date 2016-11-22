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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "FILM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findByMediaId", query = "SELECT f FROM Film f WHERE f.mediaId = :mediaId")
    , @NamedQuery(name = "Film.findByRealisateur", query = "SELECT f FROM Film f WHERE f.realisateur = :realisateur")
    , @NamedQuery(name = "Film.findByResume", query = "SELECT f FROM Film f WHERE f.resume = :resume")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEDIA_ID")
    private Integer mediaId;
    @Size(max = 100)
    @Column(name = "REALISATEUR")
    private String realisateur;
    @Size(max = 255)
    @Column(name = "RESUME")
    private String resume;
    @ManyToMany(mappedBy = "filmCollection")
    private Collection<Acteur> acteurCollection;
    @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Media media;

    public Film() {
    }

    public Film(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Film[ mediaId=" + mediaId + " ]";
    }
    
}
