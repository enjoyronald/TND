/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp14;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enjoy
 */
@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Locations {
    @XmlElement(required = true)
    protected static List<Location> locations = new ArrayList();

    public Locations() {

    }

    public boolean createLocation(String lieu, int tarif, Genre genre) {
        if (!locations.stream().noneMatch((loc) -> (lieu.equals(loc.getLieu())))) {
            return false;
        } // une seule location par lieu
        locations.add(new Location(lieu, tarif, genre));
        return true;
    }

    public void readLocation(String lieu) {
        for (Location loc : locations) {
            if (lieu.equals(loc.getLieu())) {
                System.out.println(loc.toString());// une seule location par lieu
                return;
            }
        }
        System.out.println("Le lieu indiqué n'est pas reférencé");
    }

    public void updateLocation(String lieu, Object o) {
        for (Location loc : locations) {
            if (lieu.equals(loc.getLieu())) {
                if (o instanceof Integer) {
                    int tarif = (Integer) o;
                    loc.setTarif(tarif);
                    System.out.println("Tarif de " + lieu + " mis à jour \n");
                    return;
                }
                if (o instanceof Periode) {
                    Periode p = (Periode) o;
                    boolean success = loc.ajouterReservation(p);
                    if (success) {
                        System.out.println("reservation " + p.toString() + " ajouter à " + lieu);
                    } else {
                        System.out.println("reservation " + p.toString() + " ne peut etre ajouter à " + lieu);
                    }
                    return;
                }
                return;
            }
        }
    }

    public void deleteLocation(String lieu) {
        locations.stream().filter((loc) -> (loc.getLieu().equals(lieu))).forEachOrdered((loc) -> {
            locations.remove(loc);
        });
    }

    public void deleteLocation(String lieu, Periode p) {
        locations.stream().filter((loc) -> (loc.getLieu().equals(lieu))).forEachOrdered((loc) -> {
            loc.annulerReservation(p);
        });
    }

    public Location findLocation(String lieu) {
        try {
            return locations
                    .stream()
                    .filter((loc) -> (loc.getLieu().equals(lieu)))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
