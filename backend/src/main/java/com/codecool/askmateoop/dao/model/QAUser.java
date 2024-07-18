package com.codecool.askmateoop.dao.model;

import java.time.LocalDateTime;

public class QAUser {

    private int id;
    private String userName;
    private LocalDateTime registrationTime;

    public QAUser(int id, String userName, LocalDateTime registrationTime) {
        this.id = id;
        this.userName = userName;
        this.registrationTime = registrationTime;
    }

    public QAUser(String userName, LocalDateTime registrationTime) {
        this.userName = userName;
        this.registrationTime = registrationTime;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
