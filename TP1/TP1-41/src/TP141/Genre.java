//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2016.10.30 � 06:13:25 PM CET 
//


package TP141;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour genre.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="genre">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="studio"/>
 *     &lt;enumeration value="appartement"/>
 *     &lt;enumeration value="maison"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "genre")
@XmlEnum
public enum Genre {

    @XmlEnumValue("studio")
    STUDIO("studio"),
    @XmlEnumValue("appartement")
    APPARTEMENT("appartement"),
    @XmlEnumValue("maison")
    MAISON("maison");
    private final String value;

    Genre(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Genre fromValue(String v) {
        for (Genre c: Genre.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
