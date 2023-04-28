package ir.ac.kntu.models;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;

    private String phoneNumber;

    private String email;

    private int hashPassword;

    private double wallet;

    private ArrayList<String> library;

    private ArrayList<String> friends;

    private ArrayList<String> requests;

    public User(String username, String phoneNumber, String email, String password) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        hashPassword = password.hashCode();
        wallet = 0;
        library = new ArrayList<>();
        friends = new ArrayList<>();
        requests = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean setNewPassword(String newPassword, String oldPassword) {

        if (oldPassword.hashCode() != hashPassword) {
            return false;
        }
        hashPassword = newPassword.hashCode();
        return true;
    }

    public boolean checkPassword(String password) {
        if (password.hashCode() == hashPassword) {
            return true;
        }
        return false;
    }

    public double getWallet() {
        return wallet;
    }

    public void chargeWallet(double value) {
        wallet += value;
    }

    public boolean payWallet(double price) {
        if (wallet < price) {
            return false;
        }
        wallet -= price;
        return true;
    }

    public ArrayList<String> getLibrary() {
        return library;
    }

    public boolean addGame(Game game) {
        if (library.indexOf(game.getName()) == -1) {
            library.add(game.getName());
            return true;
        }
        return false;
    }

    public boolean doHaveGame(Game game) {
        if (library.indexOf(game.getName()) != -1) {
            return true;
        }
        return false;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public boolean isFriend(User user) {
        if (friends.indexOf(user.getUsername()) != -1) {
            return true;
        }
        return false;
    }

    public boolean addFriend(User user) {
        if (friends.indexOf(user.getUsername()) != -1) {
            return false;
        }
        friends.add(user.getUsername());
        requests.remove(user.getUsername());
        return true;
    }

    public boolean removeFriend(User user) {
        if (friends.indexOf(user.getUsername()) != -1) {
            friends.remove(user.getUsername());
            return true;
        }
        return false;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    public boolean addRequest(User user) {
        if (requests.indexOf(user.getUsername()) != -1 || !isFriend(user)) {
            requests.add(user.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return username == user.getUsername();
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }


    @Override
    public String toString() {
        return "Username :" + username + " | Email : " + email + " | 5 last Game  \n" + lastGameName();
    }
    public void showProfile(){
        TerminalColor.blue();
        System.out.println("|----------------------------");
        TerminalColor.cyan();
        System.out.print("| Username     : "+username);
        TerminalColor.reset();
        System.out.print("  -----  ");
        TerminalColor.cyan();
        System.out.println(wallet + "$");
        TerminalColor.yellow();
        System.out.println("| Phone number : "+phoneNumber);
        System.out.println("| Email        : "+email);
        TerminalColor.blue();
        System.out.println("|----------------------------");
        TerminalColor.reset();
    }

    private String lastGameName() {
        String result = "";
        int i = 5;
        if (library.size() < 5) {
            i = library.size();
        }
        for (; i > 0; i--) {
            result += i + " - " + library.get(library.size() - 1 - i) + " \\ ";
        }
        return result;
    }
}
