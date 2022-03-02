package Testing;


import static org.junit.Assert.*;

import org.junit.Test;

import Model.DifficultyInfo;



public class DifficultyInfoTest {

    /**
	* Test to see if constructor is set up correctly for easy mode
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoConstructorEasy() {
        final DifficultyInfo test1 = new DifficultyInfo("Easy");
        assertEquals("Difficulty level is not correct!", "Easy", test1.getLevelDifficulty());
        assertEquals("Difficulty Level starting lives isnt correct!", 3, test1.getStartingLives());
        assertEquals("Difficulty Level door percentage isnt correct!", .1, test1.getDoorPercentage(), 0);
    }

        /**
	* Test to see if constructor is set up correctly for medium mode
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoConstructorMedium() {
        final DifficultyInfo test1 = new DifficultyInfo("Medium");
        assertEquals("Difficulty level is not correct!", "Medium", test1.getLevelDifficulty());
        assertEquals("Difficulty Level starting lives isnt correct!", 2, test1.getStartingLives());
        assertEquals("Difficulty Level door percentage isnt correct!", .2, test1.getDoorPercentage(), 0);
    }

        /**
	* Test to see if constructor is set up correctly for easy mode
	* @author Ben Valdebenito
	* @version Winter 2022
	*/    
    @Test
    public void UserInfoConstructorHard() {
        final DifficultyInfo test1 = new DifficultyInfo("Hard");
        assertEquals("Difficulty level is not correct!", "Hard", test1.getLevelDifficulty());
        assertEquals("Difficulty Level starting lives isnt correct!", 1, test1.getStartingLives());
        assertEquals("Difficulty Level door percentage isnt correct!", .4, test1.getDoorPercentage(), 0);
    }
        
}