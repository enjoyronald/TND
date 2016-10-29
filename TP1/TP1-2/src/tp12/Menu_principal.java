package tp12;

import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu_principal {

    private Scanner input = new Scanner(System.in);
    private Locations locManager; // pour gérer les locations 

    public Menu_principal(Locations loca) {
        locManager = loca;
    }

    public void afficheMenu() {

        //  Affichage du menu
        System.out.print(getMenu());
        Utilities ut = new Utilities();
        String selection = ut.entrerString();
        String lieu;
        Genre genre;
        String arrivee;
        String depart;

        int tarif;

        switch (selection) {
            case "0":
                System.out.println("Au revoir !");
                System.exit(0);
                break;
            case "1":
                System.out.print("Liste des locations...\n\n");
                System.out.println(locManager.toString());
                break;
            case "2":
                System.out.print("Ajouter une location :\n");
                System.out.print(" - Lieu : ");
                lieu = ut.entrerString();
                System.out.print(" - Type : ");
                genre = ut.entrerGenre();
                System.out.print(" - Tarif : ");
                tarif = ut.entrerInt();
                System.out.println(locManager.createLocation(lieu, tarif, genre) ? "location crée " : "location existe déjà");
                break;
            case "3":
                System.out.print("supprimer une location :\n");
                System.out.print(" - Lieu : ");
                lieu = ut.entrerString();
                System.out.println(locManager.deleteLocation(lieu) ? "location supprimée " : "la location n'existe pas");
                break;
            case "4":
                System.out.print("modifier prix location :\n");
                System.out.print(" - Lieu : ");
                lieu = ut.entrerString();
                System.out.print(" - Tarif : ");
                tarif = ut.entrerInt();
                System.out.println(locManager.updateLocation(lieu, tarif) ? "" : "");
                break;
            case "5":
                System.out.print("ajouter une reservation :\n");
                System.out.print(" - Lieu : ");
                lieu = ut.entrerString();
                System.out.print(" - Date arrivee : ");
                arrivee = ut.entrerDate();
                System.out.print(" - Date depart : ");
                depart = ut.entrerDate();
                 {
                    try {
                        System.out.println(locManager.updateLocation(lieu, new Periode(arrivee, depart)) ? "reservation ajoutée " : "reservation impossible");
                    } catch (ParseException ex) {
                        Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "6":
                System.out.print("supprimer une reservation :\n");
                System.out.print(" - Lieu : ");
                lieu = ut.entrerString();
                System.out.print(" - Date arrivee : ");
                arrivee = ut.entrerDate();
                System.out.print(" - Date depart : ");
                depart = ut.entrerDate();
                 {
                    try {
                        System.out.println(locManager.deleteLocationPeriode(lieu, new Periode(arrivee, depart)) ? "reservation supprimée " : "la reservation n'eiste pas");
                    } catch (ParseException ex) {
                        Logger.getLogger(Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                System.out.println("Commande incorrecte\n\n");
                break;
        }

    }

    static String getMenu() {
        String menu = "-----------------------------------\n";
        menu += "Menu principal : \n\n";
        menu += "   0) Quitter l'application\n";
        menu += "   1) Lister les locations\n";
        menu += "   2) Ajouter une location\n";
        menu += "   3) supprimer une location\n";
        menu += "   4) modifier prix location\n";
        menu += "   5) Ajouter une reservation\n";
        menu += "   6) supprimer une reservation\n";
        menu += "\n";
        menu += "Votre choix : ";
        return menu;
    }
}
