package net.javaguides.springboot.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_url")
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String originalURL;
    private String shortenedURL;
    private int clickCount;

    public URL() {
    }

    public URL(Long id, User user, String originalURL, String shortenedURL, int clickCount) {
        this.id = id;
        this.user = user;
        this.originalURL = originalURL;
        this.shortenedURL = shortenedURL;
        this.clickCount = clickCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getShortenedURL() {
        return shortenedURL;
    }

    public void setShortenedURL(String shortenedURL) {
        this.shortenedURL = shortenedURL;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "URL{" +
                "id=" + id +
                ", user=" + user +
                ", originalURL='" + originalURL + '\'' +
                ", shortenedURL='" + shortenedURL + '\'' +
                ", clickCount=" + clickCount +
                '}';
    }

    // Getters and setters
}
