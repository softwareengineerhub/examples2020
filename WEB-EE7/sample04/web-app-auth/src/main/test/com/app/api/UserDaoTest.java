package com.app.api;

import com.app.api.user.User;
import com.app.api.user.UserDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserDaoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void findByLoginAndPasswordFound() {
        String login = "denis";
        String password = "1";
        UserDao userDao = new UserDao();
        assertNotNull(userDao.findByLoginAndPassword(login, password));
    }

    @Test
    public void findByLoginAndPasswordFail() {
        String login = "denis";
        String password = "2";
        UserDao userDao = new UserDao();
        User user;
        thrown.expect(NoSuchElementException.class);
        user = userDao.findByLoginAndPassword(login, password);
        assertNull(user);
    }
}