package com.codecool.askmateoop.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Question {

    private int id;
    private String title;
    private String description;
    private LocalDateTime publicationDate;

    public Question(int id, String title, String description, LocalDateTime publicationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    public Question(String title, String description, LocalDateTime publicationDate) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}
