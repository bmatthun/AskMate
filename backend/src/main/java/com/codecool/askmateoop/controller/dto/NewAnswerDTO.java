package com.codecool.askmateoop.controller.dto;

public class NewAnswerDTO {
//    private int user_id;
//    private int question_id;
    private String description;

    public NewAnswerDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
