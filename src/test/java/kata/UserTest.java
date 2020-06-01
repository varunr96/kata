package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void testUserCreation() {
        User testUser = new User("Alice");
        assertEquals("Alice", testUser.getFirstName());
        assertEquals(0, testUser.viewTimelineMessages().size());
    }

    @Test
    void testUserPublishedMessageToTimeline() {
        User testUser = new User("Alice");
        Message testMessage = new Message("I love the weather today.");
        testUser.publishMessageToTimeline(testMessage);
        assertEquals("I love the weather today.", testUser.viewTimelineMessages().get(0).getMessageText());
    }

    @Test
    void testViewTimelineInCorrectOrder() {
        User testUser = new User("Alice");
        Message testMessage1 = new Message("I love the weather today.");
        Message testMessage2 = new Message("It might rain tomorrow.");
        testUser.publishMessageToTimeline(testMessage1);
        testUser.publishMessageToTimeline(testMessage2);
        assertEquals("It might rain tomorrow.", testUser.viewTimelineMessages().get(0).getMessageText());
        assertEquals("I love the weather today.", testUser.viewTimelineMessages().get(1).getMessageText());
    }

    @Test
    void testFollowUser() {
        User charlie = new User("Charlie");
        User alice = new User("Alice");

        Message testAliceMessage = new Message("I love the weather today.");
        Message testCharlieMessage = new Message("I'm in New York today! Anyone wants to have a coffee?");
        alice.publishMessageToTimeline(testAliceMessage);
        charlie.publishMessageToTimeline(testCharlieMessage);

        alice.addFollower(charlie);
        assertEquals("Charlie", alice.getFollowers().get(0).getFirstName());
        assertEquals("Alice", charlie.getUsersFollowed().get(0).getFirstName());
    }

    @Test
    void testFollowSingleUserShowsMessagesInWall() {
        User charlie = new User("Charlie");
        User alice = new User("Alice");

        Message testAliceMessage = new Message("I love the weather today.");
        alice.publishMessageToTimeline(testAliceMessage);

        alice.addFollower(charlie);

        assertEquals("I love the weather today.", charlie.viewWall().get(0).getMessageText());
        assertEquals("Alice", charlie.viewWall().get(0).getSender().getFirstName());
    }

    @Test
    void testFollowMultipleUsersShowsMessagesInWall() {
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        User alice = new User("Alice");

        Message testAliceMessage = new Message("I love the weather today.");
        Message testBobMessage1 = new Message("Darn! We lost!");
        Message testBobMessage2 = new Message("Good game though.");
        Message testCharlieMessage = new Message("I'm in New York today! Anyone wants to have a coffee?");

        try {
            alice.publishMessageToTimeline(testAliceMessage);
            Thread.sleep(100);

            bob.publishMessageToTimeline(testBobMessage1);
            Thread.sleep(100);

            bob.publishMessageToTimeline(testBobMessage2);
            Thread.sleep(100);

            charlie.publishMessageToTimeline(testCharlieMessage);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        alice.addFollower(charlie);
        bob.addFollower(charlie);

        assertEquals("Charlie", charlie.viewWall().get(0).getSender().getFirstName());
        assertEquals("I'm in New York today! Anyone wants to have a coffee?", charlie.viewWall().get(0).getMessageText());
    }
}
