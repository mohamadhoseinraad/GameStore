package ir.ac.kntu.menu.User;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.User;

public class UserMenu extends Menu {

    private Store storeDB;

    public UserMenu(Store store) {
        this.storeDB = store;
    }

    @Override
    public void showMenu() {
        UserMenuOption option;
        while ((option = printMenuOptions("Game Store", UserMenuOption.class)) != UserMenuOption.EXIT) {
            if (option != null) {
                switch (option) {
                    case PROFILE: {
                        profile();
                        break;
                    }
                    case STORE: {
                        store();
                        break;
                    }
                    case LIBRARY: {
                        library();
                        break;
                    }
                    case FRIENDS: {
                        friends();
                        break;
                    }
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
    }

    public void profile() {
    }

    public void store() {
    }

    public void library() {
    }

    public void friends() {
    }
}
