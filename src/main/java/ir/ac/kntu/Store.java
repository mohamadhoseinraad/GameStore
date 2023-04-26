package ir.ac.kntu;

import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;

import java.util.ArrayList;

public class Store {
    private ArrayList<User> users;
    private ArrayList<Game> games;

    public Store(ArrayList<User> users, ArrayList<Game> games) {
        this.users = users;
        this.games = games;
    }

    public Store() {
        users = new ArrayList<>();
        games = new ArrayList<>();
    }

    public User findUser(String username) {
        for (User u : users){
            if (u.getUsername().equals(username));
            return u;
        }
        return null;
    }
}
