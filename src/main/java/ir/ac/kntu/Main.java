package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Store store = new Store();

    enum Options {SING_IN, SING_UP, PROFILE, LIBRARY}
    enum Status { LONGIN , BACK , EXIT, }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mainMenu();

    }

    public static void mainMenu() {
        System.out.println("--------- Game Store ---------");
        System.out.println("1- Sing in");
        System.out.println("2- Sing up");
    }

    public Status login(Scanner sc) {
        Options options = Options.SING_IN;
        while (options == Options.SING_IN)
        System.out.println("--------- Game Store ---------");
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        if (handleSingIn(username,password)){
            return Status.LONGIN;
        }
        else {
            System.out.println("Wrong username of password!");
        }
        return null;

    }

    public boolean handleSingIn(String username, String password) {
        User user = store.findUser(username);
        if (user == null) return false;
        if (!user.checkPassword(password)) return false;
        return true;
    }
}