package ir.ac.kntu.menu.Admin;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.User;

public class AdminMenu extends Menu {

    private Store storeDB;

    public AdminMenu(Store store) {
        this.storeDB = store;
    }

    @Override
    public void showMenu() {
        AdminMenuOption option;
        while ((option = printMenuOptions("Game Store", AdminMenuOption.class)) != AdminMenuOption.LOGOUT) {
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
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
    }

    public void users() {

    }

    public void games() {

    }
}
