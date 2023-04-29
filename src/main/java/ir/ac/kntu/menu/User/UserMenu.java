package ir.ac.kntu.menu.User;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.User;

public class UserMenu extends Menu {

    private Store storeDB;

    private User user;

    public UserMenu(Store store, User user) {
        this.storeDB = store;
        this.user = user;
    }

    @Override
    public void showMenu() {
        UserMenuOption option;
        TerminalColor.purple();
        System.out.println("Welcome " + user.getUsername());
        TerminalColor.reset();
        while ((option = printMenuOptions("User Menu", UserMenuOption.class)) != UserMenuOption.EXIT) {
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
                    case LOGOUT:
                        System.out.println("Back soon :)");
                        return;
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
        System.exit(0);
    }

    public void profile() {
        ProfileMenu profileMenu = new ProfileMenu(storeDB,user);
        profileMenu.showMenu();
    }

    public void store() {
    }

    public void library() {
    }

    public void friends() {
    }
}
