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
        List<Message> wallMessages = timeline.getMessages();
        for (int i = 0; i < usersFollowed.size(); i++) {
            for (int j = 0; j < usersFollowed.get(i).viewTimelineMessages().size(); j++) {
                wallMessages.add(usersFollowed.get(i).viewTimelineMessages().get(j));
            }
        }

        Collections.sort(wallMessages);
        Collections.reverse(wallMessages);

        return wallMessages;

    }
}
