/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enjoy
 */
@Entity
@Table(name = "PIZZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")
    , @NamedQuery(name = "Pizza.findByPizzaId", query = "SELECT p FROM Pizza p WHERE p.pizzaId = :pizzaId")
    , @NamedQuery(name = "Pizza.findByPrix", query = "SELECT p FROM Pizza p WHERE p.prix = :prix")})
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PIZZA_ID")
    private String pizzaId;
    @Column(name = "PRIX")
    private Integer prix;
    @OneToMany(mappedBy = "pizzaId")
    private Collection<Commande> commandeCollection;
    @OneToMany(mappedBy = "pizzaId")
    private Collection<Stock> stockCollection;

    public Pizza() {
    }

    public Pizza(String pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(String pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pizzaId != null ? pizzaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.pizzaId == null && other.pizzaId != null) || (this.pizzaId != null && !this.pizzaId.equals(other.pizzaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Pizza[ pizzaId=" + pizzaId + " ]";
    }
    
}
