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
    private DataSource ds;

    public AbstractDataProcessor() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/myDS");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void process(Part part) {
        try {
            List<User> users = parse(part.getInputStream());
            insertAll(users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<User> parse(InputStream in);

    private void insertAll(List<User> users) {
        try (Connection c = ds.getConnection()) {
            c.setAutoCommit(false);
            String sql = "INSERT INTO user_role (username, password, role)  VALUES(?,?,?)";
            PreparedStatement ps = null;
            for (User user : users) {
                ps = c.prepareStatement(sql);
                ps.setObject(1, user.getName());
                ps.setObject(2, user.getPasword());
                ps.setObject(3, user.getRole());
                ps.execute();
            }
            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
