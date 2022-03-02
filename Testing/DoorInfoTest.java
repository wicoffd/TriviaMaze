package Testing;


import static org.junit.Assert.*;

import org.junit.Test;

import Model.DoorInfo;



public class DoorInfoTest {

    /**
	* Test to see if constructor is set up correctly
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoConstructor() {
        final DoorInfo test1 = new DoorInfo(12234);
        assertEquals("Door Info ID not initialized correctly!", 12234, test1.getDoorId());
    }
        
}