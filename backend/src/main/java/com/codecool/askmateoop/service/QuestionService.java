package com.codecool.askmateoop.service;

import com.codecool.askmateoop.controller.dto.NewQuestionDTO;
import com.codecool.askmateoop.controller.dto.QuestionDTO;
import com.codecool.askmateoop.dao.QuestionsDAO;
import com.codecool.askmateoop.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    private QuestionDTO parseQuestionToQuestionDTO(Question question) {
        return new QuestionDTO(question.getId(), question.getTitle(), question.getDescription(), question.getPublicationDate());
    }

    private Question parseNewQuestionDTOtoQuestion(NewQuestionDTO newQuestionDTO) {
        return new Question(newQuestionDTO.getTitle(), newQuestionDTO.getDescription(), LocalDateTime.now());
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> allQuestions = questionsDAO.getAllQuestions();
        return allQuestions.stream()
                .map(question -> parseQuestionToQuestionDTO(question))
                .toList();
    }

    public QuestionDTO getQuestionById(int id) {
        Question question = questionsDAO.getQuestionById(id);
        return parseQuestionToQuestionDTO(question);
    }


    public boolean deleteQuestionById(int id) {
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO newQuestionDTO) {
        Question question = parseNewQuestionDTOtoQuestion(newQuestionDTO);
        return questionsDAO.createQuestion(question);
    }
}
