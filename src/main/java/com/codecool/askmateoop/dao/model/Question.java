package com.codecool.askmateoop.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Question(int id, String title, String description, LocalDateTime publicationDate) {
}
