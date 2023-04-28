package ir.ac.kntu.menu.Auth;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.User.UserMenu;
import ir.ac.kntu.models.User;

public class AuthMenu extends Menu {

    private Store storeDB;

    public AuthMenu(Store store) {
        this.storeDB = store;
    }

    @Override
    public void showMenu() {
        AuthMenuOptions option;
        while ((option = printMenuOptions("Game Store", AuthMenuOptions.class)) != AuthMenuOptions.EXIT) {
            if (option != null) {
                switch (option) {
                    case LOGIN: {
                        loginUser();
                        break;
                    }
                    case SING_UP: {
                        singup();
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
        String username = Scan.getLine().toUpperCase().trim();
        System.out.println("Password:");
        String password = Scan.getLine().trim();
        if (storeDB.isValidUser(username, password)) {
            User user = storeDB.findUserByUsername(username);
            UserMenu userMenu = new UserMenu(storeDB, user);
            userMenu.showMenu();
        } else {
            TerminalColor.red();
            System.out.println("Username or password incorrect!");
            TerminalColor.reset();
        }
    }

    public void singup() {
        TerminalColor.blue();
        System.out.println("---- Log in ----");
        TerminalColor.reset();
        System.out.println("User name:");
        String username = Scan.getLine();
        System.out.println("Phone number:");
        String phoneNumber = Scan.getLine();
        System.out.println("Email:");
        String email = Scan.getLine();
        System.out.println("Password:");
        String password = Scan.getLine();
        TerminalColor.red();
        if (storeDB.findUserByUsername(username) != null) {
            System.out.println("This username already taken!");
        } else if (!email.matches(".*@.*")) {
            System.out.println("Email is not valid!");
        } else if (password.length() < 8) {
            System.out.println("Password length must 8 or more!");
        } else {
            boolean result = storeDB.addUser(new User(username, phoneNumber, email, password));
            if (!result) {
                System.out.println("Sing up unsuccessfully!");
            } else {
                TerminalColor.green();
                System.out.println("Sing up successfully.Now you can log in");
            }
        }
        TerminalColor.reset();
    }
}
