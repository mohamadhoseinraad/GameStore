package ir.ac.kntu;

import ir.ac.kntu.models.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        User user = new User("ABC","09","qw","123");
        User user2 = new User("ABCD","09","qw","123");
        store.addSpecialUser(user);
        store.addSpecialUser(user2);
        System.out.println(store.getUsers());
    }
}