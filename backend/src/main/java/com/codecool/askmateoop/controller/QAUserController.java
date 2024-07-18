package com.codecool.askmateoop.controller;

import com.codecool.askmateoop.controller.dto.NewQAUserDTO;
import com.codecool.askmateoop.controller.dto.QAUserDTO;
import com.codecool.askmateoop.service.QAUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class QAUserController {

    private final QAUserService qAUserService;

    @Autowired
    public QAUserController(QAUserService qAUserService) {
        this.qAUserService = qAUserService;
    }

    @GetMapping("/all")
    public List<QAUserDTO> getAllQAUsers() {
        return qAUserService.getAllQAUsers();
    }

    @GetMapping("/id/{id}")
    public QAUserDTO getQAUserById(@PathVariable int id) {
        return qAUserService.getQAUserById(id);
    }

    @GetMapping("/name/{name}")
    public QAUserDTO getQAUserByUsername(@PathVariable String name) {
        return qAUserService.getQAUserByName(name);
    }


    @PostMapping("/create")
    public int addNewQAUser(@RequestBody NewQAUserDTO newQAUserDTO) {
        return qAUserService.addNewQAUser(newQAUserDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteQAUserById(@PathVariable int id) {
        return qAUserService.deleteQAUserById(id);
    }
}
