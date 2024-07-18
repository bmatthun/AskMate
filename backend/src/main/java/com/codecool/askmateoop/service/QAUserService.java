package com.codecool.askmateoop.service;

import com.codecool.askmateoop.controller.dto.NewQAUserDTO;
import com.codecool.askmateoop.controller.dto.QAUserDTO;
import com.codecool.askmateoop.dao.QAUsersDAO;
import com.codecool.askmateoop.dao.model.QAUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QAUserService {

    private final QAUsersDAO qaUsersDAO;

    @Autowired
    public QAUserService(QAUsersDAO qaUsersDAO) {
        this.qaUsersDAO = qaUsersDAO;
    }

    private QAUserDTO parseQAUserToQAUserDTO(QAUser qaUser) {
        return new QAUserDTO(qaUser.getUserName(), qaUser.getRegistrationTime());
    }

    private QAUser parseNewQAUserDTOToQAUser(NewQAUserDTO newQAUserDTO) {
        return new QAUser(newQAUserDTO.userName(), LocalDateTime.now());
    }

    public List<QAUserDTO> getAllQAUsers() {
        List<QAUser> allQAUsers = qaUsersDAO.getAllQAUsers();
        return allQAUsers.stream()
                .map(qaUser -> parseQAUserToQAUserDTO(qaUser))
                .toList();
    }

    public QAUserDTO getQAUserById(int id) {
        QAUser qaUser = qaUsersDAO.getQAUserById(id);
        return parseQAUserToQAUserDTO(qaUser);
    }

    public QAUserDTO getQAUserByName(String name) {
        QAUser qaUser = qaUsersDAO.getQAUserByName(name);
        return parseQAUserToQAUserDTO(qaUser);
    }

    public boolean deleteQAUserById(int id) {
        return qaUsersDAO.deleteUserById(id);
    }

    public int addNewQAUser(NewQAUserDTO newQAUserDTO) {
        QAUser qaUser = parseNewQAUserDTOToQAUser(newQAUserDTO);
        return qaUsersDAO.createQAUser(qaUser);
    }
}
