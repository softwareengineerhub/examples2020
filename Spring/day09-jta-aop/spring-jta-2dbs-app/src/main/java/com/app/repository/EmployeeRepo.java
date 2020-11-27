package com.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class EmployeeRepo {
    @Autowired
    @Qualifier("employeeDataSource")
    private DataSource dataSource;

    public void save(String name, int age) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO employee(name, age) values(?,?)");
            ps.setObject(1, name);
            ps.setObject(2, age);
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
