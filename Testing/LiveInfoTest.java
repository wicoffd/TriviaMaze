package Testing;


import static org.junit.Assert.*;

import org.junit.Test;

import Model.LiveInfo;



public class LiveInfoTest {

    /**
	* Test to see if constructor is set up correctly
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void LiveInfoConstructor() {
        final LiveInfo test1 = new LiveInfo(2);

        assertEquals("User live count wasnt initialized correctly!", 2, test1.getLivesRemaining());
    }

    /**
	* Test to see if setLives is subtarcting lives currectly
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void LiveInfoGetLivesSubtract() {
        final LiveInfo test1 = new LiveInfo(3);
        int currentLives = test1.getLivesRemaining();
        
        test1.setLivesRemaining(currentLives - 1);

        assertEquals("User live count wasnt adjusted correctly!", 2, test1.getLivesRemaining());
    }

    /**
	* Test to see if setLives is adding lives currectly
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void LiveInfoGetLivesAdd() {
        final LiveInfo test1 = new LiveInfo(3);
        int currentLives = test1.getLivesRemaining();
        
        test1.setLivesRemaining(currentLives + 1);

        assertEquals("User live count wasnt adjusted correctly!", 4, test1.getLivesRemaining());
    }


    /**
	* Test to see if isAlive returns true
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void LiveInfoIsAliveTrue() {
        final LiveInfo test1 = new LiveInfo(3);
        
        assertTrue("User should be alive!", test1.getIsAlive());
    }

        /**
	* Test to see if isAlive returns false
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void LiveInfoIsAliveFalse() {
        final LiveInfo test1 = new LiveInfo(3);
        
        test1.setLivesRemaining(0);

        assertFalse("User should have no lives left!", test1.getIsAlive());
    }
        
}
