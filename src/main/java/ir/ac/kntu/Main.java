package ir.ac.kntu;

import ir.ac.kntu.menu.Auth.AuthMenu;
import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.UserType;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        User user = new User("ABC", "09", "qw", "123", UserType.USER);
        User user2 = new User("ABCD", "09", "qw", "123",UserType.USER);
        User amin = new User("admin", "09", "qw", "123",UserType.ADMIN);
        Game g1 = new Game("swdgf","3", "we",10);
        Game g2 = new Game("swd","3", "we",5);
        Game g3 = new Game("swdg","3", "we",22);
        store.addUser(user);
        store.addUser(user2);
        store.addUser(amin);
        store.addGame(g1);
        store.addGame(g2);
        store.addGame(g3);
        user.chargeWallet(100);
        System.out.println(g1);
        System.out.println(user.addGame(g1));
        AuthMenu authMenu = new AuthMenu(store);
        authMenu.showMenu();

    }
}