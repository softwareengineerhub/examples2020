package com.app.api;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordHashHelperTest {

    @Test
    public void goodPasswordPassed() {
        String password = "2";
        String hashed = PasswordHashHelper.makeHash(password);
        assertTrue(PasswordHashHelper.isPasswordPassed(password, hashed));
//        assertFalse(PasswordHashHelper.isPasswordPassed("password", hashed));
    }

    @Test
    public void badPasswordFail() {
        String password = "2";
        String hashed = PasswordHashHelper.makeHash(password);
        boolean result = PasswordHashHelper.isPasswordPassed("3", hashed);
        assertFalse(result);
    }
}