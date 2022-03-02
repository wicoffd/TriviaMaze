package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.RiddleInfo;



public class RiddleInfoTest {

    /**
	* Test to see if constructor is set up correctly
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoConstructor() {
        final RiddleInfo test1 = new RiddleInfo(1, "I'm a fruit, a bird, and also a person. What am i?");

        String expected = "I'm a fruit, a bird, and also a person. What am i?";


        assertEquals("Riddle id is not correct!", 1, test1.getRiddleId());
        assertEquals("The riddle isnt the correct one!", expected, test1.getRiddle());

    }


    /**
	* Test to see if isAnswered returns true
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoSetIsAnswerdTrue() {
        final RiddleInfo test1 = new RiddleInfo(1, "I'm a fruit, a bird, and also a person. What am i?");

        test1.setIsAnswered(true);

        assertTrue("The riddleSetIsAnswered should be true!",test1.getIsAnswered());

    }
      
    

    /**
	* Test to see if isAnswered returns false
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoSetIsAnswerdFalse() {
        final RiddleInfo test1 = new RiddleInfo(1, "I'm a fruit, a bird, and also a person. What am i?");

        assertFalse("The riddleSetIsAnswered should be false!",test1.getIsAnswered());

    }

}