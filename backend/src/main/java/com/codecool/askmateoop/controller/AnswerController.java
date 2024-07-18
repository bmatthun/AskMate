package com.codecool.askmateoop.controller;

import com.codecool.askmateoop.controller.dto.AnswerDTO;
import com.codecool.askmateoop.controller.dto.NewQuestionDTO;
import com.codecool.askmateoop.controller.dto.QuestionDTO;
import com.codecool.askmateoop.service.AnswerService;
import com.codecool.askmateoop.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//    @PostMapping("/")
//    public int addNewQuestion(@RequestBody NewQuestionDTO question) {
//        return questionService.addNewQuestion(question);
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean deleteQuestionById(@PathVariable int id) {
//        return questionService.deleteQuestionById(id);
//    }
}
