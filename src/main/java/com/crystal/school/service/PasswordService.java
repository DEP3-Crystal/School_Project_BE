package com.crystal.school.service;

import com.crystal.school.excption.InvalidLength;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class PasswordService {

    private final Random random = new SecureRandom();
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkzlmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static PasswordService instance;

    public static synchronized PasswordService getInstance() {
        if (instance == null)
            instance = new PasswordService();
        return instance;
    }

    /**
     * @param length length of salt (min = 10 , max 100)
     * @return salt
     */
    public String getSaltValue(int length) throws InvalidLength {
        validate(length);
        StringBuilder finalVal = new StringBuilder(length);
        IntStream.range(0, length).forEach(i -> finalVal.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length()))));
        return new String(finalVal);
    }

    private void validate(int length) throws InvalidLength {
        if (length > 100 || length < 1) {
            throw new InvalidLength("Salt length should be 1 - 100");
        }
    }

    private byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    /**
     * Method to encrypt the password using the original password and salt value.
     *
     * @param password plainText password
     * @param salt     salt used to hash the password
     * @return HashedPassword
     */
    public String generateSecurePassword(String password, String salt) {
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        return Base64.getEncoder().encodeToString(securePassword);
    }

    public boolean doesPasswordMatches(String providedPassword, String securedPassword, String salt) {

        String newSecurePassword = generateSecurePassword(providedPassword, salt);
        return newSecurePassword.equals(securedPassword);
    }

}
