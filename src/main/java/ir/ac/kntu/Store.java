package ir.ac.kntu;

import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Store {
    private Set<User> users;
    private Set<Game> games;

    public Store(Set<User> users, Set<Game> games) {
        this.users = users;
        this.games = games;
    }

    public Store() {
        users = new HashSet<>();
        games = new HashSet<>();
    }

    public ArrayList<User> findUserByUsername(String username) {
        ArrayList<User> result = new ArrayList<>();
        for (User u : users) {
            if (u.getUsername().compareTo(username) >= 0) ;
            result.add(u);
        }
        return result;
    }

    public ArrayList<User> findUserByPhoneNumber(String phoneNumber) {
        ArrayList<User> result = new ArrayList<>();
        for (User u : users) {
            if (u.getPhoneNumber().compareTo(phoneNumber) >= 0) ;
            result.add(u);
        }
        return result;
    }

    public ArrayList<User> findUserByEmail(String email) {
        ArrayList<User> result = new ArrayList<>();
        for (User u : users) {
            if (u.getEmail().compareTo(email) >= 0) ;
            result.add(u);
        }
        return result;
    }

    public boolean addGame(Game game) {
        return games.add(game);
    }
}
