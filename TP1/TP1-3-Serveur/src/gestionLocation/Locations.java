/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author enjoy
 */
public class Locations {

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

    public boolean updateLocation(String lieu, Object o) {
        for (Location loc : locations) {
            if (lieu.equals(loc.getLieu())) {
                if (o instanceof Integer) {
                    int tarif = (Integer) o;
                    loc.setTarif(tarif);
                    System.out.println("Tarif de " + lieu + " mis à jour \n");
                    return true;
                }
                if (o instanceof Periode) {
                    Periode p = (Periode) o;
                    boolean success = loc.ajouterReservation(p);
                    if (success) {
                        System.out.println("reservation " + p.toString() + " ajouter à " + lieu);
                        return true;
                    } else {
                        System.out.println("reservation " + p.toString() + " ne peut etre ajouter à " + lieu);
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean deleteLocation(String lieu) {
        for (Location loc : locations) {
            if (loc.getLieu().equals(lieu)) {
                locations.remove(loc);
                return true;
            }
        }
        return false;
    }

    public boolean deleteLocationPeriode(String lieu, Periode p) {
        for(Location loc : locations){
            if(loc.getLieu().equals(lieu)){
                loc.getReservations().remove(p);
                return true;
            }
        }
        return false;
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
    
    public String afficherTarif(String lieu, Genre genre){
        for(Location loc : locations){
            if(loc.getLieu().equals(lieu)){
                return ""+loc.getTarif();
            }
        }
        return "le lieu indiqué n'est pas reférencé";
    }
    @Override
    public String toString() {
        String result = "";
        if (locations.isEmpty()) {
            return "Aucune location n'est enregistrée";
        }
        for (Location loc : locations) {
            result += loc.toString();
        }
        return result;
    }
}
