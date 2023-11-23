package io.github.azizndao.vieterrestre.models;

import jakarta.persistence.*;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    private String description;

    private float latitude;

    private float longitude;

    @ManyToOne
    private User author;

    public Alert() {
    }

    public int getId() {
        return id;
    }

    public Alert setId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Alert setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Alert setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public Alert setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public Alert setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Alert setAuthor(User author) {
        this.author = author;
        return this;
    }
}
