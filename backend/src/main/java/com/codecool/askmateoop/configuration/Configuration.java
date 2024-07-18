package com.codecool.askmateoop.configuration;

import com.codecool.askmateoop.dao.AnswersDAO;
import com.codecool.askmateoop.dao.AnswersDaoJdbc;
import com.codecool.askmateoop.dao.QuestionsDAO;
import com.codecool.askmateoop.dao.QuestionsDaoJdbc;
import com.codecool.askmateoop.dao.model.database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootConfiguration
public class Configuration {

//    TODO: Add the url of your database to the Environment Variables of the Run Configuration

    @Value("${askmate.database.url}")
    private String databaseUrl;

    @Value("${askmate.database.password}")
    private String password;

    @Value("${askmate.database.username}")
    private String username;

    @Bean
    public DatabaseConnection createDatabaseConnection() {
        return new DatabaseConnection(databaseUrl, username, password);
    }

    @Bean
    public QuestionsDAO questionsDAO(DatabaseConnection databaseConnection) {
        return new QuestionsDaoJdbc(databaseConnection);
    }

    @Bean
    public AnswersDAO answersDAO(DatabaseConnection databaseConnection) {
        return new AnswersDaoJdbc(databaseConnection);
    }

 /*@Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(databaseUrl)
                .username(username)
                .password(password)
                .build();
    }*/
}
