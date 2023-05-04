package ir.ac.kntu.menu.User;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;

public class GameLibraryMenu extends Menu {

    private User currentUser;

    private Game currentGame;

    private Store storeDB;

    public GameLibraryMenu(User currentUser, Game currentGame, Store storeDB) {
        this.currentUser = currentUser;
        this.currentGame = currentGame;
        this.storeDB = storeDB;
    }

    @Override
    public void showMenu() {
        GameLibraryMenuOptions option;
        while (printGame() && (option = printMenuOptions(currentGame.getName(), GameLibraryMenuOptions.class)) != GameLibraryMenuOptions.EXIT) {
            switch (option) {
                case RATE: {
                    rate();
                    break;
                }
                case COMMENT: {
                    comment();
                    break;
                }
                case SHOW_COMMENTS: {
                    showComments();
                    return;
                }
                case BACK:{
                    return;
                }
                default: {
                    break;
                }
            }
        }
        System.exit(0);
    }

    public boolean printGame() {
        currentGame.showGame();
        return true;
    }

    public void rate() {
        System.out.println("Enter your rate");
        String rateStr;
        while (!(rateStr = Scan.getLine()).matches("[0-9]|10")){
            TerminalColor.red();
            System.out.println("Please enter valid rate between 0-10");
            TerminalColor.reset();
        }

    }

    public void comment() {
        System.out.println("Enter your comment");
        String userComment = Scan.getLine().trim().toUpperCase();
    }

    public void showComments() {
        System.out.println("Enter your comment");
        String userComment = Scan.getLine().trim().toUpperCase();
    }

}
