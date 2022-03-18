package Model;
public class Question {
    private String answer;
    private String question;
    public Question(String q, String a) {
        question = q;
        answer = a;
    }
    public String toString() {
        return "Question , " + question + ", Answer , " + answer;
    }
}
