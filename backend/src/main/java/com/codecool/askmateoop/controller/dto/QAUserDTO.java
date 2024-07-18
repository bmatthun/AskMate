package com.codecool.askmateoop.controller.dto;

import java.time.LocalDateTime;

public class QAUserDTO {
    private int id;
    private String name;
    private LocalDateTime registrationDate;

    public QAUserDTO(int id, String name, LocalDateTime registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }
}
