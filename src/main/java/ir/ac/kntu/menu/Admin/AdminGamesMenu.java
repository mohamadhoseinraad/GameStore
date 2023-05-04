package ir.ac.kntu.menu.Admin;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.GameSearch;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;

import java.util.ArrayList;

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

    public void addGame() {
        Game newGame = Game.makeGame();
        if (newGame != null) {
            if (storeDB.addGame(newGame)) {
                TerminalColor.green();
                System.out.println(newGame.getName() + " added to DB");
                TerminalColor.reset();
            }
        }
        return;
    }

    public void editGame() {
        GameSearch gameSearch = new GameSearch(storeDB);
        Game game = gameSearch.searchMenu();
        if (game == null){
            return;
        }
        AdminGameEdit adminGameEdit = new AdminGameEdit(game);
        adminGameEdit.showMenu();
    }

    public void removeGame() {
        GameSearch gameSearch = new GameSearch(storeDB);
        Game game = gameSearch.searchMenu();
        if (storeDB.removeGame(game) && !game.equals(null)) {
            TerminalColor.green();
            System.out.println(game.getName() + " with " + game.getId() + " id successfully deleted !");
            TerminalColor.reset();
            return;
        }
        TerminalColor.red();
        System.out.println("Fail delete game !");
        TerminalColor.red();
    }

}
