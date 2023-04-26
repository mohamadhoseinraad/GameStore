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

    public User findUser(String username) {
        for (User u : users){
            if (u.getUsername().equals(username));
            return u;
        }
        return null;
    }
    public boolean addGame(Game game){
        return games.add(game);
    }
}
