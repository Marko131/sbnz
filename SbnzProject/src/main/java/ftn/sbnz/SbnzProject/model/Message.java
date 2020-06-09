package ftn.sbnz.SbnzProject.model;


import java.util.Date;
import java.util.Objects;

public class Message {

    private String text;
    private Date timestamp;

    public Message() {
        this.timestamp = new Date();
    }

    public Message(String text) {
        this.text = text;
        this.timestamp = new Date();
    }

    public Message(String text, Date timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return timestamp.equals(message.timestamp) && text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp);
    }
}
