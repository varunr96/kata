package kata;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Timeline {
    private List<Message> messageList;
    private User user;

    public Timeline(User user) {
        this.user = user;
        this.messageList = new ArrayList<>();
    }

    public User getUser(){
        return this.user;
    }
    public List<Message> getMessages() {
        return messageList;
    }

    public void publishMessage(Message message, User user) {
        message.setSender(user);
        message.setTimePublished(new Timestamp(System.currentTimeMillis()));
        messageList.add(0, message);
    }
}
