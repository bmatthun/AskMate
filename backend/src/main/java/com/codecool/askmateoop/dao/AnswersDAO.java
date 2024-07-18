package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.Answer;

import java.sql.SQLException;
import java.util.List;

public interface AnswersDAO {
    List<Answer> getAllAnswersByQuestionId(int questionId);

//    Question getQuestionById(int id);
//
    int createAnswer(Answer answer, int questionId, int userId) throws SQLException;
//
//    boolean deleteQuestionById(int id);
}
