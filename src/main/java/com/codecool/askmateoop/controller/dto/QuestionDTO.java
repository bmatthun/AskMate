package com.codecool.askmateoop.controller.dto;

import java.time.LocalDateTime;

public record QuestionDTO(String title, String description, LocalDateTime created) {}
