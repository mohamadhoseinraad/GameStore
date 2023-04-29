package ir.ac.kntu;

import ir.ac.kntu.menu.Auth.AuthMenu;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.UserType;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        User user = new User("ABC", "09", "qw", "123", UserType.USER);
        User user2 = new User("ABCD", "09", "qw", "123",UserType.USER);
        store.addUser(user);
        store.addUser(user2);
        AuthMenu authMenu = new AuthMenu(store);
        authMenu.showMenu();

    }
}