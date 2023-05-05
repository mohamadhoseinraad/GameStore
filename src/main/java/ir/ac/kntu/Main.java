package ir.ac.kntu;

import ir.ac.kntu.menu.Auth.AuthMenu;
import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.UserType;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        User user = new User("moohraad", "09934140117", "mh.shbanirad@icloud.com", "123qweasd", UserType.USER);
        User user2 = new User("mo.gamer", "09934140117", "mogamer@gmail.com", "12341234", UserType.USER);
        User amin = new User("admin", "", "", "admin", UserType.ADMIN);
        Game g1 = new Game("Fortnite", "Battle royall action game", "Action", 0);
        Game g2 = new Game("Rainbow six", "Action shooter game", "Action", 25);
        Game g3 = new Game("GTA V", "Story mode game form al life of a person", "Story", 35);
        Game g4 = new Game("Bomb", "Strategy game ", "Thinking", 0);
        store.addUser(user);
        store.addUser(user2);
        store.addUser(amin);
        store.addGame(g1);
        store.addGame(g2);
        store.addGame(g3);
        user.chargeWallet(100);
        Community community = new Community(user.getUsername(), "Awlliii");
        g1.addCommunity(community);
        user.addGame(g1);
        System.out.println(user);
        AuthMenu authMenu = new AuthMenu(store);
        authMenu.showMenu();

    }
}