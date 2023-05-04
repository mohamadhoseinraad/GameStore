package ir.ac.kntu;

import ir.ac.kntu.models.Game;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.UserType;

import java.util.*;

public class Store {
    private Set<User> users;

    private Set<Game> games;

    public Store(Set<User> users, Set<Game> games) {
        this.users = new HashSet<>(users);
        this.games = new HashSet<>(games);
    }

    public Store() {
        users = new HashSet<>();
        games = new HashSet<>();
    }

    public Set<User> getUsers() {
        return new HashSet<>(users);
    }

    public void setUsers(Set<User> users) {
        this.users = new HashSet<>(users);
    }

    public Set<Game> getGames() {
        return new HashSet<>(games);
    }

    public void setGames(Set<Game> games) {
        this.games = new HashSet<>(games);
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
        for (User u : users) {
            if (u.getPhoneNumber().compareTo(phoneNumber) >= 0) {
                result.add(u);
            }
        }
        return result;
    }

    public Game findGame(int id , String name){
        for (Game game : games){
            if (game.getId() == id && game.getName().equals(name)){
                return game;
            }
        }
        return null;
    }

    public ArrayList<Game> findGameByName(String name) {
        ArrayList<Game> result = new ArrayList<>();
        for (Game game : games) {
            if (game.getName().startsWith(name)) {
                result.add(game);
            }
        }
        return result;
    }

    public ArrayList<Game> findGameByPrice(double basePrice, double maxPrice) {
        ArrayList<Game> result = new ArrayList<>();
        for (Game game : games) {
            if (game.getPrice() >= basePrice && game.getPrice() <= maxPrice) {
                result.add(game);
            }
        }
        return result;
    }

    public ArrayList<User> findUserByEmail(String email) {
        ArrayList<User> result = new ArrayList<>();
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                result.add(u);
            }
        }
        return result;
    }

    public boolean addGame(Game newGame) {
        String name = new String(newGame.getName());
        String detail = new String(newGame.getDetails());
        String genre = new String(newGame.getGenre());
        double price = newGame.getPrice();
        Game game = new Game(name, detail, genre, price);
        return games.add(game);
    }

    public boolean removeGame(Game game) {
        for (Game gg : games) {
            if (gg.equals(game)) {
                return games.remove(game);
            }
        }
        return false;
    }

    public boolean addUser(User newUser) {
        return users.add(newUser);
    }

    public boolean loginUser(String username, String password) {
        username = username.toUpperCase().trim();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.checkPassword(password);
            }
        }
        return false;
    }

    public boolean addAdmin(String username, String password) {
        User admin = new User(username, "", "", password, UserType.ADMIN);
        return users.add(admin);
    }
}
