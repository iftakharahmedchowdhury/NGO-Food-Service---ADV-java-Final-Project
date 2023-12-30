package dev.domain.Restaurant;


import javax.persistence.*;

@Entity
@Table(name ="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "FeedBackMSG")
    private String feedbackMessage;

    // Constructors, getters, and setters

    public Feedback() {
        // Default constructor
    }

    public Feedback(int id, int userId, String subject, String feedbackMessage) {
        this.id = id;
        this.userId = userId;
        this.subject = subject;
        this.feedbackMessage = feedbackMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }
}