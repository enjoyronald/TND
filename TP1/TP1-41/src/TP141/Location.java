//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.10.30 � 06:13:25 PM CET 
//


package TP141;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour location complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="location">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lieu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tarif" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reservations" type="{}periode" maxOccurs="unbounded"/>
 *         &lt;element name="genre" type="{}genre"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", propOrder = {
    "lieu",
    "tarif",
    "reservations",
    "genre"
})
public class Location {

    @XmlElement(required = true)
    protected String lieu;
    protected int tarif;
    @XmlElement(required = true)
    protected List<Periode> reservations;
    @XmlElement(required = true)
    protected Genre genre;

    /**
     * Obtient la valeur de la propri�t� lieu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * D�finit la valeur de la propri�t� lieu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieu(String value) {
        this.lieu = value;
    }

    /**
     * Obtient la valeur de la propri�t� tarif.
     * 
     */
    public int getTarif() {
        return tarif;
    }

    /**
     * D�finit la valeur de la propri�t� tarif.
     * 
     */
    public void setTarif(int value) {
        this.tarif = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Periode }
     * 
     * 
     */
    public List<Periode> getReservations() {
        if (reservations == null) {
            reservations = new ArrayList<Periode>();
        }
        return this.reservations;
    }

    /**
     * Obtient la valeur de la propri�t� genre.
     * 
     * @return
     *     possible object is
     *     {@link Genre }
     *     
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * D�finit la valeur de la propri�t� genre.
     * 
     * @param value
     *     allowed object is
     *     {@link Genre }
     *     
     */
    public void setGenre(Genre value) {
        this.genre = value;
    }

}
