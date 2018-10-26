package henryjade.theosimodel;

public class Question {
    private int id;
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String answer;
    private String layer;

    public Question(){
        id=0;
        question = "";
        optA = "";
        optB = "";
        optC = "";
        answer = "";
        layer = "";
    }

    public Question(String question, String optA, String optB, String optC, String answer, String layer){
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.answer = answer;
        this.layer = layer;
    }


    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOptC() {
        return optC;
    }

    public String getOptB() {
        return optB;
    }

    public String getOptA() {
        return optA;
    }

    public String getQuestion() {
        return question;
    }

    public String getLayer() {
        return layer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setLayer(String layer) {
        this.answer = layer;
    }
}