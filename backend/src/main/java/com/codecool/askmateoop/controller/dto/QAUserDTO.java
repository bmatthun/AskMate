package com.codecool.askmateoop.controller.dto;

import java.time.LocalDateTime;

public class QAUserDTO {
    private String name;
    private LocalDateTime registrationDate;

    public QAUserDTO(String name, LocalDateTime registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
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
}
