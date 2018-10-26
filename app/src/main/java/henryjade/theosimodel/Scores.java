package henryjade.theosimodel;

public class Scores {
    private int _id;
    private int score;
    private String playdate;
    private String category;



    public Scores(){
        _id=0;
        score = 0;
        playdate = "";
        category = "";
    }

    public Scores(int score, String playdate, String category){
        this.score = score;
        this.playdate = playdate;
        this.category = category;
    }

    public int get_id() {
        return _id;
    }

    public int getScore() {
        return score;
    }

    public String getPlaydate() {
        return playdate;
    }

    public String getCategory() {
        return category;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlaydate(String playdate) {
        this.playdate = playdate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return score + "    " + playdate + "    " + category;
    }
}
