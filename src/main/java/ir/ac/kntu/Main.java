package ir.ac.kntu;

import ir.ac.kntu.menu.StartMenu;
import ir.ac.kntu.models.User;

import java.util.Scanner;

public class Main {
    enum Option {LOGIN, SING_UP, EXIT, UNDEFINED}

    public static void main(String[] args) {
        Store store = new Store();
        User user = new User("ABC", "09", "qw", "123");
        User user2 = new User("ABCD", "09", "qw", "123");
        store.addSpecialUser(user);
        store.addSpecialUser(user2);

        StartMenu startMenu = new StartMenu(store);
        startMenu.showMenu();


    }

    public static void showMenu() {
        System.out.println("-------- Game Store ---------");
        System.out.println("Chose Option : ");
        System.out.println("1- Login");
        System.out.println("2- Sing up");
        System.out.println("3-  Exit");
    }

    public static Option handleOption() {
        int option = Integer.parseInt(Scan.getLine()) - 1;
        Option[] options = Option.values();
        if (option < options.length && option >= 0) {
            return options[option];
        }
        return Option.UNDEFINED;
    }
}