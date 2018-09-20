package fr.eni.ecole.repo;

public class question {

    private int idQuestion;
    private String enonce;
    private String media;
    private int points;
    private int idTheme;

    public question(int idQuestion, String enonce, String media, int points, int idTheme) {
        this.enonce = enonce;
        this.media = media;
        this.points = points;
        this.idTheme = idTheme;


    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }


}
