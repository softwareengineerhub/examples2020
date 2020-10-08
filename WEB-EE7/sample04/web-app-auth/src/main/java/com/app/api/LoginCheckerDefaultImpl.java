package com.app.api;

public class LoginCheckerDefaultImpl implements LoginChecker {

    @Override
    public boolean isCorrect(String name, String password) {
        if ("Denis".equals(name) && "1".equals(password) || "Piter".equals(name) && "2".equals(password)) {
            return true;
        }
        return false;
    }
}
