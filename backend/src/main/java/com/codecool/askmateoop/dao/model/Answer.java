package com.codecool.askmateoop.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Answer {

    private int id;
    private int question_id;
    private int user_id;
    private String description;
    private LocalDateTime publishing_date;

    public Answer(int id, int question_id, int user_id, String description, LocalDateTime publishing_date) {
        this.id = id;
        this.question_id = question_id;
        this.user_id = user_id;
        this.description = description;
        this.publishing_date = publishing_date;
    }

    public Answer(String description) {
        this.description = description;
    }

    public Answer(String description, LocalDateTime publishing_date) {
        this.description = description;
        this.publishing_date = publishing_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(LocalDateTime publishing_date) {
        this.publishing_date = publishing_date;
    }
}
