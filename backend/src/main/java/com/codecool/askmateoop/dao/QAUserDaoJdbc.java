package com.codecool.askmateoop.dao;

import com.codecool.askmateoop.dao.model.QAUser;
import com.codecool.askmateoop.dao.model.database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QAUserDaoJdbc implements QAUsersDAO {

    private DatabaseConnection databaseConnection;

    @Autowired
    public QAUserDaoJdbc(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<QAUser> getAllQAUsers() {
        List<QAUser> users = new ArrayList<>();
        String sql = "SELECT id, name, registration_date FROM qa_user;";

        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime registrationTime = resultSet.getTimestamp("registration_date").toLocalDateTime();
                QAUser qaUser = new QAUser(id, name, registrationTime);
                users.add(qaUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public QAUser getQAUserById(int userId) {
        String sql = "SELECT id, name, registration_date FROM qa_user where id = ?;";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime registrationTime = resultSet.getTimestamp("registration_date").toLocalDateTime();
                return new QAUser(id, name, registrationTime);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public QAUser getQAUserByName(String userName) {
        String sql = "SELECT id, name, registration_date FROM qa_user where name = ?;";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime registrationTime = resultSet.getTimestamp("registration_date").toLocalDateTime();
                return new QAUser(id, name, registrationTime);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int createQAUser(QAUser qaUser) {
        String sql = "INSERT INTO qa_user(name, registration_date) VALUES (?,?);";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, qaUser.getUserName());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating qa_user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteUserById(int id) {
        String sql = "DELETE FROM qa_user WHERE id = ?;";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
