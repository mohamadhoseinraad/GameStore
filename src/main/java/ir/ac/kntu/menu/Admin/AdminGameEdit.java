package ir.ac.kntu.menu.Admin;

import ir.ac.kntu.Scan;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.Game;

public class AdminGameEdit extends Menu {

    Game currentGame;

    public AdminGameEdit(Game currentGame) {
        this.currentGame = currentGame;
    }

    @Override
    public void showMenu() {
        AdminGameEditOptions option;
        currentGame.showGame();
        while ((option = printMenuOptions("EDIT Games", AdminGameEditOptions.class)) != AdminGameEditOptions.EXIT) {
            if (option != null) {
                switch (option) {
                    case EDIT_NAME: {
                        editName();
                        break;
                    }
                    case EDIT_GENRE: {
                        editGenre();
                        break;
                    }
                    case EDIT_DETAIL: {
                        editDetail();
                        break;
                    }
                    case EDIT_PRICE: {
                        editPrice();
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
    public void editPrice(){
        System.out.println("Enter new price : ");
        String input = Scan.getLine();
        if (input.matches("[0-9][0-9.]*")){
            double newPrice = Double.parseDouble(input);
            currentGame.setPrice(newPrice);
            return;
        }
        TerminalColor.red();
        System.out.println("Enter valid price!");
        TerminalColor.reset();
    }

    public void editName(){

    }

    public void editDetail(){

    }

    public void editGenre(){

    }

}
