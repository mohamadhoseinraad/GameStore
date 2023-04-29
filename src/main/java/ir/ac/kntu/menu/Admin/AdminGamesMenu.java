package ir.ac.kntu.menu.Admin;

import ir.ac.kntu.Store;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.User;

public class AdminGamesMenu extends Menu {

    private Store storeDB;
    private User admin;

    public AdminGamesMenu(Store storeDB, User admin) {
        this.storeDB = storeDB;
        this.admin = admin;
    }

    @Override
    public void showMenu() {
        AdminGamesMenuOptions option;
        while ((option = printMenuOptions("Admin Menu-Games", AdminGamesMenuOptions.class)) != AdminGamesMenuOptions.EXIT) {
            if (option != null) {
                switch (option) {
                    case ADD_GAME: {
                        addGame();
                        break;
                    }
                    case EDIT_GAME: {
                        editGame();
                        break;
                    }
                    case REMOVE_GAME: {
                        removeGame();
                        break;
                    }
                    case BACK: {
                        return;
                    }
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
        System.exit(0);
    }
    public void addGame(){

    }
    public void editGame(){

    }
    public void removeGame(){

    }
}
