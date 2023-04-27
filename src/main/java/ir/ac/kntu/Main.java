package ir.ac.kntu;

import ir.ac.kntu.models.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        store.addUser();
        store.addUser();
        System.out.println("Searuser");
        String usenmae = Scan.getLine();
        User ue = store.findUserByUsername(usenmae);
        System.out.println(ue);
    }
}