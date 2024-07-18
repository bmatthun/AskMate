package com.codecool.askmateoop.controller.dto;

import java.time.LocalDateTime;

public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private LocalDateTime created;

    public QuestionDTO(int id, String title, String description, LocalDateTime created) {
        this.title = title;
        this.description = description;
        this.created = created;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }
}
