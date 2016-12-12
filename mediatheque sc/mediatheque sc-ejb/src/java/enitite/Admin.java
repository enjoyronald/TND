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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ronald & baptiste
 */
@Entity
@Table(name = "ADMIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByUserName", query = "SELECT a FROM Admin a WHERE a.userName = :userName")
    , @NamedQuery(name = "Admin.findByMdp", query = "SELECT a FROM Admin a WHERE a.mdp = :mdp")
    , @NamedQuery(name = "Admin.findByNom", query = "SELECT a FROM Admin a WHERE a.nom = :nom")
    , @NamedQuery(name = "Admin.findByPrenom", query = "SELECT a FROM Admin a WHERE a.prenom = :prenom")
    , @NamedQuery(name = "Admin.findByTelephone", query = "SELECT a FROM Admin a WHERE a.telephone = :telephone")})
public class Admin implements Serializable {

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

    public Admin() {
    }

    public Admin(String userName) {
        this.userName = userName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enitite.Admin[ userName=" + userName + " ]";
    }
    
}
