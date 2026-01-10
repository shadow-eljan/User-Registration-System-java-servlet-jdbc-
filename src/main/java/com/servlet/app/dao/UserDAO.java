package com.servlet.app.dao;

import com.servlet.app.dto.UserDTO;
import com.servlet.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection = DBConnection.getConnection();

    //Insert User
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

    //Find by Email
    public UserDTO findByEmail(String email){
        String emailQuery = "SELECT * FROM users WHERE email = ?";

        try (PreparedStatement ps = connection.prepareStatement(emailQuery)){
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                UserDTO founduser = new UserDTO();
                founduser.setId(rs.getInt("id"));
                founduser.setFullName(rs.getString("full_name"));
                founduser.setEmail(rs.getString("email"));
                founduser.setPhone(rs.getString("phone"));
                return founduser;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Find user by ID
    public UserDTO findById(int id) {

        String idQuery = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(idQuery)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserDTO iduser = new UserDTO();
                iduser.setId(rs.getInt("id"));
                iduser.setFullName(rs.getString("username"));
                iduser.setEmail(rs.getString("email"));
                iduser.setPhone(rs.getString("phone"));
                return iduser;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
