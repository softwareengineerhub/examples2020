package com.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CompanyRepo {
    @Autowired
    @Qualifier("companyDataSource")
    private DataSource dataSource;

    public void save(String title) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO company(company_name) values(?)");
            ps.setObject(1, title);
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
