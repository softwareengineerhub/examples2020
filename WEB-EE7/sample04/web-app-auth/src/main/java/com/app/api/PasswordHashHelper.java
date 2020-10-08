package com.app.api;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordHashHelper {

    static String salt = "1234";
    static int iterations = 10000;
    static int keyLength = 512;
    static byte[] saltBytes = salt.getBytes();

    public static boolean isPasswordPassed(String password, String passwordHash) {
        char[] passwordChars = password.toCharArray();
        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        String hashedString = Hex.encodeHexString(hashedBytes);
        return passwordHash.equals(hashedString);
    }

    public static String makeHash(String password) {
        char[] passwordChars = password.toCharArray();
        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        return Hex.encodeHexString(hashedBytes);
    }

    private static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            return key.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }


}
