package Model;

import View.Main;

import java.util.Random;

public class QuestionEncounter extends Main {
    Random random = new Random();
    private int difficulty = 50; //TODO implement difficulty
    public String[] Question(){
        String[] question = new String[2];// TODO implement more efficient
        question[0] = "What is the color of night?";
        question[1] = "sanguine";
        return question;
    }
    public boolean shouldQuestionBeAsked() {
        int temp = random.nextInt(100);
        if(temp > difficulty){
            //System.out.println("ask question");
            return true;
        }
        else{
            //System.out.println("no question");
            return false;
        }
    }

    public boolean isPlayerAnswerCorrect() {
        String[] temp = Question();
        String q = temp[0];
        String a = temp[1];
        System.out.println(q);
        Main.sound.PlaySound(Main.sound.strangeOccurence);
        String userAnswer = scan.nextLine();
        if(userAnswer.equals(a)) {
            return true;
        }else{
            return false;
        }
    }
    public void setDifficulty(int percent) {
        if(percent > 0) {
            difficulty = percent;
        }else {
            System.out.println("Bad difficulty");
        }
    }
    public int getDifficulty() {
        return difficulty;
    }
}
