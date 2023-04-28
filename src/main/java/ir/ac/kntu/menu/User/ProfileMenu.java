package ir.ac.kntu.menu.User;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.User;

public class ProfileMenu extends Menu {
    private Store storeDB;

    private User user;

    public ProfileMenu(Store storeDB, User user) {
        this.storeDB = storeDB;
        this.user = user;
    }

    @Override
    public void showMenu() {
        ProfileMenuOptions option;
        while (userProfile() && (option = printMenuOptions("Profile", ProfileMenuOptions.class)) != ProfileMenuOptions.EXIT) {
            if (option != null) {
                switch (option) {
                    case CHANGE_USERNAME: {
                        changeUsername();
                        break;
                    }
                    case CHANGE_PHONE_NUMBER: {
                        changePhoneNumber();
                        break;
                    }
                    case CHANGE_EMAIL: {
                        changeEmail();
                        break;
                    }
                    case CHARGE_WALLET: {
                        chargeWallet();
                        break;
                    }
                    case CHANGE_PASSWORD: {
                        changePassword();
                        break;
                    }
                    case BACK:
                        return;
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
        System.exit(0);
    }

    public boolean userProfile() {
        user.showProfile();
        return true;
    }

    public void changeUsername() {
        System.out.println("Enter your new username:");
        String newUsername = Scan.getLine().toUpperCase();
        TerminalColor.red();
        if (newUsername.equals(user.getUsername())) {
            System.out.println("this username is same!");
            TerminalColor.reset();
            return;
        }
        User temp = storeDB.findUserByUsername(newUsername);
        if (temp != null && !temp.equals(user)) {
            System.out.println("this username is already taken!");
            TerminalColor.reset();
            return;
        }
        user.setUsername(newUsername);
        TerminalColor.green();
        System.out.println("Username changed :D");
        TerminalColor.reset();
        ;
    }

    public void changeEmail() {
        for (User ss : storeDB.getUsers()) {
            System.out.println(ss);
        }
        System.out.println("email");
    }

    public void changePhoneNumber() {
        System.out.println("phone");
    }

    public void chargeWallet() {
        System.out.println("wallet");
    }

    public void changePassword() {
        System.out.println("passs");
    }
}
