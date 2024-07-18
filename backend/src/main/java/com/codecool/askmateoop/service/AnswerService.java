package com.codecool.askmateoop.service;

import com.codecool.askmateoop.controller.dto.AnswerDTO;
import com.codecool.askmateoop.dao.AnswersDAO;
import com.codecool.askmateoop.dao.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswersDAO answersDAO;

    @Autowired
    public AnswerService(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }

    private AnswerDTO parseAnswerToAnswerDTO(Answer answer) {
        return new AnswerDTO(answer.getDescription());
    }

    public List<AnswerDTO> getAllAnswersByQuestionId(int questionId) {
        List<Answer> allAnswersUnderQuestion = answersDAO.getAllAnswersByQuestionId(questionId);
        List<AnswerDTO> answerDTO = allAnswersUnderQuestion.stream()
                .map(this::parseAnswerToAnswerDTO)
                .toList();
        return answerDTO;
    }

}
