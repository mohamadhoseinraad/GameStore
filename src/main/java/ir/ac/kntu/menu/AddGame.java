package ir.ac.kntu.menu;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.models.Game;

public class AddGame extends Menu{
    @Override
    void showMenu() {

    }
    public Game addGame(){
        System.out.println("Enter name of game:");
        String gameName = Scan.getLine();
        System.out.println("Enter genre:");
        String gameGenre = Scan.getLine();
        System.out.println("Enter price:");
        double gamePrice = Double.parseDouble(Scan.getLine());
        System.out.println("Enter detail:");
        String gameDetail = Scan.getLine();

        return new Game(gameName,gameDetail,gameGenre,gamePrice);

    }
}
