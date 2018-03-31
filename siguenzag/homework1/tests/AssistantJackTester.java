import Siguenza_Gabriel_HW1.AssistantJack;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

// You can also omit this statement if you create a new package with the same name
// as the directory that contains the file you want to test

public class AssistantJackTester {

    @Test
    public void testCheckAnswerIntIntInt() {
        AssistantJack aj = new AssistantJack(1);
        assertTrue(aj.checkAnswer(1, 1, 1) == 0);
    }

    @Test
    public void testCheckAnswer2() {
        AssistantJack aj = new AssistantJack(2);
        assertTrue(aj.checkAnswer(6,10,6) == 0);
    }

}