package ir.ac.kntu.menu.Admin;

import ir.ac.kntu.menu.Menu;

public class AdminGamesMenu extends Menu {

    @Override
    public void showMenu() {
        AdminGamesMenuOptions option;
        while ((option = printMenuOptions("Admin Menu", AdminGamesMenuOptions.class)) != AdminGamesMenuOptions.EXIT) {
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
    }
    public void addGame(){

    }
    public void editGame(){

    }
    public void removeGame(){

    }
}
