package ir.ac.kntu.menu;

import ir.ac.kntu.GameMenuOptions;
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

    @Override
    public <T extends Enum<T>> T printMenuOptions(String title, Class<T> menuEnum) {
        TerminalColor.cyan();
        System.out.println("----------" + title + "----------");
        TerminalColor.reset();
        currentGame.showGame();
        T[] options = menuEnum.getEnumConstants();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
        }
        System.out.print("Enter your choice : ");
        return getOption(menuEnum);
    }
}
