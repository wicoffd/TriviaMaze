package Testing;

import Model.QuestionEncounter;
import static org.junit.Assert.*;
import org.junit.Test;

class QuestionEncounterTest {
    QuestionEncounter question = new QuestionEncounter();
    @Test
    public void shouldQuestionBeAsked() {
        question.setDifficulty(300);
        for (int i = 0; i < 30; i++) {
                assertFalse(question.shouldQuestionBeAsked());
            }
        }
    }

    @Test
    public void setDifficulty() {

        question.setDifficulty(50);
        assertEquals(question.getDifficulty(), "50");
        question.setDifficulty(300);
        assertEquals(question.getDifficulty(),"300");
    }
}