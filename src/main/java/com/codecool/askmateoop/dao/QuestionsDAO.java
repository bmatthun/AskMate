package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    List<Question> getAllQuestions();

    Question getQuestionById(int id);

    int createQuestion(Question question);

    boolean deleteQuestionById(int id);
}
