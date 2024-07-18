package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.Answer;
import com.codecool.askmateoop.dao.model.Question;
import com.codecool.askmateoop.dao.model.database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswersDaoJdbc implements AnswersDAO {

    private DatabaseConnection databaseConnection;

    @Autowired
    public AnswersDaoJdbc(DatabaseConnection connection) {
        this.databaseConnection = connection;
    }

//    SELECT t1.*
//    FROM table1 t1
//    JOIN table2 t2 ON t1.id = t2.table1_id
//    WHERE t1.id = <specific_id>;

    //username, publishing_date is kell!!!
    @Override
    public List<Answer> getAllAnswersByQuestionId(int questionId) {
        String sql = "SELECT description FROM answer WHERE question_id = ?;";
        List<Answer> answers = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, questionId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Answer answer = new Answer(resultSet.getString("description"));
                    answers.add(answer);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving answers by question ID", e);
        }

        return answers;
    }

    @Override
    public int createAnswer(Answer answer, int questionId, int userId) throws SQLException {
        String sql = "INSERT INTO answer(question_id, user_id, description, publishing_date) VALUES (?, ?, ?, ?);";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, questionId);
            statement.setInt(2, userId);
            statement.setString(3, answer.getDescription());
            statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating answer failed, no ID obtained.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//
//    @Override
//    public int createQuestion(Question question) {
//        String sql = "INSERT INTO question(title, description, published_date) VALUES (?,?,?);";
//        try (Connection conn = databaseConnection.getConnection();
//             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
//        ) {
//            statement.setString(1, question.getTitle());
//            statement.setString(2, question.getDescription());
//            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//
//            statement.executeUpdate();
//
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    return generatedKeys.getInt(1);
//                } else {
//                    throw new SQLException("Creating question failed, no ID obtained.");
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    public boolean deleteQuestionById(int id) {
//        String sql = "DELETE FROM question WHERE id = ?;";
//        try (Connection conn = databaseConnection.getConnection();
//             PreparedStatement statement = conn.prepareStatement(sql)
//        ) {
//            statement.setInt(1, id);
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

