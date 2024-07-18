package com.codecool.askmateoop.controller.dto;

import java.time.LocalDateTime;

public class AnswerDTO {
    private int question_id;
    private int user_id;
    private String description;

    public AnswerDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
