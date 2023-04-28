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
        store.addUser(user);
        store.addUser(user2);

        StartMenu startMenu = new StartMenu(store);
        startMenu.showMenu();


    }


}