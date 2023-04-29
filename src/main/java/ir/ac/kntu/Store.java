package ir.ac.kntu;

import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.UserType;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public User findUserByUsername(String username) {
        username = username.toUpperCase();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }

        }
        return null;
    }

    public ArrayList<User> findUserByPhoneNumber(String phoneNumber) {
        ArrayList<User> result = new ArrayList<>();
        phoneNumber = phoneNumber.trim();
        for (User u : users) {
            if (u.getPhoneNumber().compareTo(phoneNumber) >= 0) {
                result.add(u);
            }
        }
        return result;
    }

    public ArrayList<User> findUserByEmail(String email) {
        ArrayList<User> result = new ArrayList<>();
        email = email.trim().toLowerCase();
        for (User u : users) {
            if (u.getEmail().compareTo(email) >= 0) {
                result.add(u);
            }
        }
        return result;
    }

    public boolean addGame(Game newGame) {
        return games.add(newGame);
    }

    public boolean addUser(User newUser) {
        return users.add(newUser);
    }

    public boolean isValidUser(String username, String password) {
        username = username.toUpperCase().trim();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.checkPassword(password);
            }
        }
        return false;
    }

    public boolean addAdmin(String username, String password){
        User admin = new User(username,"","",password, UserType.ADMIN);
        return users.add(admin);
    }
}
