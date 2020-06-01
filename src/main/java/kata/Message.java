package kata;

import java.sql.Timestamp;

public class Message implements Comparable<Message> {
    private String messageText;
    private Timestamp timePublished;
    private long timeSincePublished;
    private User sender;

    public Message (String messageText) {
        this.messageText = messageText;
    }

    public Timestamp getTimePublished() {
        return this.timePublished;
    }

    public void setTimePublished(Timestamp timePublished){
        this.timePublished = timePublished;
    }

    public String getMessageText() {
        return this.messageText;
    }


    public User getSender() {
        return sender;
    }
    public void setSender(User user) {
        this.sender = user;
    }
    public long getTimeSincePublished() {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        timeSincePublished = current.getTime() - this.timePublished.getTime();
        return timeSincePublished;
    }

    public int compareTo(Message message) {
        return getTimePublished().compareTo(message.getTimePublished());
    }

}
