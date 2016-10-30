/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionRequettes;

import gestionLocation.Genre;
import gestionLocation.Locations;
import gestionLocation.Periode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enjoy
 */
public class RequetteManager {

    private BufferedReader input;
    private Writer output;
    private Locations locManager;
    private Socket cs;

    public RequetteManager(BufferedReader input, Writer output, Locations locManager, Socket cs) {
        this.input = input;
        this.output = output;
        this.locManager = locManager;
        this.cs = cs;
        startCommunication();
    }

    private void startCommunication() {
        while (true) {
            try {
                //envoyer Menu
                //  Affichage du menu
                envoyerMessage(getMenu());
                String selection = input.readLine();
                String lieu;
                Genre genre;
                String arrivee;
                String depart;

                int tarif;

                switch (selection) {
                    case "0":
                        envoyerMessage("Au revoir !");
                        input.readLine();//on onsomme la reponse inutile
                        input.close();
                        output.close();
                        cs.close();
                        return;
                    case "1":
                        envoyerMessage("Liste des locations...\n"
                                + locManager.toString());
                        input.readLine();
                        break;
                    case "2":
                        envoyerMessage("Ajouter une location :\n"
                                + " - Lieu : ");
                        lieu = input.readLine();
                        envoyerMessage(" - Type : ");
                        genre = demanderGenre();
                        envoyerMessage(" - Tarif : ");
                        tarif = demanderInt();
                        envoyerMessage(locManager.createLocation(lieu, tarif, genre) ? "location crée " : "location existe déjà");
                        input.readLine();
                        break;
                    case "3":
                        envoyerMessage("supprimer une location :\n"
                                + " - Lieu : ");
                        lieu = input.readLine();
                        envoyerMessage(locManager.deleteLocation(lieu) ? "location supprimée " : "la location n'existe pas");
                        input.readLine();
                        break;
                    case "4":
                        envoyerMessage("modifier prix location :\n"
                                + " - Lieu : ");
                        lieu = input.readLine();
                        envoyerMessage(" - Tarif : ");
                        tarif = demanderInt();
                        envoyerMessage(locManager.updateLocation(lieu, tarif) ? "" : "");
                        input.readLine();
                        break;
                    case "5":
                        envoyerMessage("ajouter une reservation :\n"
                                + " - Lieu : ");
                        lieu = input.readLine();
                        envoyerMessage(" - Date arrivee : ");
                        arrivee = demanderDate();
                        envoyerMessage(" - Date depart : ");
                        depart = demanderDate();
                         {
                            try {
                                envoyerMessage(locManager.updateLocation(lieu, new Periode(arrivee, depart)) ? "reservation ajoutée " : "reservation impossible");
                                input.readLine();
                            } catch (ParseException ex) {
                            }
                        }
                        break;
                    case "6":
                        envoyerMessage("supprimer une reservation :\n"
                                + " - Lieu : ");
                        lieu = input.readLine();
                        envoyerMessage(" - Date arrivee : ");
                        arrivee = demanderDate();
                        envoyerMessage(" - Date depart : ");
                        depart = demanderDate();
                         {
                            try {
                                envoyerMessage(locManager.deleteLocationPeriode(lieu, new Periode(arrivee, depart)) ? "reservation supprimée " : "la reservation n'eiste pas");
                                input.readLine();
                            } catch (ParseException ex) {
                            }
                        }
                        break;
                    case "7":
                        envoyerMessage("Afficher tarif location :\n"
                                + " - Lieu : ");
                        lieu = input.readLine();
                        envoyerMessage(" - Type : ");
                        genre = demanderGenre();
                        envoyerMessage(locManager.afficherTarif(lieu,genre));
                        input.readLine();
                        break;
                    default:
                        envoyerMessage("Commande incorrecte");
                        input.readLine();
                        break;
                }
            } catch (IOException ex) {
                try {
                    input.close();
                    output.close();
                    cs.close();
                } catch (IOException ex1) {
                } finally {
                    System.out.println("Connexion perdue avec le client");
                    return;
                }
            }
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
        menu += "   7) afficher tarif location\n";
        menu += "\n";
        menu += "Votre choix : ";
        return menu;
    }

    void envoyerMessage(String message) {
        try {
            output.write(message.replaceAll("\n", "AntiSlash") + "\n");
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequetteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int demanderInt() {
        while (true) {
            try {
                int result = Integer.parseInt(input.readLine());
                return result;
            } catch (NumberFormatException e) {
                envoyerMessage("veuillez entrer un entier");
            } catch (IOException ex) {
                Logger.getLogger(RequetteManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    String demanderDate() {
        SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String resultat = input.readLine();
                Date d = sDF.parse(resultat);
                return resultat;
            } catch (ParseException ex) {
                envoyerMessage("veuillez entrer une date au format jj/mm/aaaa");
            } catch (IOException ex) {
                Logger.getLogger(RequetteManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    Genre demanderGenre() {
        String entry;
        while (true) {
            try {
                entry = input.readLine();
                switch (entry) {
                    case "maison":
                        return Genre.MAISON;
                    case "appartement":
                        return Genre.APPARTEMENT;
                    case "studio":
                        return Genre.STUDIO;
                    default:
                        envoyerMessage("ce type n'est pas reférencé : entrer maison, appartement ou studio");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(RequetteManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
