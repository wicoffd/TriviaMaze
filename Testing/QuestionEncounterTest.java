package Testing;

import Model.QuestionEncounter;
import static org.junit.Assert.*;
import org.junit.Test;

class QuestionEncounterTest {

    @Test
    public void shouldQuestionBeAsked() {
        final QuestionEncounter question = new QuestionEncounter();
        question.setDifficulty(300);
        for (int i = 0; i < 30; i++) {
                assertFalse(question.shouldQuestionBeAsked());
            }
    }
    @Test
    public void setDifficulty() {
        final QuestionEncounter question = new QuestionEncounter();
        question.setDifficulty(50);
        assertEquals("Difficulty should be 50",50, question.getDifficulty());
        question.setDifficulty(300);
        assertEquals("Difficulty should be 300",300,question.getDifficulty());
    }
}