package com.servlet.app.dao;

import com.servlet.app.dto.UserDTO;
import com.servlet.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection = DBConnection.getConnection();

    public boolean insert(UserDTO user){
        String insertQuery = "INSERT INTO users(full_name, email, phone) VALUES(?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(insertQuery)){
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
