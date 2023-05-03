package ir.ac.kntu.menu;

import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;

public class GameMenu extends Menu{

    private User currentUser;
    private Game currentGame;

    public GameMenu(User currentUser, Game currentGame) {
        this.currentUser = currentUser;
        this.currentGame = currentGame;
    }

    @Override
    public void showMenu() {
        GameMenuOptions option;
        while ((option = printMenuOptions(currentGame.getName(),GameMenuOptions.class) )!= GameMenuOptions.EXIT){
            switch (option){
                case BUY :{
                    buy();
                    break;
                }
                case GIFT :{
                    break;
                }
                case RATE :{
                    break;
                }
                case COMMENT :{
                    break;
                }
                case BACK:{
                    return;
                }
            }
        }
        System.exit(0);
    }

    public void buy() {
        if (currentUser.doHaveGame(currentGame)){
            TerminalColor.red();
            System.out.println("You already have this game!");
            TerminalColor.reset();
            return;
        }
        if (currentUser.addGame(currentGame)){
            TerminalColor.green();
            System.out.println("Buy Successfully :) ");
            TerminalColor.reset();
            return;
        }
        TerminalColor.red();
        System.out.println("You don't have enough money ! :(");
        TerminalColor.reset();
    }

    public void rate() {
    }

    public void gift() {
    }

    public void comment() {
    }
}
