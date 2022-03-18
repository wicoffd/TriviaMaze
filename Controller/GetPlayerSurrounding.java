package Controller;
import Model.LiveInfo;
import Model.QuestionEncounter;
import View.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class GetPlayerSurrounding extends Main { // TODO write unit tests
    Connection conn = null;
    int staringLives = 3;
    int width = 0;
    int height= 0;
    char[] map;
    public int winPosition = 0;
    public QuestionEncounter questions = new QuestionEncounter();
    public LiveInfo lives = new LiveInfo(staringLives);
    public int movePlayer(char direction, int playerPos) {
       if(map[playerPos]== '3') {System.out.println("Congraturations you are winner!");
            return winPosition;
       }
        switch (direction) {
            case 'n':
                if ((playerPos - width) > 0) { // check invalid movement
                    if (map[playerPos - width] == '0' || map[playerPos - (width)] == '2') { // check for invalid movement
                        if (questions.shouldQuestionBeAsked()) {
                            if (questions.isPlayerAnswerCorrect()) { // correct answer
                                playerPos = movePlayerScript(playerPos, "north");
                            } else { // incorrect answer
                                System.out.println("The guardian is unsatisfied with your answer and injures you before leaving.");
                                lives.setLivesRemaining(lives.getLivesRemaining()-1);
                            }
                        } else {// no question
                            playerPos = movePlayerScript(playerPos, "north");
                        }
                    } else {
                        System.out.println("You bump into a wall.");
                    }
                }else{
                    System.out.println("You bump into a wall.");}
                return playerPos;

            case 'e':
                if((playerPos + 1) < map.length) { // check invalid movement
                    if (map[(playerPos + 1)] == '0'|| map[playerPos + 1] == '3') {
                        if (questions.shouldQuestionBeAsked()) {
                            if (questions.isPlayerAnswerCorrect()) { // correct answer
                                playerPos = movePlayerScript(playerPos, "east");
                            }else { // incorrect answer
                                System.out.println("The guardian is unsatisfied with your answer and injures you before leaving.");
                                lives.setLivesRemaining(lives.getLivesRemaining()-1);
                            }
                        } else {// no question
                            playerPos = movePlayerScript(playerPos, "east");
                        }
                    } else { // else invalid movement
                        System.out.println("You bump into a wall.");
                    }
                }
                else {
                    System.out.println("You bump into a wall.");
                }
                break;
            case 's':
                if((playerPos+width) < map.length) {// check invalid movement
                    if (map[(playerPos + width)] == '0') { // check invalid movement
                        if (questions.shouldQuestionBeAsked()) {
                            if (questions.isPlayerAnswerCorrect()) { // correct answer
                                playerPos = movePlayerScript(playerPos, "south");
                            } else { // incorrect answer
                                System.out.println("The guardian is unsatisfied with your answer and injures you before leaving.");
                                lives.setLivesRemaining(lives.getLivesRemaining() - 1);
                            }
                        }else { // no question
                            playerPos = movePlayerScript(playerPos, "south");
                        }
                    } else { // else invalid movement
                        System.out.println("You bump into a wall.");
                    }
                }
                else {
                    System.out.println("You bump into a wall.");
                }
                return playerPos;
            case 'w':
                if((playerPos - 1) > -1) {// check invalid movement
                    if (map[(playerPos - 1)] == '0') { // check invalid movement
                        if (questions.shouldQuestionBeAsked()) {
                            if (questions.isPlayerAnswerCorrect()) { // correct answer
                                playerPos = movePlayerScript(playerPos, "west");
                            } else { // incorrect answer
                                System.out.println("The guardian is unsatisfied with your answer and injures you before leaving.");
                                lives.setLivesRemaining(lives.getLivesRemaining() - 1);
                            }
                        }else { // no question
                            playerPos = movePlayerScript(playerPos, "west");
                        }
                    } else {
                        System.out.println("You bump into a wall.");
                    }
                }
                else {
                    System.out.println("You bump into a wall.");
                }
                return playerPos;
            default:
                System.out.println("Default Error");
                return playerPos;
        }
        return playerPos;
    }

    private int movePlayerScript(int playerPos, String direction) {
        System.out.println("You move " + direction + '.');
        Main.sound.PlaySound(Main.sound.footsteps);
        switch (direction){
            case "west":
                playerPos += -1;
                break;
            case "east":
                playerPos += 1;
                break;
            case "north":
                playerPos += -width;
                break;
            case "south":
                playerPos += width;
                break;
            default:
                break;
        }

        return playerPos;
    }

    public void loadMap(String fileName){
        File file = new File(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {

        }
        StringBuilder sb = new StringBuilder();
        int tempWid = 0;
        for (int i = 0; scan.hasNext(); i++) {
            sb.append(scan.next()+ '\n');
            height++;
        }
        map = sb.toString().toCharArray();
        for (int i = 0; map[i]!= '\n' ; i++) {
            width++;
        }width++;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '3'){
                winPosition = i;
            }
        }
    }
    public char[] getMap(){
        return map;
    }

    public void lookAround(int playerPos) {
        if ((playerPos - width) > -1) {
            if (map[playerPos - width] == '0') {
                System.out.println("To the north is an opening.");
            }
        }if((playerPos - 1) > -1){
            if(map[playerPos - 1] == '0'){
                System.out.println("To the west is an opening.");
            }
        }
        if((playerPos+width) < map.length){
            if(map[playerPos + width] == '0'){
                System.out.println("To the south is an opening.");
            }
        }
        if((playerPos + 1) < map.length){
            if(map[playerPos + 1] =='3') {
                System.out.println("The exit is to your east!");
            }
            if(map[playerPos + 1] == '0') {
                System.out.println("To the east is an opening.");
            }
        }
    }
}