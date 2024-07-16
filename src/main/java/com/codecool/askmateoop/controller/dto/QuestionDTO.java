package com.codecool.askmateoop.controller.dto;

import java.time.LocalDateTime;

public class QuestionDTO {
    private String title;
    private String description;
    private LocalDateTime created;

    public QuestionDTO(String title, String description, LocalDateTime created) {
        this.title = title;
        this.description = description;
        this.created = created;
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
}
