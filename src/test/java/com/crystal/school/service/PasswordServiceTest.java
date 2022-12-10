package com.crystal.school.service;

import com.crystal.school.excption.InvalidLength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordServiceTest {

    private final PasswordService passwordService = new PasswordService();
    int length = 10;
    String password = "testPassword";
    String salt;
    @BeforeEach
    void beforeAll() throws InvalidLength {
        salt = passwordService.getSaltValue(10);
    }
    @Test
    void getSaltValue_ThrowsInvalidLength() {
        Assertions.assertThrows(InvalidLength.class, () -> passwordService.getSaltValue(-10));
    }

    @Test
    void getSaltValue_CheckLength() throws InvalidLength {
        String saltValue = passwordService.getSaltValue(length);
        Assertions.assertEquals(length, saltValue.length());
    }

    @Test
    void generateSecurePassword_DoesNotContainOrg() throws InvalidLength {
        String salt = passwordService.getSaltValue(10);
        String securePassword = passwordService.generateSecurePassword(password, salt);
        Assertions.assertFalse(securePassword.contains(password));
    }
    @Test
    void generateSecurePassword_MoreCharacters() {

        String securePassword = passwordService.generateSecurePassword(password, salt);
        Assertions.assertTrue(securePassword.length() > password.length());
    }

    @Test
    void doesPasswordMatches() {
        String securePassword = passwordService.generateSecurePassword(password, salt);
        Assertions.assertTrue(passwordService.doesPasswordMatches(password, securePassword, salt));
    }
}