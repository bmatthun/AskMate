package com.codecool.askmateoop.controller;

import com.codecool.askmateoop.controller.dto.AnswerDTO;
import com.codecool.askmateoop.controller.dto.NewAnswerDTO;
import com.codecool.askmateoop.controller.dto.NewQuestionDTO;
import com.codecool.askmateoop.controller.dto.QuestionDTO;
import com.codecool.askmateoop.service.AnswerService;
import com.codecool.askmateoop.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/{questionId}")
    public List<AnswerDTO> getAllAnswersByQuestionId(@PathVariable int    questionId) {
        return answerService.getAllAnswersByQuestionId(questionId);
    }

//    @GetMapping("/{id}")
//    public QuestionDTO getQuestionById(@PathVariable int id) {
//        return questionService.getQuestionById(id);
//    }
//
    @PostMapping("/{userId}/{questionId}")
    public int addNewAnswerByUser(@PathVariable int questionId, @PathVariable int userId, @RequestBody NewAnswerDTO answer) throws SQLException {
        return answerService.addNewAnswer(answer, questionId, userId);
    }

    @DeleteMapping("/{userId}/{answerId}")
    public boolean deleteQuestionById(@PathVariable int userId, @PathVariable int answerId) {
        return answerService.deleteAnswerByAnswerIdAndUserId(userId, answerId);
    }
}
