package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import iRepository.IUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String JDBC_URL = "jdbc:h2:./data/sample";
    private static final String JDBC_USER = "admin";
    private static final String JDBC_PASSWORD = "123456";

    public UserService() {
        // create table if not exists
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String createTableSQL = "create table if not exists User (id long AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), family VARCHAR(255))";
            PreparedStatement stmt = connection.prepareStatement(createTableSQL);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addNewUser(String name, String LastName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String insertSQL = "INSERT INTO User (name, family) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, LastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
