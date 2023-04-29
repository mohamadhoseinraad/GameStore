package ir.ac.kntu.models;

import ir.ac.kntu.Community;
import ir.ac.kntu.Scan;
import ir.ac.kntu.TerminalColor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Game {
    public static int gamesNumber = 0;

    private final int id;

    private String name;

    private String details;

    private String genre;

    private double price;

    private double score;

    private ArrayList<Community> communities;

    public Game(String name, String details, String genre, double price) {
        this.name = name;
        this.details = details;
        this.genre = genre;
        this.price = price;
        score = 0;
        id = gamesNumber++;
        communities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(ArrayList<Community> communities) {
        this.communities = communities;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "ID-" + id +
                " name : " + name +
                " ,genre :" + genre +
                " ,price :" + price +
                " ,score :" + score +
                " ,details:" +
                details + "\n";
    }

    public void showGame(){
        TerminalColor.blue();
        System.out.println("|----------------------------");
        TerminalColor.cyan();
        System.out.print("| Name     : "+name);
        TerminalColor.reset();
        System.out.print("  -----  ");
        TerminalColor.cyan();
        System.out.println(price + "$ coast");
        TerminalColor.yellow();
        System.out.print("| Genre : "+genre);
        System.out.print(" | Score : ");
        scoreColor();
        System.out.println(score);
        TerminalColor.blue();
        System.out.println("|----------------------------");
        TerminalColor.reset();
    }

    private void scoreColor(){
        if (score < 3){
            TerminalColor.red();
        } else if (score <6) {
            TerminalColor.yellow();
        } else  {
            TerminalColor.green();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Game game = (Game) o;
        return id == game.getId() && name == game.getName() && genre == game.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre);
    }

    public static Game makeGame() {
        System.out.println("Pleas enter game name :");
        String name = Scan.getLine();
        System.out.println("Pleas enter game genre :");
        String genre = Scan.getLine();
        System.out.println("Pleas enter detail of game :");
        String detail = Scan.getLine();
        System.out.println("Pleas enter price :");
        double price = Double.parseDouble(Scan.getLine());

        return new Game(name, detail, genre, price);
    }
}
