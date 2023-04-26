package ir.ac.kntu.menu;

public class AdminGamesMenu extends Menu {
    @Override
    void showMenu() {
        System.out.println("-------- Admin menu Game ---------");
        System.out.println("1- Add Game");
        System.out.println("2- Remove Game");
        System.out.println("3- Edit Game");
        System.out.println("4- Back");
    }
}
