/*
 * TCSS 360 - Sphinx Riddle Maze
 */

package Unused;



/**
 * An interface for Users
 * 
 * @author Ben Valdebenito
 * @version Winter 2022 */
public final class UserInfo {

	final private int myUserId;


	/**
	* Constructor that creates a User. 
	* @author Ben Valdebenito
	* @version Winter 2022
	*/
    public UserInfo(int theUserId) {
        myUserId = theUserId;
    }



    /**
     * Returns the current users Id.
     * 
     * @return the user id.
     */
    public int getUserId() {
        return myUserId;
    }

}
