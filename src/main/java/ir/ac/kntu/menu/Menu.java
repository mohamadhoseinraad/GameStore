package ir.ac.kntu.menu;

import ir.ac.kntu.Scan;

public abstract class Menu {

    abstract void showMenu();

    public <T extends Enum<T>> T getOption(Class<T> menuEnum) {
        T[] options = menuEnum.getEnumConstants();
        int choice = Integer.parseInt(Scan.getLine().trim()) - 1;
        if (choice >= 0 && choice < options.length) {
            return options[choice];
        }
        System.out.println("\\u001B[31mRed Error Wrong choice !");
        return null;
    }

    public <T extends Enum<T>> T printMenuOptions(String title, Class<T> menuEnum) {
        System.out.println("----------" + title + "----------");
        T[] options = menuEnum.getEnumConstants();
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + " - " + options[i]);
        }
        System.out.print("Enter your choice : ");
        return getOption(menuEnum);
    }
}
