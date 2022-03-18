package View;

import Model.*;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static SoundEffects sound = new SoundEffects();
    public static void main(String[] args) {
        boolean running = true;
        String fileName = "src/Model/map.txt";
        GetPlayerSurrounding getPlayerSurrounding = new GetPlayerSurrounding();
        MapInfo mapInfo = new MapInfo();
        StringBuilder input = new StringBuilder();
        int playerPos = 1;
        /** Get map data from file*/
        getPlayerSurrounding.loadMap(fileName);
        System.out.println(mapInfo.getInfoPrompt());
        // View.Main loop
        while(running) {
            /** Take user input*/
            if(!getPlayerSurrounding.lives.getIsAlive()) {
                System.out.println("You died alone in the dark");
                running = false;
                break; // fixes a glitch that allows the player to attempt to move again after death message
            }
            input.delete(0,input.length());
            System.out.print("User input: ");
            input.append(scan.nextLine());
            if(playerPos == getPlayerSurrounding.winPosition){ running = false;}
            switch (input.toString().toLowerCase()) {

                case "n":
                case "north":
                    playerPos = getPlayerSurrounding.movePlayer('n', playerPos);
                    break;
                case "south":
                case "s":
                    playerPos = getPlayerSurrounding.movePlayer('s', playerPos);
                    break;
                case "e":
                case "east":
                    playerPos = getPlayerSurrounding.movePlayer('e', playerPos);
                    break;
                case "w":
                case "west":
                    playerPos = getPlayerSurrounding.movePlayer('w', playerPos);
                    break;
                case "look":
                case "l":
                case "look around":
                    getPlayerSurrounding.lookAround(playerPos);
                    break;
                case "help":
                case "h":
                    System.out.println(mapInfo.getInfoPrompt());
                    break;
                case "menu":
                case "m":
                    System.out.println(mapInfo.getMenuPrompt());
                    break;
                case "exit":
                    System.out.println("Run coward! You flee the maze never to return.");
                    sound.PlaySound(sound.runAway);
                    running = false;
                    break;
                case "cheats":
                    System.out.println(mapInfo.getCheatPrompt());
                    break;
                case "do the time warp":
                    playerPos = (getPlayerSurrounding.getMap().length -3);
                    break;
                case "no more questions please":
                    getPlayerSurrounding.questions.setDifficulty(3+05); // the random number cannot be higher than 100.
                    break;
                default:
                    break;

            }
        }
    }

}