package ir.ac.kntu;

public class Community {
    private String username;
    private double score;
    private String comment;

    public Community(String username, double score, String comment) {
        this.username = username;
        this.score = score;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User: " + username + " - " + score + "\n" + comment;
    }
}
