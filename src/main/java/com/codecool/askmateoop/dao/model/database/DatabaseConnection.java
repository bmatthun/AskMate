package com.codecool.askmateoop.dao.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    public DatabaseConnection(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", dbUser);
        properties.setProperty("password", dbPassword);
        Connection connection = DriverManager.getConnection(dbUrl, properties);
        return connection;
    }
}
