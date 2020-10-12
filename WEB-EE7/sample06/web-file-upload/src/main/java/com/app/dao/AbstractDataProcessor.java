package com.app.dao;

import com.app.model.User;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDataProcessor implements DataProcessor {

    @Resource(name = "myDS")
    private final DataSource ds;

    public AbstractDataProcessor() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/myDS");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int process(Part part) {
        try {
            List<User> users = parse(part.getInputStream());
            return insertAll(users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<User> parse(InputStream in);

    private int insertAll(List<User> users) {
        try (Connection c = ds.getConnection()) {
            c.setAutoCommit(false);
            String sql = "INSERT INTO user_role (username, password, role)  VALUES(?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            for (User user : users) {
                ps.setObject(1, user.getName());
                ps.setObject(2, user.getPassword());
                ps.setObject(3, user.getRole());
                ps.execute();
            }
            c.commit();
            return users.size();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
