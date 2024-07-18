package com.codecool.askmateoop.controller.dto;

//DTO lehet record!!
public class NewAnswerDTO {
    private int userId;
    private int questionId;
    private String description;

    public NewAnswerDTO(String description, int userId, int questionId) {
        this.userId = userId;
        this.questionId = questionId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
