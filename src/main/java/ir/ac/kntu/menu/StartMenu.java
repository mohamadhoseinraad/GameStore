package ir.ac.kntu.menu;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;

public class StartMenu extends Menu {

    private Store storeDB;

    public StartMenu(Store store) {
        this.storeDB = store;
    }

    @Override
    public void showMenu() {
        StartOption option;
        while ((option = printMenuOptions("Game Store", StartOption.class)) != StartOption.EXIT) {
            if (option != null) {
                switch (option) {
                    case LOGIN: {
                        loginUser();
                        break;
                    }
                    case SING_UP: {
                        System.out.println("Sing up");
                        break;
                    }
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
    }

    public void loginUser() {
        TerminalColor.blue();
        System.out.println("---- Log in ----");
        TerminalColor.reset();
        System.out.println("User name:");
        String username = Scan.getLine();
        System.out.println("Password:");
        String password = Scan.getLine();
        if (storeDB.isValidUser(username, password)) {
            TerminalColor.green();
            System.out.println("Welcome " + username);
            TerminalColor.reset();
        } else {
            TerminalColor.red();
            System.out.println("username of password incorrect1");
            TerminalColor.reset();
        }
    }
}
