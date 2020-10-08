package com.app.api.user;

import com.app.api.PasswordHashHelper;

import java.sql.*;
import java.util.NoSuchElementException;

public class UserDao {

    public User findByLoginAndPassword(String login, String password) {
        try (Connection c = getConnection()) {
            String sql = "SELECT u.login, u.name, r.is_admin " +
                    "FROM user u INNER JOIN role r ON u.id_role=r.id " +
                    "WHERE login=? AND u.password=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, login.toLowerCase());
            ps.setObject(2, PasswordHashHelper.makeHash(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                boolean isAdmin = rs.getInt("is_admin") > 0;
                return new User(login, name, isAdmin);
            } else {
                throw new NoSuchElementException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://192.168.1.250:3306/test_site?useSSL=false", "inna", "inna");
    }

}
