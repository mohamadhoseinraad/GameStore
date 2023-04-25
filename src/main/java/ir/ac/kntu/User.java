package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class User {
    private String username;
    private String phoneNumber;
    private String email;
    private int hashPassword;
    private double wallet;
    private ArrayList<Game> library;
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

        if (oldPassword.hashCode() != hashPassword){
            return false;
        }
        hashPassword = newPassword.hashCode();
        return true;
    }
    public boolean checkPassword(String password){
        if (password.hashCode() == hashPassword){
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

    public void payWallet(double price) {
        wallet -= price;
    }

    public ArrayList<Game> getLibrary() {
        return library;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && phoneNumber.equals(user.phoneNumber) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, phoneNumber, email);
    }
}
