/*
 * TCSS 360 - Sphinx Riddle Maze
 */

package Model;



/**
 * An interface for live info.
 * 
 * @author Ben Valdebenito
 * @version Winter 2022 */
public final class LiveInfo {
    
    private int myLives;
    /**
	* Constructor that creates info on players lives. Lives determined by dificulty
	* @author Ben Valdebenito
	* @version Winter 2022
	*/
    public LiveInfo(int theLives) {
        myLives = theLives;
    }
    
    
    /**
     * Returns true or false depending on if lives remain.
     * 
     * @return the value if its alive or not.
     */
    public boolean getIsAlive() {

        return myLives > 0;
    }

    /**
     * Returns this User object's lives remaining.
     * 
     * @return the total amount of lives remaining.
     */
    public int getLivesRemaining() {
        return myLives;
    }

    /**
     * Sets this object's number of lives to the given value.
     * 
     * @param theLiveNum The amount of licves left.
     */
    public void setLivesRemaining(int theLiveNum) {
        // Calling method will need to get the current lives and add or subtarct to this before passing that value here to change
        myLives = theLiveNum;
    }
}
