/*
 * TCSS 360 - Sphinx Riddle Maze
 */

package Model;



/**
 * An interface for riddle info.
 * 
 * @author Ben Valdebenito
 * @version Winter 2022
 */
public final class RiddleInfo {

    final private int myRiddleId;
    final private String myRiddle;
    private boolean myIsAnswered;

	/**
	* Constructor that creates a door. 
	* @author Ben Valdebenito
	* @version Winter 2022
	*/
    public RiddleInfo(int theRiddleId, String theRiddle) {
        myRiddleId = theRiddleId;
        myRiddle = theRiddle;
        myIsAnswered = false;
    }

    /**
     * Returns this riddle object's id.
     * 
     * @return the id.
     */
    public int getRiddleId() {
        return myRiddleId;
    }

    /**
     * Returns this riddle object's text/string.
     * 
     * @return the riddle.
     */
    public String getRiddle() {
        return myRiddle;
    }

    /**
     * Returns this Riddle object's answer to if its been asked or not.
     * 
     * @return if its been asked or not.
     */
    public boolean getIsAnswered() {
        return myIsAnswered;
    }

    /**
     * Sets this object's isAnswered to the given value.
     * 
     * @param theIsAnswered The new answer to if the question has been seen.
     */
    public void setIsAnswered(Boolean theIsAnswered) {
        myIsAnswered = theIsAnswered;
    }

}
