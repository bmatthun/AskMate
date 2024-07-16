package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.Question;
import com.codecool.askmateoop.dao.model.database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
