package Model;

public class MapInfo {
    public String getInfoPrompt(){
        return("Movement is done via cardinal directions (n)orth, (e)ast, (s)outh and (w)est. \nPlayers may use the first letter or the full name. \nThe player may look around using look. \nUse help to display this message again. ");
    }

    public String getMenuPrompt() {
        return("Use (s)ave to save the game and (l)oad to load a game \nType (exit) to quit");
    }
}
