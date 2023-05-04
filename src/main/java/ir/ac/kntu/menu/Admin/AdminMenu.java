package ir.ac.kntu.menu.Admin;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.UserSearch;
import ir.ac.kntu.models.User;

public class AdminMenu extends Menu {

    private Store storeDB;

    private User admin;

    public AdminMenu(Store store, User admin) {
        this.storeDB = store;
        this.admin = admin;
    }

    @Override
    public void showMenu() {
        AdminMenuOption option;
        while ((option = printMenuOptions("Amin Menu", AdminMenuOption.class)) != AdminMenuOption.EXIT) {
            if (option != null) {
                switch (option) {
                    case USERS: {
                        users();
                        break;
                    }
                    case GAMES: {
                        games();
                        break;
                    }
                    case LOGOUT: {
                        return;
                    }
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
        System.exit(0);
    }

    public void users() {
        UserSearch userSearch = new UserSearch(storeDB);
        userSearch.showMenu();

    }

    public void games() {
        AdminGamesMenu adminGamesMenu = new AdminGamesMenu(storeDB, admin);
        adminGamesMenu.showMenu();
    }
}
