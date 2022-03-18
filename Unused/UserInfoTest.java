package Unused;


import static org.junit.Assert.*;

import org.junit.Test;


public class UserInfoTest {

    /**
	* Test to see if constructor is set up correctly
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoConstructor() {
        final UserInfo test1 = new UserInfo(1);
        assertEquals("User Info ID not initialized correctly!", 1, test1.getUserId());
    }
        
}
