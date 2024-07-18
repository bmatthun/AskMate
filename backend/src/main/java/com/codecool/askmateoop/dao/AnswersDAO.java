package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.Answer;

import java.util.List;

public interface AnswersDAO {
    List<Answer> getAllAnswersByQuestionId(int questionId);

//    Question getQuestionById(int id);
//
//    int createQuestion(Question question);
//
//    boolean deleteQuestionById(int id);
}
