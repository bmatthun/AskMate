package com.codecool.askmateoop.controller.dto;

public class NewQuestionDTO {
    private String title;
    private String description;

    public NewQuestionDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
