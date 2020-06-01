package kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String firstName;
    private Timeline timeline;
    private List<User> followers;
    private List<User> usersFollowed;

    public User(String firstName) {
        this.firstName = firstName;
        this.timeline = new Timeline(this);
        this.followers = new ArrayList<>();
        this.usersFollowed = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Message> viewTimelineMessages() {
        return timeline.getMessages();
    }

    public void publishMessageToTimeline(Message message) {
        timeline.publishMessage(message, this);
    }

    public void addFollower(User user) {
        followers.add(user);
        user.follow(this);
    }

    private void follow(User user) {
        this.usersFollowed.add(user);
    }

    public List<User> getFollowers() {
        return this.followers;
    }

    public List<User> getUsersFollowed() {
        return this.usersFollowed;
    }

    public List<Message> viewWall() {
        List<Message> wallMessages = new ArrayList<>();
        for (Message m : timeline.getMessages()) {
            wallMessages.add(m);
        }
        System.out.println("WallMessages before add followers messages: ");
        for (Message m : wallMessages) {
            System.out.println(m.getMessageText());
        }
        for (User u : usersFollowed) {
            for (Message m :  u.viewTimelineMessages()) {
                wallMessages.add(m);
            }
        }

        Collections.sort(wallMessages);
        Collections.reverse(wallMessages);

        System.out.println("WallMessages after add followers messages: ");
        for (Message m : wallMessages) {
            System.out.println(m.getMessageText());
        }

        return wallMessages;

    }
}
