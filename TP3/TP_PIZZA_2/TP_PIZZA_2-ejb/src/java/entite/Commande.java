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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByCommandeId", query = "SELECT c FROM Commande c WHERE c.commandeId = :commandeId")
    , @NamedQuery(name = "Commande.findByQuantite", query = "SELECT c FROM Commande c WHERE c.quantite = :quantite")
    , @NamedQuery(name = "Commande.findByTotal", query = "SELECT c FROM Commande c WHERE c.total = :total")
    , @NamedQuery(name = "Commande.findByEmail", query = "SELECT c FROM Commande c WHERE c.email = :email")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMMANDE_ID")
    private Integer commandeId;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "TOTAL")
    private Integer total;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "PIZZA_ID", referencedColumnName = "PIZZA_ID")
    @ManyToOne
    private Pizza pizzaId;

    public Commande() {
    }

    public Commande(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public Integer getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pizza getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Pizza pizzaId) {
        this.pizzaId = pizzaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandeId != null ? commandeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.commandeId == null && other.commandeId != null) || (this.commandeId != null && !this.commandeId.equals(other.commandeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Commande[ commandeId=" + commandeId + " ]";
    }
    
}
