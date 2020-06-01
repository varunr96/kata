package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageTest {
    @Test
    void testMessageCreation() {
        Message testMessage = new Message("I love the weather today.");
        assertEquals("I love the weather today.", testMessage.getMessageText());
    }
}
