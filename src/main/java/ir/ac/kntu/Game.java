import java.util.ArrayList;
import java.util.Map;

public class Game {
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

    @Override
    public String toString() {
        return "Game{\n" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", score=" + score +
                ", details='\n" + details +
                "\n}";
    }
}
