/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enjoy
 */
public class Utilities {

    private Scanner input = new Scanner(System.in);
    static protected SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");

    Utilities() {

    }

    public int entrerInt() {
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("veuillez entrer un entier");
            }
        }
    }

    public String entrerDate() {
        while (true) {
            String resultat = input.nextLine();
            try {
                Date d = sDF.parse(resultat);
                return resultat;
            } catch (ParseException ex) {
                System.out.println("veuillez entrer une date au format jj/mm/aaaa");
            }
        }
    }

    public String entrerString() {
        return input.nextLine();
    }

    public Genre entrerGenre() {
        String entry;
        while (true) {
            entry = input.nextLine();
            switch (entry) {
                case "maison":
                    return Genre.MAISON;
                case "appartement":
                    return Genre.APPARTEMENT;
                case "studio":
                    return Genre.STUDIO;
                default:
                    System.out.println("ce type n'est pas reférencé");
                    System.out.println("entrer maison, appartement ou studio");
                    break;
            }
        }
    }
}
