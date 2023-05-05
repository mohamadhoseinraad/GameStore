package ir.ac.kntu.menu.User.Profile;

import ir.ac.kntu.HelperClasses.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.HelperClasses.TerminalColor;
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

    private boolean userProfile() {
        user.showProfile();
        return true;
    }

    private void changeUsername() {
        System.out.println("Enter your new username:");
        String newUsername = Scan.getLine().toUpperCase().trim();
        TerminalColor.red();
        if (newUsername.length() < 3) {
            System.out.println("Username must be 3  or more character!");
            TerminalColor.reset();
            return;
        }
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
    }

    private void changeEmail() {
        System.out.println("Enter your new email:");
        String newEmail = Scan.getLine().toLowerCase().trim();
        TerminalColor.red();
        if (!newEmail.matches(".*@.*")) {
            System.out.println("New email is not valid!");
            TerminalColor.reset();
            return;
        }
        if (newEmail.equals(user.getEmail())) {
            System.out.println("New email is same as previous email !");
            TerminalColor.reset();
            return;
        }
        user.setEmail(newEmail);
        TerminalColor.green();
        System.out.println("email changed :D");
        TerminalColor.reset();
    }

    private void changePhoneNumber() {
        System.out.println("Enter your new phone number:");
        String newPhoneNumber = Scan.getLine().toUpperCase().trim();
        TerminalColor.red();
        if (!newPhoneNumber.matches("[0-9+]+")) {
            System.out.println("New phone number is not valid!");
            return;
        }
        if (newPhoneNumber.equals(user.getEmail())) {
            System.out.println("New phone number is same as previous email !");
            return;
        }
        user.setPhoneNumber(newPhoneNumber);
        TerminalColor.green();
        System.out.println("phone number changed :D");
        TerminalColor.reset();
    }

    private void chargeWallet() {
        System.out.println("how much you want amount ? (1+ $)");
        String amount = Scan.getLine();
        TerminalColor.red();
        int errorCount = 0;
        while (!amount.matches("[1-9][0-9.]+") || Double.parseDouble(amount) < 1) {
            errorCount++;
            if (errorCount > 2) {
                System.out.println("Charge wallet fail !");
                return;
            }
            System.out.println("Invalid amount ! Try again :");
            amount = Scan.getLine();

        }
        user.chargeWallet(Double.parseDouble(amount));
        TerminalColor.green();
        System.out.println("Your wallet charged inventory : " + user.getWallet());
        TerminalColor.reset();
    }

    private void changePassword() {
        int error = 0;
        while (error < 3) {
            System.out.println("Enter old password:");
            String oldPassword = Scan.getLine().trim();
            System.out.println("Enter new password:");
            String newPassword = Scan.getLine().trim();
            if (newPassword.length() < 8) {
                TerminalColor.red();
                System.out.println("New password must be 8 or more character");
                TerminalColor.reset();
            } else if (user.setNewPassword(newPassword, oldPassword)) {
                TerminalColor.green();
                System.out.println("Password successfully !");
                TerminalColor.reset();
                return;
            } else {
                TerminalColor.red();
                System.out.println("Old password is not correct!");
                TerminalColor.reset();
            }
            TerminalColor.red();
            System.out.println("Fail change password !");
            TerminalColor.reset();
            error++;
        }
    }
}
