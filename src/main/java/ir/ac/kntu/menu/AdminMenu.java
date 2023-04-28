package ir.ac.kntu.menu;

public class AdminMenu extends Menu {

    @Override
    public void showMenu() {
        System.out.println("-------- Admin Menu ---------");
        System.out.println("Chose Option : ");
        System.out.println("1- games");
        System.out.println("2- users");
        System.out.println("3-  Exit");
    }
}
