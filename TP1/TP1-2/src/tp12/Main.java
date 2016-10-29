package tp12;


public class Main {

    public static void main(String[] args) {

        Menu_principal menu = new Menu_principal(new Locations());
        while (true) {
            menu.afficheMenu();
        }

    }

}
