/*
 * TCSS 360 - Sphinx Riddle Maze
 */

package Unused;



/**
 * An interface for door info.
 * 
 * @author Ben Valdebenito
 * @version Winter 2022 */
public final class DoorInfo {

    final private int myDoorId;

	/**
	* Constructor that creates a door. 
	* @author Ben Valdebenito
	* @version Winter 2022
	*/
    public DoorInfo(final int theDoorId) {
        myDoorId = theDoorId;
    }

    /**
     * Returns the id of the current door.
     * 
     * @return the door id.
     */
    public int getDoorId() {
        return myDoorId;
    }

}
