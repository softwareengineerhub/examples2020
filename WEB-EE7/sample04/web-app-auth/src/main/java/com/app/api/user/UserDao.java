package com.app.api.user;

import com.app.api.PasswordHashHelper;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * in conf/connection.xml:
     * <p>
     * <Resource name="jdbc/Database" auth="Container"
     * type="javax.sql.DataSource"
     * maxActive="100" maxIdle="30" maxWait="10000"
     * username="_____"
     * password="_____"
     * driverClassName="com.mysql.jdbc.Driver"
     * url="jdbc:mysql://[host]:3306/test_site"/>
     *
     * @return connection to MySQL database for authentication
     * @throws SQLException
     * @throws NamingException
     */
    private Connection getConnection() throws SQLException, NamingException {
        InitialContext envContext = new InitialContext();
        DataSource ds = (DataSource) envContext.lookup("java:comp/env/jdbc/Database");
        return ds.getConnection();
    }

}
