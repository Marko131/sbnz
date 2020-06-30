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

    @Column
    @ElementCollection(targetClass=String.class)
    public List<String> text;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Notification() {
        this.date = new Date();
        this.text = new ArrayList<>();
    }

    public Notification(ArrayList<String> text) {
        this.text = text;
        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return date;
    }

    public void setTimestamp(Date date) {
        this.date = date;
    }

    public void addToList(String t){
        this.text.add(t);
    }
}
