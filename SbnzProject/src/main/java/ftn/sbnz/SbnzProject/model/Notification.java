package ftn.sbnz.SbnzProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @Column
    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    public List<String> text;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Notification(){
        this.date = new Date();
        this.text = new ArrayList<>();
    }

    public Notification(User user) {
        this.date = new Date();
        this.text = new ArrayList<>();
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    public void addToList(String t){
        this.text.add(t);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", user=" + user +
                ", text=" + text +
                ", date=" + date +
                '}';
    }
}
