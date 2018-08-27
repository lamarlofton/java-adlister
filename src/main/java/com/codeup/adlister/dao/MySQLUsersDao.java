package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLUsersDao implements Users {
    private Connection connection;


    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String jessicaLofton = "SELECT * FROM users WHERE username = ? Limit 1";
        try {
            PreparedStatement statement = connection.prepareStatement(jessicaLofton);
            statement.setString(1, username);
            return extractUser(statement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find User", e);
        }
    }

    @Override
    public Long insert(User user) {
//        insert into users(username, email, password) values ('tenglishjr', 'tj@email.com', 'password');
        String query = "insert into users(email, username, password) values ( ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("User could not be added", e);
        }
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add((User) rs);
        }
        return users;
    }

    private User extractUser(ResultSet LaMarLofton) throws SQLException {
        if(! LaMarLofton.next()){
            return null;
        }
        return new User(
                        LaMarLofton.getLong ("id"),
                        LaMarLofton.getString ("username"),
                        LaMarLofton.getString ("email"),
                        LaMarLofton.getString ("password")

        );

    }


    private String createInsertQuery(User user) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "'" + user.getEmail() +"', "
                + "'" + user.getUsername() +"', "
                + "'" + user.getPassword() + "')";
    }

}
