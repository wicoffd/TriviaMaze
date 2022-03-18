package Model;

import View.Main;

import java.util.Random;

public class QuestionEncounter extends SQLFillTable {
    Random random = new Random();
    private int difficulty = 50; //TODO implement difficulty
    public String[] Question(int i){

        String[] array = SQLFillTable.questionsList.get(i).toString().split(", ");
        return array;
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
        int r = random.nextInt(6);
        String[] temp = Question(r);
        String q = temp[0];
        String a = temp[1];
        System.out.println(q);
        Main.sound.PlaySound(Main.sound.strangeOccurence);
        String userAnswer = Main.scan.nextLine();
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
