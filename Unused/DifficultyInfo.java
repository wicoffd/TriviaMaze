/*
 * TCSS 360 - Sphinx Riddle Maze
 */

package Unused;

/**
 * An interface for dificulty info.
 * 
 * @author Ben Valdebenito
 * @version Winter 2022
 */
public final class DifficultyInfo {


    final private String myLevelDifficulty;
    final private int myStartingLives;
    final private double myDoorPercentage;

	/**
	* Constructor that creates a door. 
	* @author Ben Valdebenito
	* @version Winter 2022
	*/
    public DifficultyInfo(String theLeveleDifficulty) {

        myLevelDifficulty = theLeveleDifficulty;

        if (myLevelDifficulty.equals("Easy")) {
            myStartingLives = 3;
            myDoorPercentage = .1;
        } else if (myLevelDifficulty.equals("Medium")) {
            myStartingLives = 2;
            myDoorPercentage = .2;
        } else {
            myStartingLives = 1;
            myDoorPercentage = .4;
        }
    }

    /**
     * Returns the dificulty level.
     * 
     * @return the dificulty level.
     */
    public String getLevelDifficulty() {
        return myLevelDifficulty;
    }

    /**
     * Returns the total amount of starting lives.
     * 
     * @return the amount of lives to start with.
     */
    public int getStartingLives() {
        return myStartingLives;
    }

    /**
     * Returns the percentage of doors to be seen.
     * 
     * @return the percentage.
     */
    public double getDoorPercentage() {
        return myDoorPercentage;
    }

}
