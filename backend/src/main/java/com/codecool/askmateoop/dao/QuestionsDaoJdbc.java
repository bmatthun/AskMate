package com.codecool.askmateoop.dao;

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
public class QuestionsDaoJdbc implements QuestionsDAO {

    private DatabaseConnection databaseConnection;

    @Autowired
    public QuestionsDaoJdbc(DatabaseConnection connection) {
        this.databaseConnection = connection;
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT id, title, description, published_date FROM question;";
        try (Connection conn = databaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDateTime publicationDate = rs.getTimestamp("published_date").toLocalDateTime();
                Question question = new Question(id, title, description, publicationDate);
                questions.add(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    @Override
    public Question getQuestionById(int questionId) {
        String sql = "SELECT id, title, description, published_date FROM question where id = ?;";
        try (Connection conn = databaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
        ) {
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDateTime publishedDate = resultSet.getTimestamp("published_date").toLocalDateTime();
                return new Question(id, title, description, publishedDate);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int createQuestion(Question question) {
        String sql = "INSERT INTO question(title, description, published_date) VALUES (?,?,?);";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, question.getTitle());
            statement.setString(2, question.getDescription());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating question failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteQuestionById(int id) {
        String deleteAnswersSql = "DELETE FROM answer WHERE question_id = ?;";
        String deleteQuestionSql = "DELETE FROM question WHERE id = ?;";

        try (Connection conn = databaseConnection.getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement deleteAnswersStmt = conn.prepareStatement(deleteAnswersSql);
                 PreparedStatement deleteQuestionStmt = conn.prepareStatement(deleteQuestionSql)) {
                deleteAnswersStmt.setInt(1, id);
                deleteAnswersStmt.executeUpdate();

                deleteQuestionStmt.setInt(1, id);
                int rowsAffected = deleteQuestionStmt.executeUpdate();

                conn.commit();
                return rowsAffected > 0;

            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
