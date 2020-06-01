package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimelineTest {
    User testUser = new User("Alice");

    @Test
    void testTimelineCreationAssociatedWithCorrectUser() {
        Timeline testTimeline = new Timeline(testUser);
        assertEquals("Alice", testTimeline.getUser().getFirstName());
    }

    @Test
    void testPublishMessageToTimeline() {
        Timeline testTimeline = new Timeline(testUser);
        Message testMessage = new Message("I love the weather today.");
        testTimeline.publishMessage(testMessage, testUser);
        assertEquals("Alice", testTimeline.getMessages().get(0).getSender().getFirstName());
        assertEquals("I love the weather today.", testTimeline.getMessages().get(0).getMessageText());
    }
}
