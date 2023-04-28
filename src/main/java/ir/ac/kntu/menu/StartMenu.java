package ir.ac.kntu.menu;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;

public class StartMenu extends Menu {

    private Store storeDB;

    public StartMenu(Store store){
        this.storeDB = store;
    }

    @Override
    void showMenu() {
        StartOption option;
        while ((option = printMenuOptions("Game Store", StartOption.class)) != StartOption.EXIT) {
            if (option != null){
                switch (option) {
                    case LOGIN: {
                        System.out.println("Log in");
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
    public void loginUser(){
        System.out.println("\\u001B[34m---- Log in ----");
        System.out.println("\\u001B[33mUser name:");
        String username = Scan.getLine();
        System.out.println("\\u001B[33mUser name:");
        String password = Scan.getLine();
        if (storeDB.isValidUser(username,password)){
            System.out.println("\\u001B[32mWelcome "+ username);
        }
        else {
            System.out.println("\\u001B[31username of password incorrect1");
        }
    }
}
