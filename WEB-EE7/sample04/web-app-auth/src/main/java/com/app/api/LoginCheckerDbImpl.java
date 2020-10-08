package com.app.api;

import com.app.api.user.UserDao;

import java.util.NoSuchElementException;

public class LoginCheckerDbImpl implements LoginChecker {

    UserDao userDao;

    public LoginCheckerDbImpl() {
        userDao = new UserDao();
    }

    @Override
    public boolean isCorrect(String login, String password) {
        try {
            userDao.findByLoginAndPassword(login, password);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
