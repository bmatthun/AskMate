package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.QAUser;
import com.codecool.askmateoop.dao.model.Question;

import java.util.List;

public interface QAUsersDAO {

    List<QAUser> getAllQAUsers();

    QAUser getQAUserById(int id);

    QAUser getQAUserByName(String userName);

    int createQAUser(QAUser qaUser);

    boolean deleteUserById(int id);
}
